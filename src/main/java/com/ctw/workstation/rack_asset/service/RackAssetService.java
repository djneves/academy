package com.ctw.workstation.rack_asset.service;

import com.ctw.workstation.rack_asset.dto.RackAssetMapper;
import com.ctw.workstation.rack_asset.dto.RackAssetRequestDTO;
import com.ctw.workstation.rack_asset.dto.RackAssetResponseDTO;
import com.ctw.workstation.rack_asset.entity.RackAsset;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class RackAssetService {

    @Inject
    RackAssetRepository rackAssetRepository;
    @Inject
    RackAssetMapper rackAssetMapper;

    @Transactional
    public RackAssetResponseDTO createRackAsset(RackAssetRequestDTO rackAssetRequestDTO) {
        RackAsset rackAsset = rackAssetMapper.toEntity(rackAssetRequestDTO);
        rackAssetRepository.persist(rackAsset);
        return rackAssetMapper.toDTO(rackAsset);
    }

    public List<RackAssetResponseDTO> getRackAssets() {
        return rackAssetRepository.listAll().stream()
                .map(rackAssetMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public RackAssetResponseDTO getRackAssetById(Long id) {
        Optional<RackAsset> rackAssetOptional = rackAssetRepository.findByIdOptional(id);
        if (rackAssetOptional.isPresent())
            return rackAssetMapper.toDTO(rackAssetOptional.get());
        else
            throw new RuntimeException("RackAsset not found");
    }

    @Transactional
    public RackAssetResponseDTO updateRackAsset(Long id, RackAssetRequestDTO rackAssetRequestDTO) {
        Optional<RackAsset> rackAssetOptional = rackAssetRepository.findByIdOptional(id);
        if (rackAssetOptional.isPresent()) {
            RackAsset rackAsset = rackAssetOptional.get();
            rackAsset.assetTag = rackAssetRequestDTO.assetTag();
            return rackAssetMapper.toDTO(rackAsset);
        } else
            throw new RuntimeException("RackAsset not found");
    }

    @Transactional
    public void deleteRackAsset(Long id) {
        Optional<RackAsset> rackAssetOptional = rackAssetRepository.findByIdOptional(id);
        if (rackAssetOptional.isPresent())
            rackAssetRepository.delete(rackAssetOptional.get());
        else
            throw new RuntimeException("RackAsset not found");
    }
}
