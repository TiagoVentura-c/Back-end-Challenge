package com.example.challenge.service;

import com.example.challenge.exception.NegotiationException;
import com.example.challenge.models.Article;
import com.example.challenge.repository.ArticleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository repository;

    @Transactional
    public Article save(Article article){
        return repository.save(article);
    }

    @Transactional
    public Page<Article> getAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    @Transactional
    public Article get(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new NegotiationException("Artigo não encontrado"));
    }

    @Transactional
    public Article update(Long id, Article articleSource){
        Article articleTarget = repository.findById(id)
                .orElseThrow(() -> new NegotiationException("Artigo não encontrado"));

        System.out.println("-------- " + articleTarget.toString());

        BeanUtils.copyProperties(articleSource, articleTarget, Article.class);

        System.out.println("++++++++  " + articleSource.toString());
        System.out.println("-------- " + articleTarget.toString());

        articleTarget.setId(id);

        return repository.save(articleTarget);
    }

    public void delete(Long id) {
        if (!repository.existsById(id))
            throw(new NegotiationException("Artigo não encontrado"));
        repository.deleteById(id);
    }
}
