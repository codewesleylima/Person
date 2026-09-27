package com.wzzy.api.dto.response;

import com.wzzy.api.entity.PersonEntity;

public record PersonResponse(
        String personId,
        String name,
        String old,
        String city,
        String job

) {
    public static PersonResponse fromEntity(PersonEntity personEntity) {
        return new PersonResponse(
                personEntity.getPersonId(),
                personEntity.getName(),
                personEntity.getOld(),
                personEntity.getCity(),
                personEntity.getJob()
        );
    }
}
