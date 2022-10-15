package com.example.pract5.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String phone;
    private String name;
}
