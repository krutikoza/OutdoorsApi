package com.boston.OutdoorsApi.mapper;

import com.boston.OutdoorsApi.Models.PointOfInterestContents;
import com.boston.OutdoorsApi.dto.PointOfInterestContentsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface PointOfInterestContentsMapper extends GenericMapper<PointOfInterestContents, PointOfInterestContentsDTO> {
//    @Override
//    @Mapping(target = "id", ignore = false)
//    PointOfInterestContents asEntity(PointOfInterestContentsDTO dto);
}