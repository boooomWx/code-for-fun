package com.redo.codeforfun.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.redo.codeforfun.service.dubbo.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public Object readBook(String uid) {
        return "ok, let's begin read";
    }
}
