package com.blog.repository;

import com.blog.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by tk on 16-4-23.
 */
public interface ArticleRepository extends CrudRepository<Article, Long> {
    Page<Article> findAll(Pageable pageable);
}
