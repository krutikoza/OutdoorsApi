package com.boston.OutdoorsApi.mapper.impl;

import com.boston.OutdoorsApi.Models.Chapters;
import com.boston.OutdoorsApi.Models.PointOfInterests;
import com.boston.OutdoorsApi.dao.ChaptersRepository;
import com.boston.OutdoorsApi.dao.PointOfInterestsRepository;
import com.boston.OutdoorsApi.dto.PointOfInterestsDTO;
import com.boston.OutdoorsApi.mapper.PointOfInterestsMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class PointOfInterestsMapperImpl implements PointOfInterestsMapper{
    private final ChaptersRepository chaptersRepository;

    public PointOfInterestsMapperImpl(ChaptersRepository chaptersRepository) {
        this.chaptersRepository = chaptersRepository;
    }

    public PointOfInterests asEntity(PointOfInterestsDTO dto) {
        if (dto == null) {
            return null;
        } else {
            PointOfInterests pointOfInterests = new PointOfInterests();
            pointOfInterests.setId(dto.getId());
            pointOfInterests.setLongitude(dto.getLongitude());
            pointOfInterests.setLatitude(dto.getLatitude());
            pointOfInterests.setThumbnailDefaultontentURL(dto.getThumbnailDefaultontentURL());
            pointOfInterests.setDefaultContentURL(dto.getDefaultContentURL());
            pointOfInterests.setDescription(dto.getDescription());
            pointOfInterests.setTitle(dto.getTitle());
            pointOfInterests.setDateModified(dto.getDateModified());
            pointOfInterests.setDateCreated(dto.getDateCreated());
            pointOfInterests.setChapters(chaptersRepository.findById(dto.getChaptersId()).orElse(null) );
            return pointOfInterests;
        }
    }

    public PointOfInterestsDTO asDTO(PointOfInterests entity) {
        if (entity == null) {
            return null;
        } else {
            PointOfInterestsDTO pointOfInterestsDTO = new PointOfInterestsDTO();
            pointOfInterestsDTO.setId(entity.getId());
            pointOfInterestsDTO.setLongitude(entity.getLongitude());
            pointOfInterestsDTO.setLatitude(entity.getLatitude());
            pointOfInterestsDTO.setThumbnailDefaultontentURL(entity.getThumbnailDefaultontentURL());
            pointOfInterestsDTO.setDefaultContentURL(entity.getDefaultContentURL());
            pointOfInterestsDTO.setDescription(entity.getDescription());
            pointOfInterestsDTO.setTitle(entity.getTitle());
            pointOfInterestsDTO.setDateModified(entity.getDateModified());
            pointOfInterestsDTO.setDateCreated(entity.getDateCreated());
            pointOfInterestsDTO.setChaptersId(entity.getChapters().getId());
            return pointOfInterestsDTO;
        }
    }

    public List<PointOfInterests> asEntityList(List<PointOfInterestsDTO> dtoList) {
        if (dtoList == null) {
            return null;
        } else {
            List<PointOfInterests> list = new ArrayList(dtoList.size());
            Iterator var3 = dtoList.iterator();

            while(var3.hasNext()) {
                PointOfInterestsDTO pointOfInterestsDTO = (PointOfInterestsDTO)var3.next();
                list.add(this.asEntity(pointOfInterestsDTO));
            }

            return list;
        }
    }

    public List<PointOfInterestsDTO> asDTOList(List<PointOfInterests> entityList) {
        if (entityList == null) {
            return null;
        } else {
            List<PointOfInterestsDTO> list = new ArrayList(entityList.size());
            Iterator var3 = entityList.iterator();

            while(var3.hasNext()) {
                PointOfInterests pointOfInterests = (PointOfInterests)var3.next();
                list.add(this.asDTO(pointOfInterests));
            }

            return list;
        }
    }
}
