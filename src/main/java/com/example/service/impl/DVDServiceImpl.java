package com.example.service.impl;



import com.example.entity.DVD;
import com.example.repository.DVDRepository;
import org.springframework.stereotype.Service;

@Service
public class DVDServiceImpl extends AbstractGenericService<DVD> {
    private final DVDRepository repo;

    public DVDServiceImpl(DVDRepository repo) {
        super(repo, DVD.class);
        this.repo = repo;
    }

    @Override
    public DVD update(Long id, DVD incoming) {
        DVD existing = findById(id);
        existing.setTitle(incoming.getTitle());
        existing.setGenre(incoming.getGenre());
        return repo.save(existing);
    }
}
