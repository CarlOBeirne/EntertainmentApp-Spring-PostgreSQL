package com.pluralsight.entertainmentmgr.track.entities;

import com.pluralsight.entertainmentmgr.core.auditable.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
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

    @EqualsAndHashCode.Include
    private int yearReleased;

    @EqualsAndHashCode.Include
    private int beatsPerMinute;
}
