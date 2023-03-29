package com.boston.OutdoorsApi.service;

import com.boston.OutdoorsApi.Models.Quotes;

public interface QuotesService extends GenericService<Quotes, Long>{
    String findRandom();
}
