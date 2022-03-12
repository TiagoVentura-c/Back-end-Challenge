package com.example.challenge.controller;

import com.example.challenge.models.Article;
import com.example.challenge.repository.ArticleRepository;
import com.example.challenge.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    private ArticleService service;
    @Autowired
    private ArticleRepository repository;

    @GetMapping
    public ResponseEntity<Page<Article>> getAll(Pageable pageable){
        repository.findAll(pageable);
        return ResponseEntity.ok(service.getAll(pageable));
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
