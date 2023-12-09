package com.andrei.rest.services;

import com.andrei.rest.models.entities.Book;

import java.util.List;

public interface BookService {

    Book createBook(Book book);

    List<Book> getAllBooks();
}
