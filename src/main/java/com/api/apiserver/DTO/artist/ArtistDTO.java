package com.api.apiserver.DTO.artist;

import com.api.apiserver.domain.Artist;
import com.api.apiserver.domain.CartsItem;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtistDTO {

    private Long id;
    private String artistName;
    private Long companyId;

    public static ArtistDTO fromEntity(Artist artist) {
        return ArtistDTO.builder()
                .id(artist.getId())
                .artistName(artist.getName())
                .companyId(artist.getCompany().getId())
                .build();
    }
}
