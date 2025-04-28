package com.pluralsight.entertainmentmgr.genre.models;

import com.pluralsight.entertainmentmgr.core.auditable.models.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenreDto extends BaseDto {
    private String name;
    private String description;
}
