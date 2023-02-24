package com.api.apiserver.controller;

import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.DTO.cartsitem.CreateCartsItem;
import com.api.apiserver.service.CartsItemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDateTime.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CartsItemController.class)
class CartsItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CartsItemService cartsItemService;

    @Test
    @DisplayName("성공 - 장바구니 아이템 생성")
    void successCreateCartsItem() throws Exception {
        // given
        given(cartsItemService.createCartsItem(anyLong(), anyLong(), anyLong()))
                .willReturn(CartsItemDTO.builder()
                        .id(1L)
                        .productTitle("Butter")
                        .createdAt(now())
                        .updatedAt(now())
                        .price(1000L)
                        .qty(5L)
                        .build());
        // when
        // then
        mockMvc.perform(post("/carts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                new CreateCartsItem.Request(1L, 2L, 3L)
                        )))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productTitle").value("Butter"))
                .andExpect(jsonPath("$.qty").value(5L))
                .andExpect(jsonPath("$.price").value(1000L))
                .andDo(print());

    };

    @Test
    @DisplayName("유저아이디로 장바구니 조회")
    void successGetAllCartsItemsByUserId() throws Exception {
        // given
        List<CartsItemDTO> cartsItemDTOList = Arrays.asList(
                CartsItemDTO.builder()
                        .productTitle("Dynamite")
                        .price(3000L)
                        .qty(3L)
                        .build(),
                CartsItemDTO.builder()
                        .productTitle("Butter")
                        .price(30000L)
                        .qty(30L)
                        .build()
        );

        given(cartsItemService.getAllCartsItemsByUserId(anyLong()))
                .willReturn(cartsItemDTOList);

        // when
        // then
        mockMvc.perform(get("/carts/1"))
                .andDo(print())
                .andExpect(jsonPath("$[0].productTitle").value("Dynamite"))
                .andExpect(jsonPath("$[0].price").value(3000L))
                .andExpect(jsonPath("$[0].qty").value(3L))
                .andExpect(jsonPath("$[1].productTitle").value("Butter"))
                .andExpect(jsonPath("$[1].price").value(30000L))
                .andExpect(jsonPath("$[1].qty").value(30L));
    }
}