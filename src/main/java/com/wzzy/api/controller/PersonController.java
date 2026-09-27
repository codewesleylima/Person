package com.wzzy.api.controller;

import com.wzzy.api.dto.request.PersonCreateRequest;
import com.wzzy.api.dto.request.PersonUpdateRequest;
import com.wzzy.api.dto.response.PersonResponse;
import com.wzzy.api.entity.PersonEntity;
import com.wzzy.api.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    public ResponseEntity<PersonResponse> personCreate(
            @Valid @RequestBody PersonCreateRequest personCreateRequest) {

        PersonResponse newPersonResponse =
                personService.personCreate(personCreateRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newPersonResponse);

    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<PersonResponse> personUpdate(
            @PathVariable String personId,
            @Valid @RequestBody PersonUpdateRequest personUpdateRequest) {

        PersonResponse personUpdateResponse =
                personService.personUpdate(personId, personUpdateRequest);

        return ResponseEntity.ok(personUpdateResponse);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonResponse> findPerson(
            @PathVariable String personId) {

        PersonResponse personResponse = PersonResponse.fromEntity(personService.findPersonEntityById(personId));

        return ResponseEntity.ok(personResponse);
    }

    @GetMapping("/all")
    public List<PersonEntity> findAll() {
        return personService.findPersonEntityAll();
    }

    @DeleteMapping("{personId}")
    void deletePerson (@PathVariable String personId){
        personService.deletePersonEntity(personId);
    }
}
