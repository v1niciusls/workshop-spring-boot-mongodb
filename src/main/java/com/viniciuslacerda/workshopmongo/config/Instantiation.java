package com.viniciuslacerda.workshopmongo.config;

import com.viniciuslacerda.workshopmongo.domain.User;
import com.viniciuslacerda.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria = new User("1", "maria", "maria@gmail.com");
        User jorge = new User("2", "jorge", "jorge@gmail.com");
        User pedro = new User("3", "pedro", "pedro@gmail.com");

        userRepository.saveAll(Arrays.asList(pedro,jorge,maria));
    }
}



