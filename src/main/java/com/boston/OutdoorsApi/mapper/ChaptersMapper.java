package com.boston.OutdoorsApi.mapper;

import com.boston.OutdoorsApi.Models.Chapters;
import com.boston.OutdoorsApi.dto.ChaptersDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface ChaptersMapper extends GenericMapper<Chapters, ChaptersDTO> {
//    @Override
//    @Mapping(target = "id", ignore = false)
//    Chapters asEntity(ChaptersDTO dto);

}