package com.test.service;

import com.test.dao.BookMapper;
import com.test.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{

    //service层 调 dao层: 组合dao
    private BookMapper bookMapper;

    //添加setter, Spring可以直接注入到mapper
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
        System.out.println("BookServiceImpl:updateBook=>"+books);
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

    @Override
    public Books queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }


}
