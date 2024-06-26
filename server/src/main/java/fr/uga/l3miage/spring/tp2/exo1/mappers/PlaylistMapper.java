package fr.uga.l3miage.spring.tp2.exo1.mappers;

import fr.uga.l3miage.exo1.requests.PlaylistCreationRequest;
import fr.uga.l3miage.exo1.response.PlaylistResponseDTO;
import fr.uga.l3miage.spring.tp2.exo1.models.PlaylistEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PlaylistMapper {

    PlaylistResponseDTO toResponse(PlaylistEntity playlistEntity);

    @Mapping(target = "songEntities", ignore = true)
    PlaylistEntity toEntity(PlaylistCreationRequest request);
}
