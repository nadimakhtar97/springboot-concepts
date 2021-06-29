package com.nadim.springsecurity2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FooBarRepository extends JpaRepository<FooBarUser, Integer> {

    FooBarUser findByUserName(String name);
}
