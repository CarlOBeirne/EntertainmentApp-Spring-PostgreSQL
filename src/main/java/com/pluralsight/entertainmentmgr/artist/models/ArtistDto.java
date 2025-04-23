package com.pluralsight.entertainmentmgr.artist.models;

import com.pluralsight.entertainmentmgr.artist.enums.ArtistType;
import com.pluralsight.entertainmentmgr.core.auditable.models.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArtistDto extends BaseDto {
    private String name;
    private ArtistType artistType;
    private String biography;
    private String nationality;
    private int yearFounded;
}
