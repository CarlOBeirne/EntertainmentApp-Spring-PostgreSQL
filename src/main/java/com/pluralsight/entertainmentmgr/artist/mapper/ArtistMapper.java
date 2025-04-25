package com.pluralsight.entertainmentmgr.artist.mapper;

import com.pluralsight.entertainmentmgr.artist.entities.Artist;
import com.pluralsight.entertainmentmgr.artist.models.ArtistDto;
import com.pluralsight.entertainmentmgr.core.mapper.BaseMapper;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ArtistMapper extends BaseMapper<Artist, ArtistDto> {

    @Override
    ArtistDto toDTO(Artist entity);

    @Override
    @Mapping(target = "tracks", ignore = true)
    Artist toEntity(ArtistDto dto);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "tracks", ignore = true)
    void updateEntityFromDto(ArtistDto dto, @MappingTarget Artist entity);
}
