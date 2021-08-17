package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks(){
        return bookService.getBooksData();
    }
    @GetMapping("/")
    public String mainPage(){
        return "index";
    }

    //Отложенное — /postponed.html
    @GetMapping("/postponed")
    public String postponedPage() {
        return "postponed";
    }

    //Корзина — /cart.html
    @GetMapping("/cart")
    public String cartPage() {
        return "cart";
    }

    //Войти — /signin.html
    @GetMapping("/signin")
    public String signinPage() {
        return "signin";
    }

    //Поиск — /search/index.html
    @GetMapping("/search")
    public String searchPage() {
        return "/search/index";
    }

    //Документы — /documents/index.html
    @GetMapping("/documents")
    public String documentsPage() {
        return "/documents/index";
    }

    //О компании — /about.html
    @GetMapping("/about")
    public String aboutPage() {
        return "/about";
    }

    //Помощь — /faq.html
    @GetMapping("/faq")
    public String faqPage() {
        return "/faq";
    }

    //Контакты — /contacts.html
    @GetMapping("/contacts")
    public String contactsPage() {
        return "/contacts";
    }

}
