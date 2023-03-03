package com.boston.OutdoorsApi.controller;

import com.boston.OutdoorsApi.dto.PointOfInterestContentsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "PointOfInterestContents API")
public interface PointOfInterestContentsController {
    @ApiOperation("Add new data")
    public PointOfInterestContentsDTO save(@RequestBody PointOfInterestContentsDTO pointOfInterestContents);

    @ApiOperation("Find by Id")
    public PointOfInterestContentsDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<PointOfInterestContentsDTO> list();

    @ApiOperation("Pagination request")
    public Page<PointOfInterestContentsDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public PointOfInterestContentsDTO update(@RequestBody PointOfInterestContentsDTO dto, @PathVariable("id") Long id);
}