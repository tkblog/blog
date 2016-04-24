package com.blog.service;

import com.blog.domain.Article;

import java.util.List;

/**
 * Created by tk on 16-4-23.
 */
public interface ArticleService {
    List<Article> findAll();

    Article get(Long id);
}
