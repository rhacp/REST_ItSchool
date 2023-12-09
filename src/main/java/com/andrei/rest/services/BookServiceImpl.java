package com.andrei.rest.services;

import com.andrei.rest.models.entities.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    List<Book> bookList = new ArrayList<>();

    @Override
    public Book createBook(Book book) {
        if (!isValid(book)) {
            throw new RuntimeException("Invalid input!");
        }
        long bookId = bookList.size() + 1L; //1L este 1 long ca sa nu mai facem cast
        book.setId(bookId);

        //save the book
        bookList.add(book);
        log.info("Book with id {} has been created.", book.getId());

        return bookList.get((int) bookId - 1);
    }

    private boolean isValid(Book book) {
        return !book.getTitle().isEmpty() && !book.getAuthor().isEmpty() && book.getPrice() != null;
    }

    @Override
    public List<Book> getAllBooks() {
        log.info("Retrieved book list.");
        return bookList;
    }
}
