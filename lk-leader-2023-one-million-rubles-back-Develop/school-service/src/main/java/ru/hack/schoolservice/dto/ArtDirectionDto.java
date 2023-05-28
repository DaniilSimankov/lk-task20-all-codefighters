package ru.hack.schoolservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.hack.schoolservice.models.ArtDirection;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ArtDirectionDto {
    private String id;
    private String name;
    private String imageUrl;

    public static ArtDirectionDto from(ArtDirection artDirection){
        return ArtDirectionDto.builder()
//                .id(artDirection.getId())
                .name(artDirection.getName())
                .imageUrl(artDirection.getImageUrl())
                .build();
    }

    public static Set<ArtDirectionDto> from(Set<ArtDirection> artDirections){
        return artDirections.stream().map(ArtDirectionDto::from).collect(Collectors.toSet());
    }
}
