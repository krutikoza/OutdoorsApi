package com.boston.OutdoorsApi.mapper;


import com.boston.OutdoorsApi.Models.Quotes;
import com.boston.OutdoorsApi.dto.QuotesDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface QuotesMapper extends GenericMapper<Quotes, QuotesDTO>{

}
