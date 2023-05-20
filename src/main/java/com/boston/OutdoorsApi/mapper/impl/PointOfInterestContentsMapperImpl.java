package com.boston.OutdoorsApi.mapper.impl;

import com.boston.OutdoorsApi.Models.PointOfInterestContents;
import com.boston.OutdoorsApi.Models.PointOfInterests;
import com.boston.OutdoorsApi.dao.PointOfInterestContentsRepository;
import com.boston.OutdoorsApi.dao.PointOfInterestsRepository;
import com.boston.OutdoorsApi.dto.PointOfInterestContentsDTO;
import com.boston.OutdoorsApi.dto.PointOfInterestsDTO;
import com.boston.OutdoorsApi.mapper.PointOfInterestContentsMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class PointOfInterestContentsMapperImpl implements PointOfInterestContentsMapper{
    private final PointOfInterestsRepository pointOfInterestsRepository;

    public PointOfInterestContentsMapperImpl(PointOfInterestsRepository pointOfInterestsRepository) {
        this.pointOfInterestsRepository = pointOfInterestsRepository;
    }

    public PointOfInterestContents asEntity(PointOfInterestContentsDTO dto) {
        if (dto == null) {
            return null;
        } else {
            PointOfInterestContents pointOfInterestContents = new PointOfInterestContents();
            pointOfInterestContents.setId(dto.getId());
            pointOfInterestContents.setSequence(dto.getSequence());
            pointOfInterestContents.setContentType(dto.getContentType());
            pointOfInterestContents.setThumbnailContentURL(dto.getThumbnailContentURL());
            pointOfInterestContents.setContentURL(dto.getContentURL());
            pointOfInterestContents.setDataModified(dto.getDataModified());
            pointOfInterestContents.setDataCreated(dto.getDataCreated());
            pointOfInterestContents.setPointOfInterests(pointOfInterestsRepository.findById(dto.getPointOfInterestsId()).orElse(null));
            return pointOfInterestContents;
        }
    }

    public PointOfInterestContentsDTO asDTO(PointOfInterestContents entity) {

        if (entity == null) {
            return null;
        } else {
            PointOfInterestContentsDTO pointOfInterestContentsDTO = new PointOfInterestContentsDTO();
            pointOfInterestContentsDTO.setId(entity.getId());
            pointOfInterestContentsDTO.setSequence(entity.getSequence());
            pointOfInterestContentsDTO.setContentType(entity.getContentType());
            pointOfInterestContentsDTO.setThumbnailContentURL(entity.getThumbnailContentURL());
            pointOfInterestContentsDTO.setContentURL(entity.getContentURL());
            pointOfInterestContentsDTO.setDataModified(entity.getDataModified());
            pointOfInterestContentsDTO.setDataCreated(entity.getDataCreated());
            pointOfInterestContentsDTO.setPointOfInterestsId(entity.getPointOfInterests().getId());
            return pointOfInterestContentsDTO;
        }
    }

    public List<PointOfInterestContents> asEntityList(List<PointOfInterestContentsDTO> dtoList) {
        if (dtoList == null) {
            return null;
        } else {
            List<PointOfInterestContents> list = new ArrayList(dtoList.size());
            Iterator var3 = dtoList.iterator();

            while(var3.hasNext()) {
                PointOfInterestContentsDTO pointOfInterestContentsDTO = (PointOfInterestContentsDTO)var3.next();
                list.add(this.asEntity(pointOfInterestContentsDTO));
            }

            return list;
        }
    }

    public List<PointOfInterestContentsDTO> asDTOList(List<PointOfInterestContents> entityList) {
        if (entityList == null) {
            return null;
        } else {
            List<PointOfInterestContentsDTO> list = new ArrayList(entityList.size());
            Iterator var3 = entityList.iterator();

            while(var3.hasNext()) {
                PointOfInterestContents pointOfInterestContents = (PointOfInterestContents)var3.next();
                list.add(this.asDTO(pointOfInterestContents));
            }

            return list;
        }
    }
}
