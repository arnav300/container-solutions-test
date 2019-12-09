package io.swagger.service;

import io.swagger.model.People;
import io.swagger.model.Person;
import io.swagger.model.PersonData;
import io.swagger.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PeopleService {

	/*
	 * PersonRepository to access person Objects from database
	 */
	@Autowired
	PersonRepository personRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(PeopleService.class);

	/*
	 * peopleList Method to get person list as people
	 */
	public People peopleList(People people) {
		LOGGER.info("Entering peopleList Method...");
		List<Person> personList = (List<Person>) personRepository.findAll();
		people.addAll(personList);
		LOGGER.debug("Person List value is {} ", personList);
		LOGGER.info("Exiting peopleList Method...");
		return people;
	}

	/*
	 * peopleAdd Method to add person to database
	 */
	public Person peopleAdd(PersonData personData) {
		LOGGER.info("Entering peopleAdd Method...");
		Person person = getPersonFromPersonData(personData);
		person = personRepository.save(person);
		LOGGER.debug("Persisted Person Object uuid  {} ", person.getUuid());
		LOGGER.info("Exiting peopleAdd Method...");
		return person;

	}

	/*
	 * getPersonFromPersonData Method to transform and create person object from
	 * personData object
	 */
	private Person getPersonFromPersonData(PersonData pd) {
		LOGGER.info("Entering getPersonFromPersonData Method...");
		Person person = new Person();
		person.setAge(pd.getAge());
		person.setFare(pd.getFare());
		person.setUuid(UUID.randomUUID().toString());
		person.setName(pd.getName());
		person.setParentsOrChildrenAboard(pd.getParentsOrChildrenAboard());
		person.setPassengerClass(pd.getPassengerClass());
		person.setSurvived(pd.isSurvived());
		person.setSiblingsOrSpousesAboard(pd.getSiblingsOrSpousesAboard());
		person.setSex(pd.getSex());
		LOGGER.debug("Person Object created with uuid  {} ", person.getUuid());
		LOGGER.info("Exiting getPersonFromPersonData Method...");
		return person;
	}

	/*
	 * personGet Method to get person from database
	 */
	public Person personGet(String uuid) {
		LOGGER.info("Entering personGet Method...");
		Person person = personRepository.findOne(uuid);
		if (person != null) {
			LOGGER.debug("Person Object retrieved with uuid  {} ", person.getUuid());
			LOGGER.info("Exiting personGet Method...");
		} else
			LOGGER.info("UUID is incorrect or not present");
		return person;

	}

	/*
	 * personUpdate Method to update person and update in database
	 */
	public Person personUpdate(String uuid, PersonData persondata) {
		LOGGER.info("Entering personUpdate Method...");
		Person person = getPersonFromPersonData(persondata);
		person.setUuid(uuid);

		person = personRepository.save(person);
		LOGGER.debug("Person Object updated and saved with uuid {} ", uuid);
		LOGGER.info("Exiting personUpdate Method...");
		return person;

	}

	/*
	 * personDelete Method to delete person in database
	 */
	public void personDelete(String uuid) throws Exception {
		LOGGER.info("Entering personDelete Method...");
		personRepository.delete(uuid);
		LOGGER.debug("Person Object deleted", uuid);
		LOGGER.info("Exiting personDelete Method...");
	}

}
