package com.api.apiserver.service;

import com.api.apiserver.DTO.artist.ArtistDTO;
import com.api.apiserver.DTO.cartsitem.CartsItemDTO;
import com.api.apiserver.domain.Artist;
import com.api.apiserver.domain.CartsItem;
import com.api.apiserver.domain.Product;
import com.api.apiserver.domain.Users;
import com.api.apiserver.exception.CartsItemException;
import com.api.apiserver.repository.ArtistRepository;
import com.api.apiserver.repository.CartsItemRepository;
import com.api.apiserver.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.api.apiserver.type.ErrorCode.*;

@Transactional
@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService{

    private final ArtistRepository artistRepository;
    private final CompanyRepository companyRepository;

    // TODO 테스트코드 작성필요
    @Override
    public List<ArtistDTO> getAllCartsItemsByCompanyId(Long companyId) {
        return artistRepository.findByCompany_Id(companyId)
                .stream()
                .map(artist -> ArtistDTO.fromEntity(artist))
                .toList();
    }

    @Override
    public Artist createArtist(String artistName, Long companyId) {
        return artistRepository.save(Artist.builder()
                .name(artistName)
                .company(companyRepository.findById(companyId))
                .build());
    }

    @Override
    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }

    @Override
    public Artist getOrCreateArtistByCompanyIdAndArtistName(Long companyId, String artistName) {
        Optional<Artist> artist = artistRepository.findByCompany_IdAndName(companyId, artistName);
        if (artist.isPresent()){
            return artist.get();
        }else {
            return createArtist(artistName, companyId);
        }
    }
}
