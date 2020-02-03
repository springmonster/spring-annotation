package com.kuang.service;

import com.kuang.dao.BookDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookService {

    //    @Qualifier("bookDao")
//    @Autowired(required = false)
    @Resource
    private BookDao bookDao;

    public void print() {
        System.out.println(bookDao);
    }
}
