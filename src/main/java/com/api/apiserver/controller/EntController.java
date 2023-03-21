package com.api.apiserver.controller;

import com.api.apiserver.DTO.artist.ArtistDTO;
import com.api.apiserver.DTO.artist.CreateArtist;
import com.api.apiserver.DTO.artist.DeleteArtist;
import com.api.apiserver.DTO.ent.CreateEnt;
import com.api.apiserver.DTO.ent.DeleteEnt;
import com.api.apiserver.DTO.ent.EntDTO;
import com.api.apiserver.service.ArtistService;
import com.api.apiserver.service.EntService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class EntController {

    private EntService entService;

    // TODO 테스트코드 작성필요
    @GetMapping("/{companyId}/ent")
    public ResponseEntity<List<EntDTO>> getAllEnt(
            @Valid @PathVariable("companyId") Long companyId) {
        return ResponseEntity.ok(entService.getAllEntByCompanyId(companyId));
    }

    // TODO 테스트코드 작성필요
    @PostMapping("/{companyId}/ent")
    public ResponseEntity<CreateEnt.Response>  createEnt(
            @RequestBody @Valid CreateEnt.Request request,
            @Valid @PathVariable("companyId") Long companyId) {
        return ResponseEntity.ok(CreateEnt.Response.from(
                entService.createEnt(request.getEntName(), companyId)));
    }

    // TODO 테스트코드 작성필요
    @DeleteMapping("/{companyId}/ent")
    public ResponseEntity<DeleteEnt.Response>  DeleteEnt(
            @RequestBody @Valid DeleteEnt.Request request) {
        entService.deleteEnt(request.getId());
        return ResponseEntity.ok(DeleteEnt.Response.from(request.getEntName()));
    }

}
