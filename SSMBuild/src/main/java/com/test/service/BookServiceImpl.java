package com.test.service;

import com.test.dao.BookMapper;
import com.test.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{

    //service 调 dao层 ：组合Dao（把数据填进去）
    private BookMapper bookMapper;

    //使用Spring
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }
}
