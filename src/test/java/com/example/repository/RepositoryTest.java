package com.example.repository;



import com.example.entity.Book;
import com.example.entity.Magazine;
import com.example.entity.DVD;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RepositoryTest {

    @Autowired private BookRepository bookRepo;
    @Autowired private MagazineRepository magazineRepo;
    @Autowired private DVDRepository dvdRepo;

    @Test
    void testBookRepository() {
        Book book = new Book("Clean Code", "Robert Martin");
        Book saved = bookRepo.save(book);
        assertThat(saved.getId()).isNotNull();
        assertThat(bookRepo.findById(saved.getId())).isPresent();
    }

    @Test
    void testMagazineRepository() {
        Magazine mag = new Magazine("Tech Today", 101);
        Magazine saved = magazineRepo.save(mag);
        assertThat(saved.getId()).isNotNull();
        assertThat(magazineRepo.findById(saved.getId())).isPresent();
    }

    @Test
    void testDVDRepository() {
        DVD dvd = new DVD("Inception", "Sci-Fi");
        DVD saved = dvdRepo.save(dvd);
        assertThat(saved.getId()).isNotNull();
        assertThat(dvdRepo.findById(saved.getId())).isPresent();
    }
}
