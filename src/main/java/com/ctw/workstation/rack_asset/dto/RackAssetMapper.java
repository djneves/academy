package com.ctw.workstation.rack_asset.dto;

import com.ctw.workstation.rack_asset.entity.RackAsset;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "cdi")
public interface RackAssetMapper {
    RackAssetMapper INSTANCE = Mappers.getMapper(RackAssetMapper.class);
    RackAsset toEntity(RackAssetRequestDTO rackAssetRequestDTO);
    RackAssetResponseDTO toDTO(RackAsset rackAsset);
    List<RackAssetResponseDTO> toDTOs(List<RackAsset> rackAssets);
}
