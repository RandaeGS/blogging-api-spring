package controllers;

import encapsulations.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import repositories.AuthorRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/")
    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    @GetMapping("/")
    public ResponseEntity<?> getAuthor(@PathVariable UUID id){
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Author author = authorOptional.get();
        return ResponseEntity.ok(author);
    }
}
