package com.example.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(max = 120)
    private String title;

    @NotBlank @Size(max = 80)
    private String author;

    public Book() {}
    public Book(String title, String author) {
        this.title = title; this.author = author; }

    @Override
    public String toString() {
        return "Book [Title=" + title + ", Author=" + author + "]"; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book b)) return false;
        return title.equals(b.title) && author.equals(b.author);
    }
}
