package com.boston.OutdoorsApi.controller.impl;

import com.boston.OutdoorsApi.Models.Chapters;
import com.boston.OutdoorsApi.controller.impl.ChaptersControllerImpl;
import com.boston.OutdoorsApi.controller.impl.CustomUtils;
import com.boston.OutdoorsApi.dto.ChaptersDTO;
import com.boston.OutdoorsApi.mapper.ChaptersMapper;
import com.boston.OutdoorsApi.mapper.ReferenceMapper;
import com.boston.OutdoorsApi.service.ChaptersService;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ChaptersControllerImplTest {
    //TODO: create the data Test generator class ChaptersBuilder
//    private static final String ENDPOINT_URL = "/chapterss";
//    @MockBean
//    private ReferenceMapper referenceMapper;
//    @InjectMocks
//    private ChaptersControllerImpl chaptersController;
//    @MockBean
//    private ChaptersService chaptersService;
//    @MockBean
//    private ChaptersMapper chaptersMapper;
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(this.chaptersController).build();
//    }
//
//    @Test
//    public void getAll() throws Exception {
//        Mockito.when(chaptersMapper.asDTOList(ArgumentMatchers.any())).thenReturn(ChaptersBuilder.getListDTO());
//
//        Mockito.when(chaptersService.findAll()).thenReturn(ChaptersBuilder.getListEntities());
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
//        Mockito.when(chaptersMapper.asDTO(ArgumentMatchers.any())).thenReturn(ChaptersBuilder.getDTO());
//
//        Mockito.when(chaptersService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(ChaptersBuilder.getEntity()));
//
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
//        Mockito.verify(chaptersService, Mockito.times(1)).findById(1L);
//        Mockito.verifyNoMoreInteractions(chaptersService);
//    }
//
//    @Test
//    public void save() throws Exception {
//        Mockito.when(chaptersMapper.asEntity(ArgumentMatchers.any())).thenReturn(ChaptersBuilder.getEntity());
//        Mockito.when(chaptersService.save(ArgumentMatchers.any(Chapters.class))).thenReturn(ChaptersBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.post(ENDPOINT_URL)
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(ChaptersBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//        Mockito.verify(chaptersService, Mockito.times(1)).save(ArgumentMatchers.any(Chapters.class));
//        Mockito.verifyNoMoreInteractions(chaptersService);
//    }
//
//    @Test
//    public void update() throws Exception {
//        Mockito.when(chaptersMapper.asEntity(ArgumentMatchers.any())).thenReturn(ChaptersBuilder.getEntity());
//        Mockito.when(chaptersService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(ChaptersBuilder.getEntity());
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
//                                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                                .content(CustomUtils.asJsonString(ChaptersBuilder.getDTO())))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(chaptersService, Mockito.times(1)).update(ArgumentMatchers.any(Chapters.class), ArgumentMatchers.anyLong());
//        Mockito.verifyNoMoreInteractions(chaptersService);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        Mockito.doNothing().when(chaptersService).deleteById(ArgumentMatchers.anyLong());
//        mockMvc.perform(
//                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(chaptersService, Mockito.times(1)).deleteById(Mockito.anyLong());
//        Mockito.verifyNoMoreInteractions(chaptersService);
//    }

}