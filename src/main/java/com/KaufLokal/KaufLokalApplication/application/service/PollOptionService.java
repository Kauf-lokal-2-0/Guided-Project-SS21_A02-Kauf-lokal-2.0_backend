package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.PollOptionDto;
import com.KaufLokal.KaufLokalApplication.domain.model.PollOption;
import com.KaufLokal.KaufLokalApplication.domain.repository.PollOptionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PollOptionService implements IDefaultService<PollOption, PollOptionDto> {


    @Autowired
    private PollOptionRepository pollOptionRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PollOptionDto> findAll() {
        return null;
    }

    @Override
    public PollOptionDto findById(UUID id) {
        return null;
    }

    @Override
    public PollOptionDto create(PollOptionDto dto) {
        return null;
    }

    @Override
    public PollOptionDto update(PollOptionDto dto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<PollOptionDto> mapToDto(List<PollOption> pollOptionOptions) {
        List<PollOptionDto> pollOptionOptionDtos = new ArrayList<>();
        pollOptionOptions.forEach(pollOption -> pollOptionOptionDtos.add(mapToDto(pollOption)));
        return pollOptionOptionDtos;
    }

    @Override
    public PollOptionDto mapToDto(PollOption pollOption) {
        PollOptionDto pollOptionOptionDto = new PollOptionDto();
        modelMapper.map(pollOption, pollOptionOptionDto);
        return pollOptionOptionDto;
    }

    @Override
    public PollOption mapDtoToObject(PollOptionDto pollOptionOptionDto, PollOption pollOption) {
        modelMapper.map(pollOptionOptionDto, pollOption);
        return pollOption;
    }

    @Override
    public PollOption mapDtoToObject(PollOptionDto pollOptionOptionDto) {
        return mapDtoToObject(pollOptionOptionDto, new PollOption());
    }
}
