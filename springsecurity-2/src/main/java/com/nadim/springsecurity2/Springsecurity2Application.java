package com.nadim.springsecurity2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springsecurity2Application implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(Springsecurity2Application.class, args);
    }

    @Autowired
    FooBarRepository fooBarRepository;

    @Override
    public void run(String... args) throws Exception {

		/*
		user Nadim --> pass: nadim_root --> bcrypt encode pass --> $2a$10$PTUedN/ePmSnTN9bvtXaU.674elUzfmxpP6xST6wdxTLJmmgNMmMq
		user Lee --> pass: lee_root --> bcrypt encode pass --> $2a$10$AbJITA3ld1jTdanD7xfvJ.ZPwrgnVtiM87JziBUqcB2wpkoIU/L0q
		 */
//		FooBarUser user1 = new FooBarUser("Nadim","$2a$10$PTUedN/ePmSnTN9bvtXaU.674elUzfmxpP6xST6wdxTLJmmgNMmMq",true, "admin:student",true);
//		FooBarUser user2 = new FooBarUser("Lee","$2a$10$AbJITA3ld1jTdanD7xfvJ.ZPwrgnVtiM87JziBUqcB2wpkoIU/L0q",true, "student",true);
//
//		fooBarRepository.save(user1);
//		fooBarRepository.save(user2);


    }
}
