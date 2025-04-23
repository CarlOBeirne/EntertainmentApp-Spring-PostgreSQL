package com.pluralsight.entertainmentmgr.artist.services;

import com.pluralsight.entertainmentmgr.artist.models.ArtistDto;
import com.pluralsight.entertainmentmgr.artist.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class ArtistDataService {

    private final ArtistRepository artistRepository;

    public Optional<ArtistDto> findArtistById(Long artistId) {
        return Optional.empty();
    }

    public List<ArtistDto> findAllArtists() {
        return List.of();
    }

    public ArtistDto createArtist(ArtistDto artistDto) {
        return null;
    }

    public ArtistDto updateArtist(ArtistDto artistDto) {
        return null;
    }

    public void deleteArtist(Long artistId) {

    }
}
