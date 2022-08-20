package com.example.test.core.visitor.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String userAgent;
}
