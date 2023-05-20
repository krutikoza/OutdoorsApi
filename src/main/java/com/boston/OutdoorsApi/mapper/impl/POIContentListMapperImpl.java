package com.boston.OutdoorsApi.mapper.impl;

import com.boston.OutdoorsApi.Models.PointOfInterestContents;
import com.boston.OutdoorsApi.dto.POIContentListDTO;
import com.boston.OutdoorsApi.mapper.POIContentListMapper;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class POIContentListMapperImpl implements POIContentListMapper {



    public List<PointOfInterestContents> asEntityList(List<List<POIContentListDTO>> dtoList) {
        List<PointOfInterestContents> poiContents = new ArrayList<PointOfInterestContents>();

        List<POIContentListDTO> flatPOIContentListDTO = dtoList
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        List<PointOfInterestContents> list = new ArrayList<PointOfInterestContents>();

        flatPOIContentListDTO
                .stream()
                .forEach(element -> {

                    PointOfInterestContents POIContent = new PointOfInterestContents();

                    POIContent.setContentType(element.getContentType());
                    POIContent.setContentURL(element.getContentURL());

                    list.add(POIContent);
                });

        return list;

    }


    public Map<Long, List<String>> asDTOList(List<PointOfInterestContents> entityList) {



//        List<String> list = new ArrayList<>();




        Map<Long, List<PointOfInterestContents>> c = entityList
                .stream()
                .collect(Collectors.groupingBy(e -> e.getContentType()));




        Map<Long, List<String>> newMap = new HashMap<>();

        c.forEach((k,v)->{
                newMap.put(k,v.stream()
                        .map(e -> e.getContentURL())
                        .collect(Collectors.toList()));
        });
        return newMap;

//        return entityList;

    }
}
