# container-solutions-test
Assignment

The detailed documentation for the assigment is present here : https://docs.google.com/document/d/1JV0F-BTfcucUld6pVtmf3tqruY_xZxyiiaMUW9st9aM/edit?usp=sharing

Assumptions :
- Postman/curl client is installed and running.
- Insert your titanic.csv file in /var/lib/mysql-files directory.
- MySQL version : 5.7 to build the image
- Minikube is running.
- Kubectl is installed
- Ingress controller is running in minikube.

Single script to start your containers.

- minikube start
- minikube addons enable ingress
Run the bash script to create containers
- ./database_kubernetes.sh init
The output of this script will display a URL. Use this URL to fetch data in postman
GET : $URL/people


You can also create an ingress resource.save the URL, hostname in /etc/hosts and use the name instead of IP.
Make sure all pods are in RUNNING state.




