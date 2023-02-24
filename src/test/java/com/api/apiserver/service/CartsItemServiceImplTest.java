package com.api.apiserver.service;

import com.api.apiserver.domain.CartsItem;
import com.api.apiserver.domain.Product;
import com.api.apiserver.domain.Users;
import com.api.apiserver.exception.CartsItemException;
import com.api.apiserver.repository.CartsItemRepository;
import com.api.apiserver.repository.ProductRepository;
import com.api.apiserver.repository.UsersRepository;
import org.apache.catalina.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.api.apiserver.type.ErrorCode.CART_ITEM_NOT_FOUND;
import static java.time.LocalDateTime.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class CartsItemServiceImplTest {

    @Mock
    private CartsItemRepository cartsItemRepository;

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private UsersService usersService;

    @Mock
    private ProductService productService;

    @InjectMocks
    private CartsItemServiceImpl cartsItemService;


    @Test
    @DisplayName("성공 - 장바구니(CartsItem) ID로 장바구니 1개 찾기")
    void successGetCartsItemByCartsItemId() {
        // given
        Product product = Product.builder()
                .id(23423L)
                .build();
        Users users = Users.builder()
                .id(235346L)
                .build();
        CartsItem mockedCartsItem = CartsItem.builder()
                .product(product)
                .users(users)
                .price(10000L)
                .qty(2L)
                .updatedAt(now())
                .createdAt(now())
                .build();
        given(productRepository.findById(anyLong()))
                .willReturn(Optional.of(product));
        given(usersRepository.findById(anyLong()))
                .willReturn(Optional.of(users));
        given(cartsItemRepository.findById(anyLong()))
                .willReturn(Optional.of(mockedCartsItem));

        // when
        CartsItem cartsItem = cartsItemService.getCartsItem(1L);

        // then
        assertEquals(23423L, cartsItem.getProduct().getId());
        assertEquals(235346L, cartsItem.getUsers().getId());
        assertEquals(10000L, cartsItem.getPrice());
        assertEquals(2L, cartsItem.getQty());
    }

    @Test
    @DisplayName("실패 - 장바구니에 없음. 장바구니(CartsItem) ID로 장바구니 1개 찾기")
    void failGetCartsItemByCartsItemId() {
        // given
        given(cartsItemRepository.findById(anyLong()))
                .willReturn(Optional.empty());

        // when
        CartsItemException exception = assertThrows(CartsItemException.class,
                () -> cartsItemService.getCartsItem(1L));

        // then
        assertEquals(CART_ITEM_NOT_FOUND, exception.getErrorCode());
    }

}