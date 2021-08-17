package com.example.MyBookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenresController {

    //Книги по жанру — /genres/index.html
    @GetMapping("/genres")
    public String postponedBookPage(){
        return "/genres/index";
    }
}
