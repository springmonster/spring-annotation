package com.kuang.controller;

import com.kuang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    public void printBookService() {
        System.out.println(bookService);
    }
}
