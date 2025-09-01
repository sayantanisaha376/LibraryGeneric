package com.example.service.impl;



import com.example.entity.Book;
import com.example.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends AbstractGenericService<Book> {
    private final BookRepository repo;

    public BookServiceImpl(BookRepository repo) {
        super(repo, Book.class);
        this.repo = repo;
    }

    @Override
    public Book update(Long id, Book incoming) {
        Book existing = findById(id);
        existing.setTitle(incoming.getTitle());
        existing.setAuthor(incoming.getAuthor());
        return repo.save(existing);
    }
}
