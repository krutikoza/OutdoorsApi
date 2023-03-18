package com.boston.OutdoorsApi.controller;

import com.boston.OutdoorsApi.dto.PointOfInterestsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "PointOfInterests API")
public interface PointOfInterestsController {
    @ApiOperation("Add new data")
    public PointOfInterestsDTO save(@RequestBody PointOfInterestsDTO pointOfInterests);

    @ApiOperation("Find by Id")
    public PointOfInterestsDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<PointOfInterestsDTO> list();

    @ApiOperation("Pagination request")
    public Page<PointOfInterestsDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public PointOfInterestsDTO update(@RequestBody PointOfInterestsDTO dto, @PathVariable("id") Long id);

    @ApiOperation("Get data with specific chapters id")
    public List<PointOfInterestsDTO> pageQuery(@PathVariable("id") Long id);
}