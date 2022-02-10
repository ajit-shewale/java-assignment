package com.springWeb2.controller;

import java.util.List;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springWeb2.entity.BookDao;
import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.service.LibraryServiceImpl;

@Controller
public class HomeController {   //temporary comment

    @Autowired
    private LibraryServiceImpl libraryServiceImpl;

    @GetMapping(value = "/")
    public String viewHomePage(Model model) {
        model.addAttribute("booksList", libraryServiceImpl.findAllBooks());
        return "index";
    }

    @GetMapping(value = "/showNewBookForm")
    public String addBookForm(Model model) {
        BookDao book = new BookDao();
        model.addAttribute("book", book);
        return "new_book";
    }

    @GetMapping(value = "/showSearchBookForm")
    public String searchBookForm() {

        return "searchPage";
    }

    @GetMapping(value = "/searchBook")
    public String searchBook(Model model, String keyword) {
        if (keyword != null) {

            model.addAttribute("booksList", libraryServiceImpl.getByKeyword(keyword));
        } else {
            return "searchPage";
        }
        return "searchPage";
    }

    @PostMapping(value = "/saveBook")
    public String saveBook(@ModelAttribute("book") BookDao book) {
        libraryServiceImpl.saveBook(book);
        return "redirect:/";
    }
    
    @PostMapping(value = "/saveIssuedBook")
    public String saveIssuedBook(@ModelAttribute("book") IssuedBookDao book) {
        libraryServiceImpl.saveIssuedBook(book);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable int id, Model model) {
        BookDao book = libraryServiceImpl.getBookById(id);
        model.addAttribute("book", book);
        return "update_book";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id") int id) {
        this.libraryServiceImpl.deleteBook(id);
        return "redirect:/";
    }
    
    @GetMapping("/showIssuedBooks/{id}")
    public String showIssuedBooks(@PathVariable int id) {
         libraryServiceImpl.getIssuedBookById(id);
       return "issued_books";
    }
}
