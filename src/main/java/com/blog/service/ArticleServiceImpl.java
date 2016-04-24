package com.blog.service;

import com.blog.domain.Article;
import com.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.util.Assert.notNull;

/**
 * Created by tk on 16-4-23.
 */
@Component("articleService")
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAll() {
        final Page<Article> page = articleRepository.findAll(new PageRequest(0, 1000));
        return page.getContent();
    }

    @Override
    public Article get(Long id) {
        notNull(id, "id not null");
        return articleRepository.findOne(id);
    }


}
