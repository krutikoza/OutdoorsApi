package com.boston.OutdoorsApi.service.impl;

import com.boston.OutdoorsApi.Models.Quotes;
import com.boston.OutdoorsApi.dao.QuotesRepository;
import com.boston.OutdoorsApi.dto.QuotesDTO;
import com.boston.OutdoorsApi.service.QuotesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuotesServiceImpl implements QuotesService {


    private final QuotesRepository quotesRepository;

    public QuotesServiceImpl(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @Override
    public Quotes save(Quotes entity) {
        return quotesRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        quotesRepository.deleteById(id);
    }

    @Override
    public Optional<Quotes> findById(Long id) {
        return quotesRepository.findById(id);
    }

    @Override
    public List<Quotes> findAll() {
        return (List<Quotes>) quotesRepository.findAll();
    }

    @Override
    public Page<Quotes> findAll(Pageable pageable) {
        return quotesRepository.findAll(pageable);
    }

    @Override
    public Quotes update(Quotes entity, Long id) {

        Optional<Quotes> optional = findById(id);
        if(optional.isPresent()){
            return save(entity);
        }
        return null;

    }


    public QuotesDTO findRandom() {

        QuotesDTO quotes = new QuotesDTO();

        Long qty = quotesRepository.count();
        int idx = (int)(Math.random() * qty);
        Page<Quotes> quotesPage = quotesRepository.findAll(PageRequest.of(idx, 1));

        Quotes q = null;
        if (quotesPage.hasContent()) {
            q = quotesPage.getContent().get(0);
            quotes.setQuote(q.getQuote());
            quotes.setAuthor(q.getAuthor());

            return quotes;
        }
        return new QuotesDTO();
    }

}
