package com.wzzy.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "TB_PERSON_DATA")
@Entity(name = "person")
@Getter
@Setter
@NoArgsConstructor
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String personId;
    private String name;
    private String old;
    private String city;
    private String job;


}
