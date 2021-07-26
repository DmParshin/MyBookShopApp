package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
public class AuthorsPageController {

    private final BookService bookService;

    @Autowired
    public AuthorsPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/index")
    public String authorsPage(){
        return "authors/index";
    }
}
