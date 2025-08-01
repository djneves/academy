package com.ctw.workstation.rack.service;

import com.ctw.workstation.rack.dto.RackMapper;
import com.ctw.workstation.rack.dto.RackRequestDTO;
import com.ctw.workstation.rack.dto.RackResponseDTO;
import com.ctw.workstation.rack.entity.Rack;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class RackService {

    @Inject
    RackRepository rackRepository;
    @Inject
    RackMapper rackMapper;


    @Transactional
    public RackResponseDTO createRack(RackRequestDTO rackRequestDTO) {
        Rack rack = rackMapper.toEntity(rackRequestDTO);
        rackRepository.persist(rack);
        return rackMapper.toDTO(rack);
    }

    public List<RackResponseDTO> getRacks() {
        return rackRepository.listAll().stream()
                .map(rackMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public RackResponseDTO getRackById(Long id) {
        Optional<Rack> rackOptional = rackRepository.findByIdOptional(id);
        if (rackOptional.isPresent())
            return rackMapper.toDTO(rackOptional.get());
        else
            throw new RuntimeException("Rack not found");
    }

    @Transactional
    public RackResponseDTO updateRack(Long id, RackRequestDTO rackRequestDTO) {
        Optional<Rack> rackOptional = rackRepository.findByIdOptional(id);
        if (rackOptional.isPresent()) {
            Rack rack = rackOptional.get();
            rack.status = rackRequestDTO.status();
            rack.teamId = rackRequestDTO.teamId();
            return rackMapper.toDTO(rack);
        } else
            throw new RuntimeException("Rack not found");
    }

    @Transactional
    public void deleteRack(Long id){
        Optional<Rack> rackOptional = rackRepository.findByIdOptional(id);
        if (rackOptional.isPresent())
            rackRepository.delete(rackOptional.get());
        else
            throw new RuntimeException("Rack not found");
    }
}
