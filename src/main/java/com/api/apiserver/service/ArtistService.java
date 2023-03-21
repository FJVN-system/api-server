package com.api.apiserver.service;


import com.api.apiserver.DTO.artist.ArtistDTO;
import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.domain.CartsItem;

import java.util.List;

public interface ArtistService {
    List<ArtistDTO> getAllCartsItemsByCompanyId(Long companyId);

}
