package com.wzzy.api.service;

import com.wzzy.api.dto.request.PersonCreateRequest;
import com.wzzy.api.dto.request.PersonUpdateRequest;
import com.wzzy.api.dto.response.PersonResponse;
import com.wzzy.api.entity.PersonEntity;
import jakarta.transaction.Transactional;

import java.util.List;

public interface PersonService {
    @Transactional
    PersonResponse personCreate(PersonCreateRequest personCreateRequest);

    @Transactional
    PersonResponse personUpdate(String personiD, PersonUpdateRequest personUpdateRequest);

    PersonEntity findPersonEntityById(String personId);

    List<PersonEntity> findPersonEntityAll();

    void deletePersonEntity(String personId);
}
