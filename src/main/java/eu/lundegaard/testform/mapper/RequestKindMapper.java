package eu.lundegaard.testform.mapper;

import eu.lundegaard.testform.domain.RequestKind;
import eu.lundegaard.testform.model.RequestKindResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface RequestKindMapper {

    RequestKindResponseDto mapToDto(RequestKind requestKind);
}
