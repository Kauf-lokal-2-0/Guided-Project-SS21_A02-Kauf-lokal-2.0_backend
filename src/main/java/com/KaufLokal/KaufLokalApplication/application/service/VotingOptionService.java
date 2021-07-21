package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.VotingOptionDto;
import com.KaufLokal.KaufLokalApplication.domain.model.VotingOption;
import com.KaufLokal.KaufLokalApplication.domain.repository.VotingOptionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VotingOptionService implements IDefaultService<VotingOption, VotingOptionDto> {


    @Autowired
    VotingOptionRepository votingOptionRepository;

    @Override
    public List<VotingOptionDto> findAll() {
        return null;
    }

    @Override
    public VotingOptionDto findById(UUID id) {
        return null;
    }

    @Override
    public VotingOptionDto create(VotingOptionDto dto) {
        return null;
    }

    @Override
    public VotingOptionDto update(VotingOptionDto dto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<VotingOptionDto> mapToDto(List<VotingOption> votingOptionOptions) {
        List<VotingOptionDto> votingOptionOptionDtos = new ArrayList<>();
        for (VotingOption votingOption : votingOptionOptions) {
            votingOptionOptionDtos.add(mapToDto(votingOption));
        }
        return votingOptionOptionDtos;
    }

    @Override
    public VotingOptionDto mapToDto(VotingOption votingOption) {
        ModelMapper modelMapper = new ModelMapper();
        VotingOptionDto votingOptionOptionDto = new VotingOptionDto();
        modelMapper.map(votingOption, votingOptionOptionDto);
        return votingOptionOptionDto;
    }

    @Override
    public VotingOption mapDtoToObject(VotingOptionDto votingOptionOptionDto, VotingOption votingOption) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(votingOptionOptionDto, votingOption);
        return votingOption;
    }

    @Override
    public VotingOption mapDtoToObject(VotingOptionDto votingOptionOptionDto) {
        return mapDtoToObject(votingOptionOptionDto, new VotingOption());
    }
}
