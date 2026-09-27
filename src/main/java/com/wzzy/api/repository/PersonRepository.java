package com.wzzy.api.repository;

import com.wzzy.api.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, String> {

}
