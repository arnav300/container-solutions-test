#!/bin/bash

CMD=$1

IMAGE_TAG=11.0

IMAGE_NAME="docker.io/arnav30/mysql"

CONTAINER_NAME="mysql"
#kubectl get pods | grep -i my* | awk '{print $1}' | grep -i my-da*"
echo $CONTAINER_NAME

DATABASE_NAME="person"

MYSQL_ROOT_PASSWORD="root"

DATABASE_PORT="3306"

DATABASE_TARGET_PORT="3306"

REST_CONTAINER_NAME="rest-api"

REST_URL="jdbc:mysql://$CONTAINER_NAME/person?useSSL=false"

REST_APP_PORT="8080"

REST_IMAGE_NAME="docker.io/arnav30/rest"

REST_IMAGE_TAG="1.0"

REST_APP_NAME="rest-api"

REST_TARGET_PORT="8080"

REST_PORT_TYPE="NodePort"


case $CMD in
    build)
        docker build -t  $IMAGE_NAME .
        ;;

    init)
        CMD="kubectl run"
        CMD="$CMD  $CONTAINER_NAME"
        CMD="$CMD --env=MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASSWORD"
        CMD="$CMD --image=$IMAGE_NAME:$IMAGE_TAG"
        echo "$CMD"
	eval $CMD;

	REST_CMD="kubectl run"
	REST_CMD="$REST_CMD $REST_CONTINER_NAME"
	REST_CMD="$REST_CMD --env=spring.datasource.url=$REST_URL"
	REST_CMD="$REST_CMD --image=$REST_IMAGE_NAME:$REST_IMAGE_TAG"
	REST_CMD="$REST_CMD $REST_APP_NAME"
	REST_CMD="$REST_CMD --port=$REST_APP_PORT"
	

	sleep 60

export POD_NAME=`kubectl get pods | awk '{print $1}' | grep -i mysql`
echo "Hello Pod"
echo $POD_NAME
        echo "Waiting for mysql start"
       # while ! kubectl exec -it  $POD_NAME mysqladmin -p$MYSQL_ROOT_PASSWORD ping &>/dev/null ; do sleep 1 ; done

        sleep 10

        echo "Loading database data"
kubectl exec -it $POD_NAME -c $CONTAINER_NAME -- mysql -p$MYSQL_ROOT_PASSWORD $DATABASE_NAME -e "LOAD DATA LOCAL INFILE 'var/lib/mysql-files/titanic.csv' INTO TABLE person FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\n' IGNORE 1 ROWS (survived,passenger_class,name,sex,age,siblings_or_spouses_aboard,parents_or_children_aboard,fare,@uuid) SET uuid=UUID()";

        echo "Exposing mysql container deployment"
	sleep 20
        kubectl expose deployment $CONTAINER_NAME --port=$DATABASE_PORT --target-port=$DATABASE_TARGET_PORT

	echo "Creating REST container using command $REST_CMD"
	sleep 30
	eval $REST_CMD;
	
	sleep 60
	echo "Creating a Ingress URL and exposing the target port for REST API"
	kubectl expose deployment $REST_CONTAINER_NAME --target-port=$REST_TARGET_PORT --type=$REST_PORT_TYPE
	sleep 30
	echo "Starting the Minikube service. Please use this URL in your postman to fetch the data."
	minikube service $REST_CONTAINER_NAME --url
        ;;

    stop)
        kubectl stop $CONTAINER_NAME
        ;;
    remove)
        kubectl rm -f $CONTAINER_NAME
        ;;
    rmi)
        kubectl rmi -f $CONTAINER_NAME
        ;;
    *)
        echo "Usage : build | start <image_tag> | stop | remove | rmi"
        ;;
esac

exit 0


