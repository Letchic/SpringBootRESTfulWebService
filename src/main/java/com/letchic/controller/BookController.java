package com.letchic.controller;

import com.letchic.model.Book;
import com.letchic.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest/book")
public class BookController extends CommonController<Book, BookService> {

    @Autowired
    BookService bookService;

    @GetMapping("/getBooksWithPrice")
    public Map<String, Double> getBooksWithPrice() {
        return bookService.getBooksWithPrice();
    }

    @GetMapping("/getBookByNamePartAndPrice")
    public ResponseEntity<Map<String, Double>> getBookByNameAndPriceLevel(@RequestParam String namePart, double priceLevel) {
        Map<String, Double> result = bookService.getBookByNameAndPrice(namePart, priceLevel);
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public Class<Book> getEType() {
        return Book.class;
    }
}