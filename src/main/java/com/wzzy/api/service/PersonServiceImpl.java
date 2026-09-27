package com.wzzy.api.service;

import com.wzzy.api.dto.request.PersonCreateRequest;
import com.wzzy.api.dto.request.PersonUpdateRequest;
import com.wzzy.api.dto.response.PersonResponse;
import com.wzzy.api.entity.PersonEntity;
import com.wzzy.api.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Transactional
    @Override
    public PersonResponse personCreate(PersonCreateRequest personCreateRequest){
        PersonEntity personEntity = new PersonEntity();

        personEntity.setName(personCreateRequest.name());
        personEntity.setOld(personCreateRequest.old());
        personEntity.setCity(personCreateRequest.city());
        personEntity.setJob(personCreateRequest.job());

        PersonEntity savedPersonEntity = personRepository.save(personEntity);

        return PersonResponse.fromEntity(savedPersonEntity);
    }

    @Transactional
    @Override
    public PersonResponse personUpdate(String personId, PersonUpdateRequest personUpdateRequest) {
        PersonEntity personEntity = findPersonEntityById(personId);

        personEntity.setName(personUpdateRequest.name());
        personEntity.setOld(personUpdateRequest.old());
        personEntity.setCity(personUpdateRequest.city());
        personEntity.setJob(personUpdateRequest.job());

        return PersonResponse.fromEntity(personEntity);
    }

    @Override
    public PersonEntity findPersonEntityById(String personId) {
        return personRepository.findById(personId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Person not found: " + personId));

    }

    @Override
    public List<PersonEntity> findPersonEntityAll(){
        return personRepository.findAll();
    }

    @Override
    public void deletePersonEntity(String personId) {
         personRepository.deleteById(personId);

    }
}
