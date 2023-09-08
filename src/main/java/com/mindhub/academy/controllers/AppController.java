package com.mindhub.academy.controllers;

import com.mindhub.academy.models.Person;
import com.mindhub.academy.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/persons/register")
    public ResponseEntity<Object> register(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password) {

        if (firstName.isBlank() || lastName.isBlank() || password.isBlank() || email.isBlank()) {
            return new ResponseEntity<>("Missing value", HttpStatus.FORBIDDEN);
        }

        if (personRepository.findByEmail(email) != null) {
            return new ResponseEntity<>("Mail already in use", HttpStatus.FORBIDDEN);
        }

        Person person = new Person(firstName, lastName, passwordEncoder.encode(password), email);
        personRepository.save(person);
        return new ResponseEntity<>("Register", HttpStatus.CREATED);
    }

    @GetMapping("/persons")
    public String redireccion(Authentication authentication) {
        Person persona = personRepository.findByEmail(authentication.getName());
         if (persona.getRolType().ordinal() == 0) {//admin
            return "/web/admin.html";
        }
        if (persona.getRolType().ordinal() == 1) {//teacher
            return "/web/teacher.html";
        }

        return "/web/student.html";//student
    }


}
