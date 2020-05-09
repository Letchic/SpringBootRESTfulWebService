package com.letchic.service;


import com.letchic.model.Book;
import com.letchic.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookService extends AbstractService<Book, BookRepository> {

    @Autowired
    BookRepository bookRepository;


    public Map<String, Double> getBooksWithPrice() {
        return bookRepository.getBooksWithPrice()
                .stream()
                .collect(Collectors.toMap(
                        object -> ((String) object[0]),
                        object -> ((Number) object[1]).doubleValue()
                ));
    }

    public Map<String, Double> getBookByNameAndPrice(String namePart, double priceLevel) {
        return bookRepository.getBookByNameAndPriceLevel(namePart, priceLevel)
                .stream()
                .collect(Collectors.toMap(
                        object -> ((String) object[0]),
                        object -> ((Number) object[1]).doubleValue()
                ));
    }
}