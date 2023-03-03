package com.boston.OutdoorsApi.mapper;

import com.boston.OutdoorsApi.Models.PointOfInterests;
import com.boston.OutdoorsApi.dto.PointOfInterestsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface PointOfInterestsMapper extends GenericMapper<PointOfInterests, PointOfInterestsDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    PointOfInterests asEntity(PointOfInterestsDTO dto);
}