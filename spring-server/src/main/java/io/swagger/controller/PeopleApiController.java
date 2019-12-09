package io.swagger.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.People;
import io.swagger.model.Person;
import io.swagger.model.PersonData;
import io.swagger.service.PeopleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.UUID;


/*
 * PeopleApiController is implementation of PeopleApi which is overriding all the methods present inside PeopleApi interface
 * */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-21T05:01:38.936Z")
@Controller
public class PeopleApiController implements PeopleApi {
    /*
     * People Service Object to use service layer
     * */
    @Autowired
    private PeopleService peopleService;


    private static final Logger LOGGER = LoggerFactory.getLogger(PeopleApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PeopleApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    /*
     * PeopleAdd Controller to Create new Person Object
     * */
    public ResponseEntity<Person> peopleAdd(@ApiParam(value = "", required = true) @Valid @RequestBody PersonData personData) {
        Person person = null;
        LOGGER.info("Entering peopleAdd Method...");
        try {
            person = peopleService.peopleAdd(personData);
            LOGGER.debug("Person Object created with uuid {}", person.getUuid());
            if (person != null) {
                LOGGER.info("Exiting peopleAdd Method...");
                return new ResponseEntity<Person>(person, HttpStatus.OK);
            }
            LOGGER.debug("Response of New Person with uuid {} is generated", person.getUuid());
            LOGGER.info("Exiting peopleAdd Method...");
            return new ResponseEntity<Person>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            LOGGER.error("Exception in creating New Person Object : {} ", ex);
            return new ResponseEntity<Person>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /*
     * peopleList Controller to get Person List as People Object
     * */
    public ResponseEntity<People> peopleList() {
        LOGGER.info("Entering peopleList Method...");
        People people = new People();
        try {
            people = (People) peopleService.peopleList(people);
            if (people == null) {
                throw new Exception("Error in creating People Object value is null");
            }
            LOGGER.debug("Person List as People is generated with size {}", people.size());
            LOGGER.info("Exiting peopleList Method...");
            return new ResponseEntity<People>(people, HttpStatus.OK);

        } catch (Exception ex) {
            LOGGER.error("Exception in creating  People Object : {} ", ex);
            return new ResponseEntity<People>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
     * personDelete Controller to delete Person object using uuid
     * */
    public ResponseEntity<Void> personDelete(@ApiParam(value = "", required = true) @PathVariable("uuid") String uuid) {
        LOGGER.info("Entering personDelete Method...");
        try {
            peopleService.personDelete(uuid);
            LOGGER.debug("Person Object with uuid is deleted {}", uuid);
            LOGGER.info("Exiting personDelete Method...");
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error("Exception in creating  People Object : {} ", ex);
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /*
     * personGet Controller to get Person object using uuid
     * */
    public ResponseEntity<Person> personGet(@ApiParam(value = "", required = true) @PathVariable("uuid") String uuid) {
        LOGGER.info("Entering personGet Method...");
        try {
            Person person = peopleService.personGet(uuid);
            LOGGER.info("Exiting personGet Method...");
            LOGGER.debug("Person Object with uuid {} is retrieved ", uuid);
            return new ResponseEntity<Person>(person, HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error("Exception in retriving Person object {}", ex);
            return new ResponseEntity<Person>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /*
     * personGet Controller to Update Person object using uuid
     * */
    public ResponseEntity<Person> personUpdate(@ApiParam(value = "", required = true) @PathVariable("uuid") String uuid, @ApiParam(value = "", required = true) @Valid @RequestBody PersonData person) {
        LOGGER.info("Entering personUpdate Method...");
        try {
            Person personObj = peopleService.personUpdate(uuid, person);
            LOGGER.debug("Person Object is updated having uuid {}", personObj.getUuid());
            LOGGER.info("Exiting personUpdate Method...");
            return new ResponseEntity<Person>(personObj, HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error("Exception in updating Person object {}", ex);
            return new ResponseEntity<Person>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	



	

	

}
