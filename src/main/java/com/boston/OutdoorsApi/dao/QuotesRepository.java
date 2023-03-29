package com.boston.OutdoorsApi.dao;

import com.boston.OutdoorsApi.Models.Quotes;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface QuotesRepository extends PagingAndSortingRepository<Quotes, Long> {
}
