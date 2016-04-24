package com.blog.controllers;

import com.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by tk on 16-4-21.
 */
@Controller
@Scope("singleton")
public class IndexController extends AbstractWebController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("articles", articleService.findAll());
        return "index";
    }

}
