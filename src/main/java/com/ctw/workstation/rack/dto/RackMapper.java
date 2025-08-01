package com.ctw.workstation.rack.dto;

import com.ctw.workstation.rack.entity.Rack;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "cdi")
public interface RackMapper {
    //RackMapper INSTANCE = Mappers.getMapper(RackMapper.class);
    Rack toEntity(RackRequestDTO rackRequestDTO);
    RackResponseDTO toDTO(Rack rack);
    List<RackResponseDTO> toDTOs(List<Rack> racks);
}
