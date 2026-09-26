package com.wzzy.api.dto.response;

import com.wzzy.api.entity.Person;

public record PersonResponse(
        String personId,
        String old,
        String name,
        String city,
        String job

) {
    public static PersonResponse fromEntity(Person person) {
        return new PersonResponse(
                person.getPersonId(),
                person.getName(),
                person.getCity(),
                person.getJob(),
                person.getOld()
        );
    }
}
