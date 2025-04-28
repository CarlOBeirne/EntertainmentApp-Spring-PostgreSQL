//package com.pluralsight.entertainmentmgr.track.services;
//
//import com.pluralsight.entertainmentmgr.track.entities.Track;
//import com.pluralsight.entertainmentmgr.track.repositories.TrackRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class TrackDataServiceTest {
//
//    private Track track;
//
//    @Mock
//    private TrackRepository trackRepository;
//
//    @InjectMocks
//    private TrackDataService trackDataService;
//
//    @BeforeEach
//    void setUp() {
//
//        track = new Track(
//                "High Hopes",
//                500,
//                Genre.ROCK,
//                1988,
//                85);
//
//        track.setId(1);
//    }
//
//    @Test
//    void updateTrack_shouldCallFindByIdAndUpdateOnceAndUpdateTrack() {
//        when(trackRepository.findById(1)).thenReturn(Optional.ofNullable(track));
//        when(trackRepository.update(track)).thenReturn(true);
//
//        boolean result = trackDataService.updateTrack(track);
//
//        assertTrue(result);
//        verify(trackRepository, times(1)).findById(1);
//        verify(trackRepository, times(1)).update(track);
//    }
//
//    @Test
//    void updateTrack_shouldOnlyCallFindByIdOnceAndNotUpdateForNonExistentTrack() {
//        track.setId(2);
//        when(trackRepository.findById(2)).thenReturn(Optional.empty());
//
//        boolean result = trackDataService.updateTrack(track);
//
//        assertFalse(result);
//
//        verify(trackRepository, times(1)).findById(2);
//        verify(trackRepository, times(0)).update(track);
//    }
//
//    @Test
//    void deleteTrack_shouldCallFindByIdAndDeleteOnceAndShouldDeleteTrack() {
//        when(trackRepository.findById(1)).thenReturn(Optional.ofNullable(track));
//        when(trackRepository.delete(track)).thenReturn(true);
//
//        boolean result = trackDataService.deleteTrack(1);
//
//        assertTrue(result);
//
//        verify(trackRepository, times(1)).findById(1);
//        verify(trackRepository, times(1)).delete(track);
//    }
//
//    @Test
//    void deleteTrack_shouldOnlyCallFindByIdOnceAndNotDeleteForNonExistentTrack() {
//        track.setId(2);
//        when(trackRepository.findById(2)).thenReturn(Optional.empty());
//        boolean result = trackDataService.deleteTrack(2);
//
//        assertFalse(result);
//
//        verify(trackRepository, times(1)).findById(2);
//        verify(trackRepository, times(0)).delete(track);
//    }
//
//    @Test
//    void insertTrack_shouldCallInsertAndFindByIdOnceAndInsertTrack() {
//        when(trackRepository.insert(track)).thenReturn(track);
//        when(trackRepository.findById(1)).thenReturn(Optional.ofNullable(track));
//
//        Track createdTrack = trackDataService.insertTrack(track);
//
//        Track returnedTrack = trackDataService.findTrackById(createdTrack.getId());
//
//        assertEquals(track, returnedTrack);
//
//        verify(trackRepository, times(1)).insert(track);
//        verify(trackRepository, times(1)).findById(1);
//    }
//
//    @Test
//    void insertTrack_shouldReturnNullIfTrackIsNullAndCallInsertOnce() {
//        when(trackRepository.insert(any())).thenReturn(null);
//
//        Track createdTrack = trackDataService.insertTrack(null);
//
//        assertNull(createdTrack);
//        verify(trackRepository, times(1)).insert(any());
//    }
//
//    @Test
//    void findTrackById_shouldCallFindByIdOnceAndReturnTrack() {
//        when(trackRepository.findById(1)).thenReturn(Optional.ofNullable(track));
//
//        Track expectedTrack = trackDataService.findTrackById(1);
//        assertEquals(expectedTrack, track);
//
//        verify(trackRepository, times(1)).findById(1);
//    }
//
//    @Test
//    void findTrackById_shouldCallFindByIdOnceAndReturnNullIfTrackDoesNotExist() {
//        when(trackRepository.findById(1)).thenReturn(Optional.empty());
//
//        Track expectedTrack = trackDataService.findTrackById(1);
//
//        assertNull(expectedTrack);
//        verify(trackRepository, times(1)).findById(1);
//    }
//
//    @Test
//    void findAllTracks_shouldCallFindAllOnceAndReturnAllTracks() {
//        when(trackRepository.findAll()).thenReturn(List.of(track));
//
//        List<Track> expectedTracks = trackDataService.findAllTracks();
//
//        verify(trackRepository, times(1)).findAll();
//
//        assertAll(
//                () -> assertNotNull(expectedTracks),
//                () -> assertEquals(1, expectedTracks.size()),
//                () -> assertEquals(expectedTracks.get(0), track)
//        );
//    }
//
//    @Test
//    void resetTrackDataStore() {
//        trackRepository.resetDataStore();
//        verify(trackRepository,  times(1)).resetDataStore();
//    }
//
//}