package com.boston.OutdoorsApi.controller.impl;

import com.boston.OutdoorsApi.Models.Chapters;
import com.boston.OutdoorsApi.controller.ChaptersController;
import com.boston.OutdoorsApi.dto.ChaptersDTO;
import com.boston.OutdoorsApi.mapper.ChaptersMapper;
import com.boston.OutdoorsApi.service.ChaptersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/chapters")
@RestController
public class ChaptersControllerImpl implements ChaptersController {
    private final ChaptersService chaptersService;
    private final ChaptersMapper chaptersMapper;

    public ChaptersControllerImpl(ChaptersService chaptersService, ChaptersMapper chaptersMapper) {
        this.chaptersService = chaptersService;
        this.chaptersMapper = chaptersMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ChaptersDTO save(@RequestBody ChaptersDTO chaptersDTO) {
        Chapters chapters = chaptersMapper.asEntity(chaptersDTO);
        return chaptersMapper.asDTO(chaptersService.save(chapters));
    }

    @Override
    @GetMapping("/{id}")
    public ChaptersDTO findById(@PathVariable("id") Long id) {
        Chapters chapters = chaptersService.findById(id).orElse(null);
        return chaptersMapper.asDTO(chapters);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        chaptersService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<ChaptersDTO> list() {
        return chaptersMapper.asDTOList(chaptersService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<ChaptersDTO> pageQuery(Pageable pageable) {
        Page<Chapters> chaptersPage = chaptersService.findAll(pageable);
        List<ChaptersDTO> dtoList = chaptersPage
                .stream()
                .map(chaptersMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, chaptersPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public ChaptersDTO update(@RequestBody ChaptersDTO chaptersDTO, @PathVariable("id") Long id) {
        Chapters chapters = chaptersMapper.asEntity(chaptersDTO);
        return chaptersMapper.asDTO(chaptersService.update(chapters, id));
    }
}