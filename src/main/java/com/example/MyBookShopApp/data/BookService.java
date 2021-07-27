package com.example.MyBookShopApp.data;

import com.example.MyBookShopApp.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooksData(){
        List<Book> books = jdbcTemplate.query("SELECT * FROM books", (ResultSet rs, int rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));

            Integer authorId = jdbcTemplate.queryForObject(
                    "SELECT author_id FROM authors_books WHERE book_id=?", Integer.class, book.getId());

            Author authorFromDB = jdbcTemplate.queryForObject("SELECT * from authors where id=?",
                    (ResultSet rs1, int rowNum1) -> {
                        Author author = new Author();
                        author.setId(book.getId());
                        author.setFirstname(rs1.getString("firstName"));
                        author.setLastname(rs1.getString("lastName"));
                        return author;
                    }, authorId);
            book.setAuthor(authorFromDB);

            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getString("priceOld"));
            book.setPrice(rs.getString("price"));
            return book;

        });
        return new ArrayList<>(books);
    }
}
