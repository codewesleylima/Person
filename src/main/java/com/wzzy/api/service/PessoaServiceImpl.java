package com.wzzy.api.service;

import com.wzzy.api.dto.request.PersonCreateRequest;
import com.wzzy.api.dto.request.PersonUpdateRequest;
import com.wzzy.api.dto.response.PersonResponse;
import com.wzzy.api.entity.Person;
import com.wzzy.api.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PersonRepository personRepository;

    public PessoaServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Transactional
    public PersonResponse personCreate(PersonCreateRequest personCreateRequest){
        Person person = new Person();

        person.setName(personCreateRequest.name());
        person.setCity(personCreateRequest.city());
        person.setJob(personCreateRequest.job());
        person.setOld(personCreateRequest.old());

        Person savedPerson = personRepository.save(person);
        return PersonResponse.fromEntity(savedPerson);
    }

    public Person findPersonEntityById(String personId) {
        return personRepository.findById(personId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Car not found: " + personId));
        }
    }

    @Transactional
    public PersonResponse findById(String personId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new EntityNotFoundException("Person not Found"));

        return PersonResponse.fromEntity(person);
    }

    @Transactional
    public PersonResponse personUpdate(String personId, PersonUpdateRequest personUpdateRequest) {
        Person person = findById(personId);

        person.setPersonId(personUpdateRequest.personId());
        person.setName(personUpdateRequest.name());
        person.setCity(personUpdateRequest.city());
        person.setCity(personUpdateRequest.city());
        person.setOld(personUpdateRequest.old());
    }
}
