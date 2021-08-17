package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class BooksController {

    private final BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("booksList")
    public List<Book> bookList(){
        return bookService.getBooksData();
    }

    //Новинки — файл /books/recent.html
//    @ModelAttribute("booksList")
//    public List<Book> bookList(){
//        return bookService.getBooksData();
//    }
    @GetMapping("/books/recent")
    public String recentBookPage(){
        return "books/recent";
    }

    //Популярное — /books/popular.html

    @GetMapping("/books/popular")
    public String popularBookPage(){
        return "books/popular";
    }
}
