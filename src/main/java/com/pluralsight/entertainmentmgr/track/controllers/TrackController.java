package com.pluralsight.entertainmentmgr.track.controllers;

import com.pluralsight.entertainmentmgr.track.model.TrackDto;
import com.pluralsight.entertainmentmgr.track.repositories.TrackRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class TrackController {

    private final TrackRepository trackRepository;

    @GetMapping
    public ResponseEntity<List<TrackDto>> getAllTracks() {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackDto> getTrackById(@PathVariable Long id) {
        return ResponseEntity.ok(null);
    }

    @PostMapping
    public ResponseEntity<TrackDto> createTrack(@RequestBody TrackDto trackDto) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrackDto> updateTrack(@RequestBody TrackDto trackDto, @PathVariable Long id) {
        return ResponseEntity.ok(null);
    }
    //202 if ok, 404 if wrong
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrack(@PathVariable Long id) {
        return ResponseEntity.ok(null);
    }
}
