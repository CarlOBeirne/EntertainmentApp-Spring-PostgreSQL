package com.pluralsight.entertainmentmgr.artist.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pluralsight.entertainmentmgr.artist.models.ArtistDto;
import com.pluralsight.entertainmentmgr.artist.repositories.ArtistRepository;
import com.pluralsight.entertainmentmgr.core.security.app_user.entities.AppUser;
import com.pluralsight.entertainmentmgr.core.security.app_user.repositories.AppUserRepository;
import com.pluralsight.entertainmentmgr.genre.repositories.GenreRepository;
import com.pluralsight.entertainmentmgr.track.repositories.TrackRepository;
import com.pluralsight.entertainmentmgr.track.services.TrackDataService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@ActiveProfiles("test")
class ArtistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private final AppUserRepository appUserRepository;

    @Autowired
    private TrackDataService trackDataService;

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        genreRepository.deleteAll();
        trackRepository.deleteAll();
        artistRepository.deleteAll();
        appUserRepository.deleteAll();
    }

    @Test
    @WithMockUser(authorities = {"ROLE_ADMIN", "ROLE_USER"})
    void createArtist_shouldCreateArtist_andReturnStatus201() throws Exception {
        AppUser user = AppUser.builder().username("fake").password("fake").build();
        AppUser persistedUser = appUserRepository.save(user);
        ArtistDto artistDto = ArtistDto.builder().name("Fake").appUser(persistedUser).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/artist/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(artistDto)))
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser(authorities = {"ROLE_ADMIN", "ROLE_USER"})
    void createArtist_should() throws Exception {
        AppUser user = AppUser.builder().username("fake").password("fake").build();
        AppUser persistedUser = appUserRepository.save(user);
        ArtistDto artistDto = ArtistDto.builder().name("Fake").appUser(persistedUser).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/artist/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(artistDto)))
                .andExpect(status().isCreated());
    }



}