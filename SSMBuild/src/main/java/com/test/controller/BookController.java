package com.test.controller;

import com.test.pojo.Books;
import com.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    //controller层 调 service 层
    //这里使用Qualified, 指定了注入BookServiceImpl, 避免了自动装配注入对象模糊的问题
    private final BookService bookService;

    public BookController(@Qualifier("BookServiceImpl") BookService bookService) {
        this.bookService = bookService;
    }

    //查询全部的书籍, 并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();

        model.addAttribute("list", list);
        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddPage(){
        return "addBook";
    }

    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>" + books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    //添加书籍的请求
    @RequestMapping("/toUpdateBook")
    public String toUpdatePage(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("queryResult",books);
        return "updateBook";
    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updatePage(Books books){
        System.out.println("updateBook=>"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    //删除书籍
    @RequestMapping("/deleteBook/{bookId}")
    //restful风格
    public String deleteBook(@PathVariable("bookId") int id){
        System.out.println("deleteBook=>"+id);
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        Books books = bookService.queryBookByName(queryBookName);
        List<Books> list = new ArrayList<>();
        list.add(books);

        //如果查询不存在, 返回全部书籍
        if(books == null) {
            list = bookService.queryAllBook();
            model.addAttribute("error", "未查到该书籍");
        }
        model.addAttribute("list", list);
        return "/allBook";
    }
}
