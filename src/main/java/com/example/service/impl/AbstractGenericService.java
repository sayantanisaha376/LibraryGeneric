package com.example.service.impl;


import com.example.exception.ResourceNotFoundException;
import com.example.service.GenericCRUDService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Array;
import java.util.List;

public abstract class AbstractGenericService<T> implements GenericCRUDService<T> {

    private final JpaRepository<T, Long> repo;
    private final Class<T> clazz;

    protected AbstractGenericService(JpaRepository<T, Long> repo, Class<T> clazz) {
        this.repo = repo;
        this.clazz = clazz;
    }

    @Override
    public T save(T entity) {
        return repo.save(entity);
    }

    @Override
    public T findById(Long id) {
        return repo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(clazz.getSimpleName() + " not found with id " + id));
    }

    @Override
    public T[] findAll() {
        List<T> list = repo.findAll(); // JPA returns List internally
        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(clazz, list.size());
        return list.toArray(array);    // convert to array for public API
    }

    @Override
    public T update(Long id, T entity) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException(clazz.getSimpleName() + " not found with id " + id);
        }
        // saving the entity (caller should ensure id is set if required)
        return repo.save(entity);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException(clazz.getSimpleName() + " not found with id " + id);
        }
        repo.deleteById(id);
    }
}
