package com.boston.OutdoorsApi.controller;



import com.boston.OutdoorsApi.dto.QuotesDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Quotes API")
public interface QuotesController {



    @ApiOperation("Add new data")
    public QuotesDTO save(@RequestBody QuotesDTO quote);

    @ApiOperation("Find by Id")
    public QuotesDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<QuotesDTO> list();

    @ApiOperation("Pagination request")
    public Page<QuotesDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public QuotesDTO update(@RequestBody QuotesDTO dto, @PathVariable("id") Long id);


    @ApiOperation("Get random entity")
    public QuotesDTO getRandom();


}
