package com.example.service;

import com.example.entity.Book;
import com.example.entity.Magazine;
import com.example.entity.DVD;
import com.example.repository.BookRepository;
import com.example.repository.MagazineRepository;
import com.example.repository.DVDRepository;
import com.example.service.impl.BookServiceImpl;
import com.example.service.impl.MagazineServiceImpl;
import com.example.service.impl.DVDServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class LibraryServiceTest {

    private BookServiceImpl bookService;
    private MagazineServiceImpl magazineService;
    private DVDServiceImpl dvdService;

    @Autowired private BookRepository bookRepo;
    @Autowired private MagazineRepository magazineRepo;
    @Autowired private DVDRepository dvdRepo;

    @BeforeEach
    void setUp() {
        bookService = new BookServiceImpl(bookRepo);
        magazineService = new MagazineServiceImpl(magazineRepo);
        dvdService = new DVDServiceImpl(dvdRepo);
    }

    @Test
    void testBookService() {
        Book book = new Book("Effective Java", "Joshua Bloch");
        Book saved = bookService.save(book);
        assertThat(bookService.findById(saved.getId()).getTitle()).isEqualTo("Effective Java");
    }

    @Test
    void testMagazineService() {
        Magazine mag = new Magazine("National Geographic", 202);
        Magazine saved = magazineService.save(mag);
        assertThat(magazineService.findById(saved.getId()).getName()).isEqualTo("National Geographic");
    }

    @Test
    void testDVDService() {
        DVD dvd = new DVD("Matrix", "Action");
        DVD saved = dvdService.save(dvd);
        assertThat(dvdService.findById(saved.getId()).getTitle()).isEqualTo("Matrix");
    }
}
