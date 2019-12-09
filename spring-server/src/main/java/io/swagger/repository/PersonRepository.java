package io.swagger.repository;

import io.swagger.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PersonRepository extends CrudRepository<Person, String> {
	
}