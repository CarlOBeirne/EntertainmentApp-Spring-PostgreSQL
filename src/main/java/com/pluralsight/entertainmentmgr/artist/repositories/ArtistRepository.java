package com.pluralsight.entertainmentmgr.artist.repositories;

import com.pluralsight.entertainmentmgr.artist.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
