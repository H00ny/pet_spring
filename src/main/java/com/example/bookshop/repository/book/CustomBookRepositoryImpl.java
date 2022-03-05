package com.example.bookshop.repository.book;

import java.util.ArrayList;
import java.util.List;

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

        List<Book> result = new ArrayList<>();

        if(filter.getCount() == null && filter.getAuthor() == null && filter.getName() == null) {
            cq.select(root);
            result.addAll(em.createQuery(cq).getResultList());
            return result;
        }

        if(filter.getCount() != null) {
            cq.select(root).where(cb.equal(root.get("count"), filter.getCount()));
            result.addAll(em.createQuery(cq).getResultList());
        }
        if(filter.getAuthor() != null) {
            cq.select(root).where(cb.equal(root.get("author"), filter.getAuthor()));
            result.addAll(em.createQuery(cq).getResultList());
        }
        if(filter.getName() != null) {
            cq.select(root).where(cb.equal(root.get("name"), filter.getName()));
            result.addAll(em.createQuery(cq).getResultList());
        }

        //Optional.ofNullable(filter.getCount()).ifPresent(cq.where(cb.equal(root.get("count"), filter.getCount())));

        return result;
    }
    
}
