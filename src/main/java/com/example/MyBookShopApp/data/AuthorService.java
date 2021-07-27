package com.example.MyBookShopApp.data;

import com.example.MyBookShopApp.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Author> getAuthorsData() {
        List<Author> authors = jdbcTemplate.query("SELECT * from authors", (ResultSet resultSet, int row) -> {
            Author author = new Author();
            author.setFirstname(resultSet.getString("firstName"));
            author.setLastname(resultSet.getString("lastName"));
            return author;
        });
        return new ArrayList<>(authors);
    }

    public List<Author> getAuthorsDataSorted() {
        List<Author> authors = jdbcTemplate.query("SELECT * from authors", (ResultSet resultSet, int row) -> {
            Author author = new Author();
            author.setFirstname(resultSet.getString("firstName"));
            author.setLastname(resultSet.getString("lastName"));
            return author;
        });
        return new ArrayList<>(authors).stream().sorted((o1, o2) -> o1.getLastname().compareTo(o2.getLastname())).collect(Collectors.toList());
    }
}
