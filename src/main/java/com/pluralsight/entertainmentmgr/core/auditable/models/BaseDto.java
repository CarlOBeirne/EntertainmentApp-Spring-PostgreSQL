package com.pluralsight.entertainmentmgr.core.auditable.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class BaseDto {

    private Long id;
    private LocalDateTime created;

}
