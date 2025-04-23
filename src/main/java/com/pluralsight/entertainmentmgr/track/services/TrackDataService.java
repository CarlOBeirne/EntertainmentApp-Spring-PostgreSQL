package com.pluralsight.entertainmentmgr.track.services;

import com.pluralsight.entertainmentmgr.track.model.TrackDto;
import com.pluralsight.entertainmentmgr.track.repositories.TrackRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class TrackDataService {

    private final TrackRepository trackRepository;

    public Optional<TrackDto> findTrackById(Long trackId) {
        return Optional.empty();
    }

    public List<TrackDto> findAllTracks() {
        return List.of();
    }

    public TrackDto createTrack(TrackDto trackDto) {
        return null;
    }

    public TrackDto updateTrack(TrackDto trackDto) {
        return null;
    }

    public void deleteTrack(Long trackId) {

    }
}
