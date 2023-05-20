package com.boston.OutdoorsApi.mapper;


import com.boston.OutdoorsApi.Models.PointOfInterestContents;
import com.boston.OutdoorsApi.dto.POIContentListDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface POIContentListMapper {

    public Map<Long, List<String>> asDTOList(List<PointOfInterestContents> entityList);
}
