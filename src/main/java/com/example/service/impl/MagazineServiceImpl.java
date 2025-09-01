package com.example.service.impl;



import com.example.entity.Magazine;
import com.example.repository.MagazineRepository;
import org.springframework.stereotype.Service;

@Service
public class MagazineServiceImpl extends AbstractGenericService<Magazine> {
    private final MagazineRepository repo;

    public MagazineServiceImpl(MagazineRepository repo) {
        super(repo, Magazine.class);
        this.repo = repo;
    }

    @Override
    public Magazine update(Long id, Magazine incoming) {
        Magazine existing = findById(id);
        existing.setName(incoming.getName());
        existing.setIssueNo(incoming.getIssueNo());
        return repo.save(existing);
    }
}
