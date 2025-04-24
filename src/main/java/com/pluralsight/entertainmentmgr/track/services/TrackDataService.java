package com.pluralsight.entertainmentmgr.track.services;

import com.pluralsight.entertainmentmgr.track.entities.Track;
import com.pluralsight.entertainmentmgr.track.mapper.TrackMapper;
import com.pluralsight.entertainmentmgr.track.models.TrackDto;
import com.pluralsight.entertainmentmgr.track.repositories.TrackRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class TrackDataService {

    private final TrackRepository trackRepository;

    private final TrackMapper trackMapper;

    public Optional<TrackDto> findTrackById(Long trackId) {
        return trackRepository.findById(trackId)
                .map(trackMapper::toDTO);
    }

    public List<TrackDto> findAllTracks() {
        return trackRepository.findAll().stream()
                .map(trackMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TrackDto createTrack(TrackDto trackDto) {
        Track entity = trackMapper.toEntity(trackDto);
        return trackMapper.toDTO(trackRepository.save(entity));
    }

    public TrackDto updateTrack(Long id, TrackDto trackDto) {
        Track entity = trackMapper.toEntity(trackDto);
        Optional<Track> existing = trackRepository.findById(id);
        if (existing.isEmpty()) return null;
        trackMapper.updateEntityFromDto(trackDto, existing.get());
        return trackMapper.toDTO(trackRepository.save(entity));

    }

    public void deleteTrack(Long trackId) {
        trackRepository.deleteById(trackId);
    }

}
