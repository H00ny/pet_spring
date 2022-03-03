package com.example.bookshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="book")
@Getter @Setter @NoArgsConstructor
public class Book {
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
        name = "",
        sequenceName = "",
        allocationSize = 1)
    @Column(name="", updatable = false, nullable = false)
    private Long id;

    @Column(name="", nullable = false)
    private String name;

    @Column(name="", nullable = false)
    private String author;

    @Column(name="", nullable = false)
    private Integer count;
}
