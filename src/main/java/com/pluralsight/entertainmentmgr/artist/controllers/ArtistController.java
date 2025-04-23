package com.pluralsight.entertainmentmgr.artist.controllers;

import com.pluralsight.entertainmentmgr.artist.models.ArtistDto;
import com.pluralsight.entertainmentmgr.artist.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ArtistController {

    private final ArtistRepository artistRepository;

    @GetMapping
    public ResponseEntity<List<ArtistDto>> getAllArtists() {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistDto> getArtistById(@PathVariable Long id) {
        return ResponseEntity.ok(null);
    }

    @PostMapping
    public ResponseEntity<ArtistDto> createArtist(@RequestBody ArtistDto artistDto) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtistDto> updateArtist(@RequestBody ArtistDto artistDto, @PathVariable Long id) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        return ResponseEntity.ok(null);
    }
    
}
