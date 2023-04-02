package com.boston.OutdoorsApi.service;

import com.boston.OutdoorsApi.Models.Quotes;
import com.boston.OutdoorsApi.dto.QuotesDTO;

public interface QuotesService extends GenericService<Quotes, Long>{
    QuotesDTO findRandom();
}
