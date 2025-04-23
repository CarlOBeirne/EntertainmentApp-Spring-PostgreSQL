package com.pluralsight.entertainmentmgr.artist.entities;

import com.pluralsight.entertainmentmgr.artist.enums.ArtistType;
import com.pluralsight.entertainmentmgr.core.auditable.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Artist extends BaseEntity {

    @EqualsAndHashCode.Include
    private String name;

    @EqualsAndHashCode.Include
    private ArtistType artistType;

    // TODO: Leverage genres table for list of genres

    private String biography;

    @EqualsAndHashCode.Include
    private String nationality;

    @EqualsAndHashCode.Include
    private int yearFounded;

}
