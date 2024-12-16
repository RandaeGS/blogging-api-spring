package controllers;

import encapsulations.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.ArticleRepository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public List<Article> getArticles(){
        return articleRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable UUID id){
        if (!articleRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        articleRepository.deleteById(id);
        Map<String,String> response = Map.of("Message", "User succesfully deleted");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/")
    public ResponseEntity<String> createArticle(@RequestBody Article article){
        articleRepository.save(article);
        return ResponseEntity.ok("Article created succesfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateArticle(@PathVariable UUID id){
        boolean exists = articleRepository.existsById(id);
        if (!exists) {
            return ResponseEntity.notFound().build();
        }
        articleRepository.save(articleRepository.findById(id).get());
        return ResponseEntity.ok("Article succesfully updated");
    }
}
