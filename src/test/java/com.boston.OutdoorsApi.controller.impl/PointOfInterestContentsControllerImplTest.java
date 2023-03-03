//package com.boston.OutdoorsApi.controller.impl;
//
//import com.boston.OutdoorsApi.Models.PointOfInterestContents;
//import com.boston.OutdoorsApi.controller.impl.CustomUtils;
//import com.boston.OutdoorsApi.controller.impl.PointOfInterestContentsControllerImpl;
//import com.boston.OutdoorsApi.dto.PointOfInterestContentsDTO;
//import com.boston.OutdoorsApi.mapper.PointOfInterestContentsMapper;
//import com.boston.OutdoorsApi.mapper.ReferenceMapper;
//import com.boston.OutdoorsApi.service.PointOfInterestContentsService;
//import org.hamcrest.Matchers;
//import org.hamcrest.core.Is;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Arrays;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@RunWith(SpringRunner.class)
//public class PointOfInterestContentsControllerImplTest {
//    //TODO: create the data Test generator class PointOfInterestContentsBuilder
//    private static final String ENDPOINT_URL = "/point-of-interest-contentss";
//    @MockBean
//    private ReferenceMapper referenceMapper;
//    @InjectMocks
//    private PointOfInterestContentsControllerImpl pointofinterestcontentsController;
//    @MockBean
//    private PointOfInterestContentsService pointofinterestcontentsService;
//    @MockBean
//    private PointOfInterestContentsMapper pointofinterestcontentsMapper;
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(this.pointofinterestcontentsController).build();
//    }
//
//    @Test
//    public void getAll() throws Exception {
//        Mockito.when(pointofinterestcontentsMapper.asDTOList(ArgumentMatchers.any())).thenReturn(PointOfInterestContentsBuilder.getListDTO());
//
//        Mockito.when(pointofinterestcontentsService.findAll()).thenReturn(PointOfInterestContentsBuilder.getListEntities());
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
//
//    }
//
//    @Test
//    public void getById() throws Exception {
//        Mockito.when(pointofinterestcontentsMapper.asDTO(ArgumentMatchers.any())).thenReturn(PointOfInterestContentsBuilder.getDTO());
//
//        Mockito.when(pointofinterestcontentsService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(PointOfInterestContentsBuilder.getEntity()));
//
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
//        Mockito.verify(pointofinterestcontentsService, Mockito.times(1)).findById(1L);
//        Mockito.verifyNoMoreInteractions(pointofinterestcontentsService);
//    }
//
//    @Test
//    public void save() throws Exception {
//        Mockito.when(pointofinterestcontentsMapper.asEntity(ArgumentMatchers.any())).thenReturn(PointOfInterestContentsBuilder.getEntity());
//        Mockito.when(pointofinterestcontentsService.save(ArgumentMatchers.any(PointOfInterestContents.class))).thenReturn(PointOfInterestContentsBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.post(ENDPOINT_URL)
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(PointOfInterestContentsBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//        Mockito.verify(pointofinterestcontentsService, Mockito.times(1)).save(ArgumentMatchers.any(PointOfInterestContents.class));
//        Mockito.verifyNoMoreInteractions(pointofinterestcontentsService);
//    }
//
//    @Test
//    public void update() throws Exception {
//        Mockito.when(pointofinterestcontentsMapper.asEntity(ArgumentMatchers.any())).thenReturn(PointOfInterestContentsBuilder.getEntity());
//        Mockito.when(pointofinterestcontentsService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(PointOfInterestContentsBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(PointOfInterestContentsBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(pointofinterestcontentsService, Mockito.times(1)).update(ArgumentMatchers.any(PointOfInterestContents.class), ArgumentMatchers.anyLong());
//        Mockito.verifyNoMoreInteractions(pointofinterestcontentsService);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        Mockito.doNothing().when(pointofinterestcontentsService).deleteById(ArgumentMatchers.anyLong());
//        mockMvc.perform(
//                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(pointofinterestcontentsService, Mockito.times(1)).deleteById(Mockito.anyLong());
//        Mockito.verifyNoMoreInteractions(pointofinterestcontentsService);
//    }