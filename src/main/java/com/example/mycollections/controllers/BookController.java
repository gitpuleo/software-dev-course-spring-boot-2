package com.example.mycollections.controllers;

import com.example.mycollections.models.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final List<Book> books = new ArrayList<>() {{
        add(new Book("Game of Thrones", "George Rail Road Martin", 1996, 830));
        add(new Book("Between Two Fires", "Christopher Buehlman", 2012, 400));
        add(new Book("God of Small Things", "Arundhati Roy", 2000,300));
    }};

    @GetMapping("/json")
    public List<Book> getBooksJson() {
        return books;
    }

    @GetMapping("/html")
    public String getBooksHtml() {
        String bookList = "<ul>";
        for (Book book : books) {
            bookList += "<li>" + book + "</li>";
        }
        bookList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Books</h1>
                        <ul>
                """ +
                bookList + 
                """
                        </ul>
                    </body>
                """;
    }

}