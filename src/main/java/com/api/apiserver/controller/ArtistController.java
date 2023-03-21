package com.api.apiserver.controller;

import com.api.apiserver.DTO.artist.ArtistDTO;
import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.DTO.cartsitem.CreateCartsItem;
import com.api.apiserver.DTO.cartsitem.DeleteCartsItem;
import com.api.apiserver.DTO.cartsitem.ModifyCartsItem;
import com.api.apiserver.service.ArtistService;
import com.api.apiserver.service.CartsItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class ArtistController {

    private ArtistService artistService;

    // TODO 테스트코드 작성필요
    @GetMapping("/{companyId}/artists")
    public ResponseEntity<List<ArtistDTO>> getAllArtists(
            @Valid @PathVariable("companyId") Long companyId) {

        return ResponseEntity.ok(artistService.getAllCartsItemsByCompanyId(companyId));
    }
//
//    // TODO 테스트코드 작성필요
//    @PostMapping("/{companyId}/artists")
//    public ResponseEntity<CreateCartsItem.Response>  createCartsItem(
//            @RequestBody @Valid CreateCartsItem.Request request
//    ) {
//        return ResponseEntity.ok(CreateCartsItem.Response.from(
//                cartsItemService.createCartsItem(
//                        request.getUsersId(),
//                        request.getProductId(),
//                        request.getQty()
//                )));
//    }
//
//    // TODO 테스트코드 작성필요
//    @DeleteMapping("/{companyId}/artists")
//    public ResponseEntity<DeleteCartsItem.Response>  deleteCartItem(
//            @RequestBody @Valid DeleteCartsItem.Request request) {
//        return ResponseEntity.ok(DeleteCartsItem.Response.from(
//                cartsItemService.deleteCartsItem(
//                        request.getUsersId(),
//                        request.getCartItemId())));
//    }

}
