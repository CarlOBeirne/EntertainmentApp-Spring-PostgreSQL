package com.pluralsight.entertainmentmgr.track.controllers;

import com.pluralsight.entertainmentmgr.track.models.TrackDto;
import com.pluralsight.entertainmentmgr.track.services.TrackDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Log4j2
public class TrackController {

    private final TrackDataService trackDataService;

    @GetMapping
    public ResponseEntity<List<TrackDto>> getAllTracks() {
        return ResponseEntity.ok(trackDataService.findAllTracks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackDto> getTrackById(@PathVariable Long id) {
        Optional<TrackDto> track = trackDataService.findTrackById(id);
        return track.isPresent() ? ResponseEntity.ok(track.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TrackDto> createTrack(@RequestBody TrackDto trackDto) {
        TrackDto track = trackDataService.createTrack(trackDto);
        return track != null ? ResponseEntity.ok(track) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrackDto> updateTrack(@RequestBody TrackDto trackDto, @PathVariable Long id) {
        TrackDto track = trackDataService.updateTrack(id, trackDto);
        return track != null ? ResponseEntity.ok(track) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrack(@PathVariable Long id) {
        trackDataService.deleteTrack(id);
        return ResponseEntity.noContent().build();
    }
}
