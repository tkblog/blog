package com.blog.controllers;

import com.blog.domain.Article;
import com.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by tk on 16-4-23.
 */
@Controller
@Scope("singleton")
@RequestMapping("/article")
public class ArticleController extends AbstractWebController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public String index(@PathVariable Long id,
                        Map map) {
        final Article article = articleService.get(id);
        map.put("article", article);
        return "article";
    }
}
