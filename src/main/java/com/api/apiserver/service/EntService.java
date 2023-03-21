package com.api.apiserver.service;


import com.api.apiserver.DTO.artist.ArtistDTO;
import com.api.apiserver.DTO.ent.EntDTO;
import com.api.apiserver.domain.Artist;
import com.api.apiserver.domain.Ent;

import java.util.List;

public interface EntService {
    List<EntDTO> getAllEntByCompanyId(Long companyId);

    Ent createEnt(String entName, Long companyId);

    void deleteEnt(Long id);
}
