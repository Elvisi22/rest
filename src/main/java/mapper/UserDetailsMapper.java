package mapper;

import dto.UserDetailsDTO;
import entity.UserDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserDetailsMapper {
    UserDetailsMapper INSTANCE = Mappers.getMapper(UserDetailsMapper.class);

    UserDetails toDTO(UserDetails userDetails);
    UserDetails toEntity(UserDetailsDTO userDetailsDTO);
}
