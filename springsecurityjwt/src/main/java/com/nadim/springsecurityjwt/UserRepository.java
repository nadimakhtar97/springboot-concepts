package com.nadim.springsecurityjwt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUserName(String name);
}
