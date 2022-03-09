package com.example.challenge.controller;

import com.example.challenge.models.Article;
import com.example.challenge.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    private ArticleService service;

    @GetMapping
    public ResponseEntity<List<Article>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getOne(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    public ResponseEntity<Article> insert(@RequestBody Article article){
        Article flightSaved = service.save(article);
        return ResponseEntity.ok(flightSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody Article article){
        return ResponseEntity.ok((service.update(id, article)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}
