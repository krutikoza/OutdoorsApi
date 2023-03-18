package com.boston.OutdoorsApi.service.impl;

import com.boston.OutdoorsApi.Models.Chapters;
import com.boston.OutdoorsApi.dao.ChaptersRepository;
import com.boston.OutdoorsApi.dto.ChaptersDTO;
import com.boston.OutdoorsApi.mapper.ChaptersMapper;
import com.boston.OutdoorsApi.service.ChaptersService;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChaptersServiceImpl implements ChaptersService {
    private final ChaptersRepository repository;

    public ChaptersServiceImpl(ChaptersRepository repository) {
        this.repository = repository;
    }

    @Override
    public Chapters save(Chapters entity) {
        return repository.save(entity);
    }

//    @Override
//    public List<Chapters> save(List<Chapters> entities) {
//        return (List<Chapters>) repository.saveAll(entities);
//    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Chapters> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Chapters> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Chapters> findAll(Pageable pageable) {
        Page<Chapters> entityPage = repository.findAll(pageable);
        List<Chapters> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Chapters update(Chapters entity, Long id) {
        Optional<Chapters> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}