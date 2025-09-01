package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Entity
public class DVD {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank @Size(max = 120)
    private String title;

    @NotBlank @Size(max = 60)
    private String genre;

    public DVD() {}
    public DVD(String title, String genre) { this.title = title; this.genre = genre; }

    @Override
    public String toString() { return "DVD [Title=" + title + ", Genre=" + genre + "]"; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DVD d)) return false;
        return title.equals(d.title) && genre.equals(d.genre);
    }
}

