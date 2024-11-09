package dev.seso.mena.mapper;

import dev.seso.mena.dto.MenaDto;
import dev.seso.mena.entity.Mena;

public class MenaMapper {

public static MenaDto mapToMenaDto (Mena mena) {
    return new MenaDto(
            mena.getId(),
            mena.getStNumber(),
            mena.getFirstName(),
            mena.getLastName(),
            mena.getDateOfBirth(),
            mena.getNationality(),
            mena.getTutor(),
            mena.getStatus()
            );
}

public static Mena mapToMena(MenaDto menaDto) {
    return new Mena (
            menaDto.getId(),
            menaDto.getStNumber(),
            menaDto.getFirstName(),
            menaDto.getLastName(),
            menaDto.getDateOfBirth(),
            menaDto.getNationality(),
            menaDto.getTutor(),
            menaDto.getStatus()
    );
}
}
