package com.letchic.service;


import com.letchic.model.Book;
import com.letchic.repository.BookRepository;
import com.letchic.views.TitleAndPriceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BookService extends AbstractService<Book, BookRepository> {

    @Autowired
    BookRepository bookRepository;

public List<TitleAndPriceView> getBooksWithPrice() {
    return bookRepository.findBy();
}

public List<TitleAndPriceView> getBookByNameAndPriceLevel(String namePart, double priceLevel) {
    return bookRepository.getBookByNameAndPriceLevel(namePart, priceLevel);
}
}