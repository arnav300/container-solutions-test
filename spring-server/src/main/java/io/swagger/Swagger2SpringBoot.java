package io.swagger;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.swagger.repository.PersonRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "io.swagger", "io.swagger.api" , "io.swagger.configuration"})
public class Swagger2SpringBoot implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Swagger2SpringBoot.class);
	
	@Autowired
	private PersonRepository repository;

    @Override
    public void run(String... arg0) throws Exception {
    	
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
//    	try (InputStream in = new FileInputStream("/home/abhati/Documents/pulkit-final/SpringBootCRUD-master/spring-server/src/main/resources/titanic.csv");) {
//    	    CSV csv = new CSV(true, ',', in );
//    	    List < String > fieldNames = null;
//    	    if (csv.hasNext()) fieldNames = new ArrayList < > (csv.next());
//    	    List < Map < String, String >> list = new ArrayList < > ();
//    	    while (csv.hasNext()) {
//    	        List < String > x = csv.next();
//    	        Map < String, String > obj = new LinkedHashMap < > ();
//    	        for (int i = 0; i < fieldNames.size(); i++) {
//    	            obj.put(fieldNames.get(i), x.get(i));
//    	        }
//    	        list.add(obj);
//    	    }
//    	    ObjectMapper mapper = new ObjectMapper();
//    	    mapper.enable(SerializationFeature.INDENT_OUTPUT);
//    	    mapper.writeValue(System.out, list);
//    	}
        new SpringApplication(Swagger2SpringBoot.class).run(args);
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
