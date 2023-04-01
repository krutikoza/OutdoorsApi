package com.boston.OutdoorsApi.service.impl;

import com.boston.OutdoorsApi.Models.PointOfInterests;
import com.boston.OutdoorsApi.dao.PointOfInterestsRepository;
import com.boston.OutdoorsApi.dto.PointOfInterestsDTO;
import com.boston.OutdoorsApi.mapper.PointOfInterestsMapper;
import com.boston.OutdoorsApi.service.PointOfInterestsService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PointOfInterestsServiceImpl implements PointOfInterestsService {
    private final PointOfInterestsRepository repository;


    public PointOfInterestsServiceImpl(PointOfInterestsRepository repository) {
        this.repository = repository;
    }

    @Override
    public PointOfInterests save(PointOfInterests entity) {
        return repository.save(entity);
    }

//    @Override
//    public List<PointOfInterests> save(List<PointOfInterests> entities) {
//        return (List<PointOfInterests>) repository.saveAll(entities);
//    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<PointOfInterests> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<PointOfInterests> findAll() {
        return (List<PointOfInterests>) repository.findAll();
    }

    @Override
    public Page<PointOfInterests> findAll(Pageable pageable) {
        Page<PointOfInterests> entityPage = repository.findAll(pageable);
        List<PointOfInterests> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public PointOfInterests update(PointOfInterests entity, Long id) {
        Optional<PointOfInterests> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}