package com.boston.OutdoorsApi.mapper.impl;

import com.boston.OutdoorsApi.Models.Quotes;
import com.boston.OutdoorsApi.dto.QuotesDTO;
import com.boston.OutdoorsApi.mapper.QuotesMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class QuotesMapperImpl implements QuotesMapper{
    public QuotesMapperImpl() {
    }

    public Quotes asEntity(QuotesDTO dto) {
        if (dto == null) {
            return null;
        } else {
            Quotes quotes = new Quotes();
            quotes.setQuote(dto.getQuote());
            quotes.setAuthor(dto.getAuthor());
            return quotes;
        }
    }

    public QuotesDTO asDTO(Quotes entity) {
        if (entity == null) {
            return null;
        } else {
            QuotesDTO quotesDTO = new QuotesDTO();
            quotesDTO.setQuote(entity.getQuote());
            quotesDTO.setAuthor(entity.getAuthor());
            return quotesDTO;
        }
    }

    public List<Quotes> asEntityList(List<QuotesDTO> dtoList) {
        if (dtoList == null) {
            return null;
        } else {
            List<Quotes> list = new ArrayList(dtoList.size());
            Iterator var3 = dtoList.iterator();

            while(var3.hasNext()) {
                QuotesDTO quotesDTO = (QuotesDTO)var3.next();
                list.add(this.asEntity(quotesDTO));
            }

            return list;
        }
    }

    public List<QuotesDTO> asDTOList(List<Quotes> entityList) {
        if (entityList == null) {
            return null;
        } else {
            List<QuotesDTO> list = new ArrayList(entityList.size());
            Iterator var3 = entityList.iterator();

            while(var3.hasNext()) {
                Quotes quotes = (Quotes)var3.next();
                list.add(this.asDTO(quotes));
            }

            return list;
        }
    }
}
