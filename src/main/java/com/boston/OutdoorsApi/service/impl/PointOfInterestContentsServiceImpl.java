package com.boston.OutdoorsApi.service.impl;

import com.boston.OutdoorsApi.Models.PointOfInterestContents;
import com.boston.OutdoorsApi.dao.PointOfInterestContentsRepository;
import com.boston.OutdoorsApi.dto.PointOfInterestContentsDTO;
import com.boston.OutdoorsApi.mapper.PointOfInterestContentsMapper;
import com.boston.OutdoorsApi.service.PointOfInterestContentsService;
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
public class PointOfInterestContentsServiceImpl implements PointOfInterestContentsService {
    private final PointOfInterestContentsRepository repository;

    public PointOfInterestContentsServiceImpl(PointOfInterestContentsRepository repository) {
        this.repository = repository;
    }

    @Override
    public PointOfInterestContents save(PointOfInterestContents entity) {
        return repository.save(entity);
    }

//    @Override
//    public List<PointOfInterestContents> save(List<PointOfInterestContents> entities) {
//        return (List<PointOfInterestContents>) repository.saveAll(entities);
//    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<PointOfInterestContents> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<PointOfInterestContents> findAll() {
        return (List<PointOfInterestContents>) repository.findAll();
    }

    @Override
    public Page<PointOfInterestContents> findAll(Pageable pageable) {
        Page<PointOfInterestContents> entityPage = repository.findAll(pageable);
        List<PointOfInterestContents> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public PointOfInterestContents update(PointOfInterestContents entity, Long id) {
        Optional<PointOfInterestContents> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}