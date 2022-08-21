package com.oguzhanserttas.blog.service.impl;

import com.oguzhanserttas.blog.domain.Person;
import com.oguzhanserttas.blog.repository.PersonRepository;
import com.oguzhanserttas.blog.service.PersonService;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Person}.
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person person) {
        log.debug("Request to save Person : {}", person);
        person.setCreatedAt(Instant.now());
        return personRepository.save(person);
    }

    @Override
    public Person update(Person person) {
        log.debug("Request to save Person : {}", person);
        person.setUpdatedAt(Instant.now());
        return personRepository.save(person);
    }

    @Override
    public Optional<Person> partialUpdate(Person person) {
        log.debug("Request to partially update Person : {}", person);
        person.setUpdatedAt(Instant.now());
        return personRepository
            .findById(person.getId())
            .map(existingPerson -> {
                if (person.getEmail() != null) {
                    existingPerson.setEmail(person.getEmail());
                }
                if (person.getName() != null) {
                    existingPerson.setName(person.getName());
                }
                if (person.getPassword() != null) {
                    existingPerson.setPassword(person.getPassword());
                }
                if (person.getPhoneNumber() != null) {
                    existingPerson.setPhoneNumber(person.getPhoneNumber());
                }
                if (person.getCreatedAt() != null) {
                    existingPerson.setCreatedAt(person.getCreatedAt());
                }
                if (person.getUpdatedAt() != null) {
                    existingPerson.setUpdatedAt(person.getUpdatedAt());
                }

                return existingPerson;
            })
            .map(personRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> findAll() {
        log.debug("Request to get all People");
        return personRepository.findAll();
    }

    public Page<Person> findAllWithEagerRelationships(Pageable pageable) {
        return personRepository.findAllWithEagerRelationships(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> findOne(Long id) {
        log.debug("Request to get Person : {}", id);
        return personRepository.findOneWithEagerRelationships(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Person : {}", id);
        personRepository.deleteById(id);
    }
}
