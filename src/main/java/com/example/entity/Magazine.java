package com.example.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
public class Magazine {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank @Size(max = 100)
    private String name;

    @Min(1)
    private int issueNo;

    public Magazine() {}
    public Magazine(String name, int issueNo) { this.name = name; this.issueNo = issueNo; }

    @Override
    public String toString() { return "Magazine [Name=" + name + ", Issue=" + issueNo + "]"; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Magazine m)) return false;
        return name.equals(m.name) && issueNo == m.issueNo;
    }
}
