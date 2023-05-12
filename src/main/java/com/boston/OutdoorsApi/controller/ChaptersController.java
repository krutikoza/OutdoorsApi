package com.boston.OutdoorsApi.controller;



import com.boston.OutdoorsApi.dto.ChaptersDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Chapters API")
public interface ChaptersController{
    @ApiOperation("Add new data")
    public ChaptersDTO save(@RequestBody ChaptersDTO chapters) throws Exception;

    @ApiOperation("Find by Id")
    public ChaptersDTO findById(@PathVariable("id") Long id) throws Exception;

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id) throws Exception;

    @ApiOperation("Find all data")
    public List<ChaptersDTO> list() throws Exception;

    @ApiOperation("Pagination request")
    public Page<ChaptersDTO> pageQuery(Pageable pageable) throws Exception;

    @ApiOperation("Update one data")
    public ChaptersDTO update(@RequestBody ChaptersDTO dto, @PathVariable("id") Long id) throws Exception;

//    public List<Chapters> search(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field) throws Exception;


    public List<ChaptersDTO> search(@PathVariable String field) throws Exception;
}