package com.letchic.controller;

import com.letchic.model.Book;
import com.letchic.service.BookService;
import com.letchic.views.TitleAndPriceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rest/book")
public class BookController extends CommonController<Book, BookService> {

    @Autowired
    BookService bookService;

    @GetMapping("/getBookByNamePrice")
    public ResponseEntity<List<TitleAndPriceView>> getBookByNameAndPrice(@RequestParam String namePart, double priceLevel) {
        List<TitleAndPriceView> result = bookService.getBookByNameAndPriceLevel(namePart, priceLevel);
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/getBooksWithPrice")
    public List<TitleAndPriceView> getBooksWithPrice() {
        return bookService.getBooksWithPrice();
    }



}