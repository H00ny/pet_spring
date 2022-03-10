package com.example.bookshop.repository.book;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.example.bookshop.entity.Book;
import com.example.bookshop.filter.BookFilter;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomBookRepositoryImpl implements CustomBookRepository {
    @Autowired
    private EntityManager em;

    @Override
    public List<Book> findByFilter(BookFilter filter) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        CriteriaQuery<Book> select = cq.select(root);

        Optional.ofNullable(filter.getCount())
                .ifPresent(count -> select.where(cb.equal(root.get("count"), filter.getCount())));
        Optional.ofNullable(filter.getAuthor())
                .ifPresent(author -> select.where(cb.equal(root.get("author"), filter.getAuthor())));
        Optional.ofNullable(filter.getName())
                .ifPresent(name -> select.where(cb.equal(root.get("name"), filter.getName())));

        return em.createQuery(select).getResultList();
    }
}
