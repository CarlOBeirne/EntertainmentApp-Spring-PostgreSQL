package com.pluralsight.entertainmentmgr.track.entities;

import com.pluralsight.entertainmentmgr.core.base_entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Track extends BaseEntity {

    @EqualsAndHashCode.Include
    private String title;

    @EqualsAndHashCode.Include
    private int durationSeconds;

//    TODO: Create genre feature with separate entity

    @EqualsAndHashCode.Include
    private int yearReleased;

    @EqualsAndHashCode.Include
    private int beatsPerMinute;
}
