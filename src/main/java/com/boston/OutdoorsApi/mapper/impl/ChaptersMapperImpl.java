package com.boston.OutdoorsApi.mapper.impl;

import com.boston.OutdoorsApi.Models.Chapters;
import com.boston.OutdoorsApi.dto.ChaptersDTO;
import com.boston.OutdoorsApi.mapper.ChaptersMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ChaptersMapperImpl implements ChaptersMapper{

    public ChaptersMapperImpl() {
    }

    @Override
    public Chapters asEntity(ChaptersDTO dto) {
        if (dto == null) {
            return null;
        } else {
            Chapters chapters = new Chapters();
            chapters.setId(dto.getId());
            chapters.setThumbnailImageURL(dto.getThumbnailImageURL());
            chapters.setImageURL(dto.getImageURL());
            chapters.setDescription(dto.getDescription());
            chapters.setTitle(dto.getTitle());
            chapters.setDateModified(dto.getDateModified());
            chapters.setDateCreated(dto.getDateCreated());
            return chapters;
        }
    }

    @Override
    public ChaptersDTO asDTO(Chapters entity) {
        if (entity == null) {
            return null;
        } else {
            ChaptersDTO chaptersDTO = new ChaptersDTO();
            chaptersDTO.setId(entity.getId());
            chaptersDTO.setThumbnailImageURL(entity.getThumbnailImageURL());
            chaptersDTO.setImageURL(entity.getImageURL());
            chaptersDTO.setDescription(entity.getDescription());
            chaptersDTO.setTitle(entity.getTitle());
            chaptersDTO.setDateModified(entity.getDateModified());
            chaptersDTO.setDateCreated(entity.getDateCreated());
            return chaptersDTO;
        }
    }

    @Override
    public List<Chapters> asEntityList(List<ChaptersDTO> dtoList) {
        if (dtoList == null) {
            return null;
        } else {
            List<Chapters> list = new ArrayList(dtoList.size());
            Iterator var3 = dtoList.iterator();

            while(var3.hasNext()) {
                ChaptersDTO chaptersDTO = (ChaptersDTO)var3.next();
                list.add(this.asEntity(chaptersDTO));
            }

            return list;
        }
    }

    @Override
    public List<ChaptersDTO> asDTOList(List<Chapters> entityList) {
        if (entityList == null) {
            return null;
        } else {
            List<ChaptersDTO> list = new ArrayList(entityList.size());
            Iterator var3 = entityList.iterator();

            while(var3.hasNext()) {
                Chapters chapters = (Chapters)var3.next();
                list.add(this.asDTO(chapters));
            }

            return list;
        }
    }
}
