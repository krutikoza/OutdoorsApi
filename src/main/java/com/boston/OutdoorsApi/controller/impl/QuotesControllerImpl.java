package com.boston.OutdoorsApi.controller.impl;

import com.boston.OutdoorsApi.Models.Quotes;
import com.boston.OutdoorsApi.controller.QuotesController;
import com.boston.OutdoorsApi.dto.QuotesDTO;
import com.boston.OutdoorsApi.mapper.QuotesMapper;
import com.boston.OutdoorsApi.service.QuotesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RequestMapping("/api/quotes")
@RestController
public class QuotesControllerImpl implements QuotesController {


    private final QuotesMapper quotesMapper;
    private final QuotesService quotesService;

    public QuotesControllerImpl(QuotesMapper quotesMapper, QuotesService quotesService) {
        this.quotesMapper = quotesMapper;
        this.quotesService = quotesService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuotesDTO save(@RequestBody QuotesDTO quotesDTO) {
        Quotes quotes = quotesMapper.asEntity(quotesDTO);
        return quotesMapper.asDTO(quotesService.save(quotes));
    }

    @Override
    @GetMapping("/{id}")
    public QuotesDTO findById(Long id) {
        Quotes quotes = quotesService.findById(id).orElse(null);
        return quotesMapper.asDTO(quotes);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(Long id) {
        quotesService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<QuotesDTO> list() {
        return quotesMapper.asDTOList(quotesService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<QuotesDTO> pageQuery(Pageable pageable) {
        Page<Quotes> quotesPage = quotesService.findAll(pageable);

        List<QuotesDTO> dtoList = quotesPage
                .stream()
                .map(quotesMapper::asDTO).collect(Collectors.toList());

        return new PageImpl<>(dtoList, pageable, quotesPage.getTotalElements());
    }

    @Override
    @GetMapping("/bypoiid/{id}")
    public QuotesDTO update(QuotesDTO quotesDTO, Long id) {
        Quotes quotes = quotesMapper.asEntity(quotesDTO);
        return quotesMapper.asDTO(quotesService.update(quotes, id));
    }

    @Override
    @GetMapping("/random")
    public QuotesDTO getRandom() {
        return quotesService.findRandom();
    }
}
