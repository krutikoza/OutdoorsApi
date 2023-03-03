//package com.boston.OutdoorsApi.controller.impl;
//
//import com.boston.OutdoorsApi.Models.PointOfInterests;
//import com.boston.OutdoorsApi.controller.impl.CustomUtils;
//import com.boston.OutdoorsApi.controller.impl.PointOfInterestsControllerImpl;
//import com.boston.OutdoorsApi.dto.PointOfInterestsDTO;
//import com.boston.OutdoorsApi.mapper.PointOfInterestsMapper;
//import com.boston.OutdoorsApi.mapper.ReferenceMapper;
//import com.boston.OutdoorsApi.service.PointOfInterestsService;
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
//public class PointOfInterestsControllerImplTest {
//    //TODO: create the data Test generator class PointOfInterestsBuilder
//    private static final String ENDPOINT_URL = "/point-of-interestss";
//    @MockBean
//    private ReferenceMapper referenceMapper;
//    @InjectMocks
//    private PointOfInterestsControllerImpl pointofinterestsController;
//    @MockBean
//    private PointOfInterestsService pointofinterestsService;
//    @MockBean
//    private PointOfInterestsMapper pointofinterestsMapper;
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(this.pointofinterestsController).build();
//    }
//
//    @Test
//    public void getAll() throws Exception {
//        Mockito.when(pointofinterestsMapper.asDTOList(ArgumentMatchers.any())).thenReturn(PointOfInterestsBuilder.getListDTO());
//
//        Mockito.when(pointofinterestsService.findAll()).thenReturn(PointOfInterestsBuilder.getListEntities());
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
//        Mockito.when(pointofinterestsMapper.asDTO(ArgumentMatchers.any())).thenReturn(PointOfInterestsBuilder.getDTO());
//
//        Mockito.when(pointofinterestsService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(PointOfInterestsBuilder.getEntity()));
//
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
//        Mockito.verify(pointofinterestsService, Mockito.times(1)).findById(1L);
//        Mockito.verifyNoMoreInteractions(pointofinterestsService);
//    }
//
//    @Test
//    public void save() throws Exception {
//        Mockito.when(pointofinterestsMapper.asEntity(ArgumentMatchers.any())).thenReturn(PointOfInterestsBuilder.getEntity());
//        Mockito.when(pointofinterestsService.save(ArgumentMatchers.any(PointOfInterests.class))).thenReturn(PointOfInterestsBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.post(ENDPOINT_URL)
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(PointOfInterestsBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//        Mockito.verify(pointofinterestsService, Mockito.times(1)).save(ArgumentMatchers.any(PointOfInterests.class));
//        Mockito.verifyNoMoreInteractions(pointofinterestsService);
//    }
//
//    @Test
//    public void update() throws Exception {
//        Mockito.when(pointofinterestsMapper.asEntity(ArgumentMatchers.any())).thenReturn(PointOfInterestsBuilder.getEntity());
//        Mockito.when(pointofinterestsService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(PointOfInterestsBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(PointOfInterestsBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(pointofinterestsService, Mockito.times(1)).update(ArgumentMatchers.any(PointOfInterests.class), ArgumentMatchers.anyLong());
//        Mockito.verifyNoMoreInteractions(pointofinterestsService);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        Mockito.doNothing().when(pointofinterestsService).deleteById(ArgumentMatchers.anyLong());
//        mockMvc.perform(
//                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(pointofinterestsService, Mockito.times(1)).deleteById(Mockito.anyLong());
//        Mockito.verifyNoMoreInteractions(pointofinterestsService);
//    }