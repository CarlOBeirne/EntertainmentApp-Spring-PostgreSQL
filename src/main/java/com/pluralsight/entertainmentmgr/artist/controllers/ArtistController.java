package com.pluralsight.entertainmentmgr.artist.controllers;

import com.pluralsight.entertainmentmgr.artist.models.ArtistDto;
import com.pluralsight.entertainmentmgr.artist.services.ArtistDataService;
import com.pluralsight.entertainmentmgr.core.exceptions.InvalidArtistException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/artist")
@Log4j2
public class ArtistController {

    private final ArtistDataService artistDataService;

    @PostMapping(path = "/new")
    public ResponseEntity<ArtistDto> createArtist(@NonNull @RequestBody ArtistDto artist)  {
        try {
            if (artist.getId() != null) {
                log.warn("Artist was passed with an Id of {} (expecting Id to be null)", artist.getId());
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            return ResponseEntity.ok(artistDataService.createArtist(artist));
        } catch (InvalidArtistException e) {
            throw e;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<ArtistDto> updateArtist(@NonNull @PathVariable Long id, @NonNull @RequestBody ArtistDto artistDto)  {
        try {
            Optional<ArtistDto> optionalArtist = artistDataService.findArtistById(artistDto.getId());
            if (optionalArtist.isEmpty()) {
                log.info("Could not find artist with id {}", artistDto.getId());
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(artistDataService.updateArtist(id, artistDto));
        } catch (InvalidArtistException e) {
            log.warn("Warning trying to update artist. {}",e.getMessage());
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistDto> getArtistById(@NonNull @PathVariable Long id)  {
        try {
            Optional<ArtistDto> optionalArtist = artistDataService.findArtistById(id);
            return optionalArtist
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (InvalidArtistException e) {
            throw e;
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<ArtistDto>> getAllArtists() {
        try {
            List<ArtistDto> allArtists = artistDataService.findAllArtists();
            if (allArtists.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(allArtists);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<ArtistDto>> getArtistByName(@RequestParam("name") String name) {
        if (name.isBlank()) {
            return ResponseEntity.notFound().build();
        }
        try {
            List<ArtistDto> allArtistsByName = artistDataService.findArtistsByName(name);;
            if (allArtistsByName.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(allArtistsByName);
        } catch (NullPointerException npe) {
            log.warn("Artist name is null", npe);
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Boolean> deleteArtistById(@NonNull @PathVariable Long id)  {
        try {
            Optional<ArtistDto> optionalArtist = artistDataService.findArtistById(id);
            if (optionalArtist.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            artistDataService.deleteArtist(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (InvalidArtistException e) {
            throw e;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}
