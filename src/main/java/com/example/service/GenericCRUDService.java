package com.example.service;

public interface GenericCRUDService<T> {
    T save(T entity);
    T findById(Long id);
    T[] findAll();             // array-only API
    T update(Long id, T entity);
    void delete(Long id);
}