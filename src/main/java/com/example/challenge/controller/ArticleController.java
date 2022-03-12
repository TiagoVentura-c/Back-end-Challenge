package com.example.challenge.controller;

import com.example.challenge.exception.NegotiationException;
import com.example.challenge.models.Article;
import com.example.challenge.repository.ArticleRepository;
import com.example.challenge.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

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
    public ResponseEntity<?> insert(@RequestBody Article article){
        return null;
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody List<Article> articles){

        if(articles.size() == 1)
            return ResponseEntity.ok(repository.save(articles.get(0)));
        else
            return  ResponseEntity.ok(repository.saveAll(articles));
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
