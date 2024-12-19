package com.blogging.bloggingapispring.controllers;

import com.blogging.bloggingapispring.encapsulations.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.blogging.bloggingapispring.repositories.AuthorRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/")
    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthor(@PathVariable UUID id){
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Author author = authorOptional.get();
        return ResponseEntity.ok(author);
    }

    @PostMapping("")
    public ResponseEntity<?> createAuthor(@RequestBody Author author) {
        try {
            authorRepository.save(author);
            return new ResponseEntity<>("Author succesfully created", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating author! Try again!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable UUID id){
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isEmpty()) {
            return new ResponseEntity<>("Author not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Author succesfully deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable UUID id){
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isEmpty()) {
            return new ResponseEntity<>("Author not found", HttpStatus.NOT_FOUND);
        }
        authorRepository.save(authorOptional.get());
        return new ResponseEntity<>("Author updated succesfully", HttpStatus.OK);
    }
}
