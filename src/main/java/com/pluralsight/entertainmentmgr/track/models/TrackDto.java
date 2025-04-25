package com.pluralsight.entertainmentmgr.track.models;

import com.pluralsight.entertainmentmgr.artist.models.ArtistDto;
import com.pluralsight.entertainmentmgr.core.auditable.models.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrackDto extends BaseDto {
    private String title;
    private int durationSeconds;
    private int yearReleased;
    private int beatsPerMinute;
    private Set<ArtistDto> artists;
}
