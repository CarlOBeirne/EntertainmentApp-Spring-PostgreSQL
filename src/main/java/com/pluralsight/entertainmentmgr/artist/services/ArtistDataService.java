package com.pluralsight.entertainmentmgr.artist.services;

import com.pluralsight.entertainmentmgr.artist.entities.Artist;
import com.pluralsight.entertainmentmgr.artist.mapper.ArtistMapper;
import com.pluralsight.entertainmentmgr.artist.models.ArtistDto;
import com.pluralsight.entertainmentmgr.artist.repositories.ArtistRepository;
import com.pluralsight.entertainmentmgr.core.exceptions.InvalidArtistException;
import jakarta.transaction.Transactional;
import lombok.NonNull;
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
    private final ArtistMapper artistMapper;

    public Optional<ArtistDto> findArtistById(@NonNull Long artistId) {
        Optional<Artist> optionalArtist = artistRepository.findById(artistId);
        return optionalArtist.map(artistMapper::toDTO);
    }

    public List<ArtistDto> findAllArtists() {
        return artistRepository.findAll().stream()
                .map(artistMapper::toDTO)
                .toList();
    }

    @Transactional
    public ArtistDto createArtist(@NonNull ArtistDto artistDto) throws InvalidArtistException{
        if (artistDto.getId() != null) {
            log.warn("Artist passed with Id {}", artistDto.getId());
            throw new InvalidArtistException("Attempted to create a new artist that already has an Id");
        }
        Artist artistEntity = artistMapper.toEntity(artistDto);
        Artist persistedArtist = artistRepository.save(artistEntity);
        return artistMapper.toDTO(persistedArtist);
    }

    public ArtistDto updateArtist(ArtistDto artistDto) {
        return null;
    }

    public void deleteArtist(Long artistId) {

    }
}
