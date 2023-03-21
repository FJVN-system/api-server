package com.api.apiserver.DTO.ent;

import com.api.apiserver.domain.Artist;
import com.api.apiserver.domain.Ent;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntDTO {

    private Long id;
    private String artistName;
    private Long companyId;

    public static EntDTO fromEntity(Ent ent) {
        return EntDTO.builder()
                .id(ent.getId())
                .artistName(ent.getName())
                .companyId(ent.getCompany().getId())
                .build();
    }
}
