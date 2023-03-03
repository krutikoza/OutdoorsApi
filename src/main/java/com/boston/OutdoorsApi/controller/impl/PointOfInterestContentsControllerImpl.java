package com.boston.OutdoorsApi.controller.impl;

import com.boston.OutdoorsApi.Models.PointOfInterestContents;
import com.boston.OutdoorsApi.controller.PointOfInterestContentsController;
import com.boston.OutdoorsApi.dto.PointOfInterestContentsDTO;
import com.boston.OutdoorsApi.mapper.PointOfInterestContentsMapper;
import com.boston.OutdoorsApi.service.PointOfInterestContentsService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/point-of-interest-contents")
@RestController
public class PointOfInterestContentsControllerImpl implements PointOfInterestContentsController {
    private final PointOfInterestContentsService pointOfInterestContentsService;
    private final PointOfInterestContentsMapper pointOfInterestContentsMapper;

    public PointOfInterestContentsControllerImpl(PointOfInterestContentsService pointOfInterestContentsService, PointOfInterestContentsMapper pointOfInterestContentsMapper) {
        this.pointOfInterestContentsService = pointOfInterestContentsService;
        this.pointOfInterestContentsMapper = pointOfInterestContentsMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PointOfInterestContentsDTO save(@RequestBody PointOfInterestContentsDTO pointOfInterestContentsDTO) {
        PointOfInterestContents pointOfInterestContents = pointOfInterestContentsMapper.asEntity(pointOfInterestContentsDTO);
        return pointOfInterestContentsMapper.asDTO(pointOfInterestContentsService.save(pointOfInterestContents));
    }

    @Override
    @GetMapping("/{id}")
    public PointOfInterestContentsDTO findById(@PathVariable("id") Long id) {
        PointOfInterestContents pointOfInterestContents = pointOfInterestContentsService.findById(id).orElse(null);
        return pointOfInterestContentsMapper.asDTO(pointOfInterestContents);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        pointOfInterestContentsService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<PointOfInterestContentsDTO> list() {
        return pointOfInterestContentsMapper.asDTOList(pointOfInterestContentsService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<PointOfInterestContentsDTO> pageQuery(Pageable pageable) {
        Page<PointOfInterestContents> pointOfInterestContentsPage = pointOfInterestContentsService.findAll(pageable);
        List<PointOfInterestContentsDTO> dtoList = pointOfInterestContentsPage
                .stream()
                .map(pointOfInterestContentsMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, pointOfInterestContentsPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public PointOfInterestContentsDTO update(@RequestBody PointOfInterestContentsDTO pointOfInterestContentsDTO, @PathVariable("id") Long id) {
        PointOfInterestContents pointOfInterestContents = pointOfInterestContentsMapper.asEntity(pointOfInterestContentsDTO);
        return pointOfInterestContentsMapper.asDTO(pointOfInterestContentsService.update(pointOfInterestContents, id));
    }
}