package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.UserDto;
import com.KaufLokal.KaufLokalApplication.application.dto.VotingDto;
import com.KaufLokal.KaufLokalApplication.application.dto.VotingOptionDto;
import com.KaufLokal.KaufLokalApplication.domain.model.User;
import com.KaufLokal.KaufLokalApplication.domain.model.Voting;
import com.KaufLokal.KaufLokalApplication.domain.model.VotingOption;
import com.KaufLokal.KaufLokalApplication.domain.repository.UserRepository;
import com.KaufLokal.KaufLokalApplication.domain.repository.VotingOptionRepository;
import com.KaufLokal.KaufLokalApplication.domain.repository.VotingRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VotingService implements IDefaultService<Voting, VotingDto> {

    @Autowired
    private VotingRepository votingRepository;

    @Autowired
    VotingOptionRepository votingOptionRepository;

    @Autowired
    private VotingOptionService votingOptionService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<VotingDto> findAll() {
        votingRepository.findAll();
        return mapToDto(votingRepository.findAll());
    }

    @Override
    public VotingDto findById(UUID id) {
        Optional<Voting> votingOptional = votingRepository.findById(id);
        if (votingOptional.isPresent())
        {
            return mapToDto(votingOptional.get());
        }
        return null;
    }

    @Override
    public VotingDto create(VotingDto dto) {
        return null;
    }

    @Override
    public VotingDto update(VotingDto dto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<VotingDto> mapToDto(List<Voting> votings) {
        List<VotingDto> votingDtos = new ArrayList<>();
        for (Voting voting : votings) {
            votingDtos.add(mapToDto(voting));
        }
        return votingDtos;
    }

    @Override
    public VotingDto mapToDto(Voting voting) {
        ModelMapper modelMapper = new ModelMapper();
        VotingDto votingDto = new VotingDto();

        TypeMap<Voting, VotingDto> typeWife = modelMapper.createTypeMap(Voting.class, VotingDto.class);
        typeWife.addMappings(mapper -> mapper.skip(VotingDto::setVotingOptions));
        modelMapper.map(voting, votingDto);
        Set<VotingOptionDto> votingOptions = new HashSet<>();
        for (VotingOption votingOption: voting.getVotingOptions()) {

            VotingOptionDto votingOptionDto = new VotingOptionDto();
            votingOptionDto.setId(votingOption.getId());
            votingOptionDto.setTitle(votingOption.getTitle());
            votingOptionDto.setTotalAmountVoters(votingOption.getUsers().size());

            Set<UUID> userUUID = new HashSet<>();
            for (User user: votingOption.getUsers())
            {
                userUUID.add(user.getId());
            }
            votingOptionDto.setUsers(userUUID);
            votingOptions.add(votingOptionDto);
        }

        votingDto.setVotingOptions(votingOptions);

        int totalAmountVoters = 0;
        for (VotingOptionDto votingOptionDto : votingDto.getVotingOptions()) {
           totalAmountVoters = totalAmountVoters + votingOptionDto.getTotalAmountVoters();
        }

        votingDto.setTotalAmountVoters(totalAmountVoters);
        return votingDto;
    }

    @Override
    public Voting mapDtoToObject(VotingDto votingDto, Voting voting) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(votingDto, voting);
        return voting;
    }

    @Override
    public Voting mapDtoToObject(VotingDto votingDto) {
        return mapDtoToObject(votingDto, new Voting());
    }

    public VotingDto userVotesAnOption(UUID voteId, UUID voteOptionId, UserDto userDto) {

        Optional<VotingOption> votingOption = votingOptionRepository.findById(voteOptionId);
        if (votingOption.isPresent())
        {
            Optional<User> user = userRepository.findById(userDto.getId());
            if(user.isPresent())
            {
                votingOption.get().getUsers().add(user.get());
                votingOptionRepository.save(votingOption.get());

                return findById(voteId);
            }
            else
            {
                //todo Exception
            }
        }
        return null;
    }

    public VotingDto removeUserVote(UUID voteId,UUID voteOptionId, UserDto userDto) {
        Optional<VotingOption> votingOption = votingOptionRepository.findById(voteOptionId);
        if (votingOption.isPresent())
        {
            Optional<User> user = userRepository.findById(userDto.getId());
            if(user.isPresent())
            {
                for (User userItem: votingOption.get().getUsers()) {
                    if(userDto.getId() == userItem.getId())
                    {
                        votingOption.get().getUsers().remove(userItem);
                        votingOptionRepository.save(votingOption.get());
                        break;
                    }
                }
                return null;
            }
            else
            {
                //todo Exception
            }
        }
        return null;
    }
}
