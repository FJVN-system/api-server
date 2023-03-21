package com.api.apiserver.service;

import com.api.apiserver.DTO.artist.ArtistDTO;
import com.api.apiserver.DTO.ent.EntDTO;
import com.api.apiserver.domain.Artist;
import com.api.apiserver.domain.Ent;
import com.api.apiserver.repository.ArtistRepository;
import com.api.apiserver.repository.CompanyRepository;
import com.api.apiserver.repository.EntRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class EntServiceImpl implements EntService{

    private final EntRepository entRepository;
    private final CompanyRepository companyRepository;

    // TODO 테스트코드 작성필요
    @Override
    public List<EntDTO> getAllEntByCompanyId(Long companyId) {
        return entRepository.findByCompany_Id(companyId)
                .stream()
                .map(ent -> EntDTO.fromEntity(ent))
                .toList();
    }

    @Override
    public Ent createEnt(String entName, Long companyId) {
        return entRepository.save(Ent.builder()
                .name(entName)
                .company(companyRepository.findById(companyId))
                .build());
    }

    @Override
    public void deleteEnt(Long id) {
        entRepository.deleteById(id);
    }
}
