package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.UserDto;
import com.KaufLokal.KaufLokalApplication.application.dto.PollDto;
import com.KaufLokal.KaufLokalApplication.application.dto.PollOptionDto;
import com.KaufLokal.KaufLokalApplication.domain.model.User;
import com.KaufLokal.KaufLokalApplication.domain.model.Poll;
import com.KaufLokal.KaufLokalApplication.domain.model.PollOption;
import com.KaufLokal.KaufLokalApplication.domain.repository.UserRepository;
import com.KaufLokal.KaufLokalApplication.domain.repository.PollOptionRepository;
import com.KaufLokal.KaufLokalApplication.domain.repository.PollRepository;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PollService implements IDefaultService<Poll, PollDto> {

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    PollOptionRepository pollOptionRepository;

    @Autowired
    private PollOptionService pollOptionService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<PollDto> findAll() {
        pollRepository.findAll();
        return mapToDto(pollRepository.findAll());
    }

    @Override
    public PollDto findById(UUID id) {
        Optional<Poll> pollOptional = pollRepository.findById(id);
        if (pollOptional.isPresent())
        {
            return mapToDto(pollOptional.get());
        }
        return null;
    }

    @Override
    public PollDto create(PollDto dto) {
        return null;
    }

    @Override
    public PollDto update(PollDto dto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<PollDto> mapToDto(List<Poll> polls) {
        List<PollDto> pollDtos = new ArrayList<>();
        for (Poll poll : polls) {
            pollDtos.add(mapToDto(poll));
        }
        return pollDtos;
    }

    @Override
    public PollDto mapToDto(Poll poll) {
        ModelMapper modelMapper = new ModelMapper();
        PollDto pollDto = new PollDto();

        TypeMap<Poll, PollDto> typeWife = modelMapper.createTypeMap(Poll.class, PollDto.class);
        typeWife.addMappings(mapper -> mapper.skip(PollDto::setVotingOptions));
        modelMapper.map(poll, pollDto);
        Set<PollOptionDto> pollOptions = new HashSet<>();
        for (PollOption pollOption : poll.getPollOptions()) {

            PollOptionDto pollOptionDto = new PollOptionDto();
            pollOptionDto.setId(pollOption.getId());
            pollOptionDto.setTitle(pollOption.getTitle());
            pollOptionDto.setTotalAmountVoters(pollOption.getUsers().size());

            Set<UUID> userUUID = new HashSet<>();
            for (User user: pollOption.getUsers())
            {
                userUUID.add(user.getId());
            }
            pollOptionDto.setUsers(userUUID);
            pollOptions.add(pollOptionDto);
        }

        pollDto.setVotingOptions(pollOptions);

        int totalAmountVoters = 0;
        for (PollOptionDto pollOptionDto : pollDto.getVotingOptions()) {
           totalAmountVoters = totalAmountVoters + pollOptionDto.getTotalAmountVoters();
        }

        pollDto.setTotalAmountVoters(totalAmountVoters);
        pollDto.setVendorId(poll.getVendor().getId());
        return pollDto;
    }

    @Override
    public Poll mapDtoToObject(PollDto pollDto, Poll poll) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(pollDto, poll);
        return poll;
    }

    @Override
    public Poll mapDtoToObject(PollDto pollDto) {
        return mapDtoToObject(pollDto, new Poll());
    }

    public PollDto userVotesAnOption(UUID pollId, UUID voteOptionId, UserDto userDto) {

        Optional<PollOption> pollOption = pollOptionRepository.findById(voteOptionId);
        if (pollOption.isPresent())
        {
            Optional<User> user = userRepository.findById(userDto.getId());
            if(user.isPresent())
            {
                pollOption.get().getUsers().add(user.get());
                pollOptionRepository.save(pollOption.get());

                return findById(pollId);
            }
            else
            {
                //todo Exception
            }
        }
        return null;
    }

    public PollDto removeUserPoll(UUID pollId, UUID voteOptionId, UserDto userDto) {
        Optional<PollOption> pollOption = pollOptionRepository.findById(voteOptionId);
        if (pollOption.isPresent())
        {
            Optional<User> user = userRepository.findById(userDto.getId());
            if(user.isPresent())
            {
                for (User userItem: pollOption.get().getUsers()) {
                    if(userDto.getId() == userItem.getId())
                    {
                        pollOption.get().getUsers().remove(userItem);
                        pollOptionRepository.save(pollOption.get());
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

    public Boolean getUserVoted(@NonNull UUID pollId, @NonNull UUID userId) {
        var pollOptional = pollRepository.findById(pollId);
        if(pollOptional.isPresent())
        {
            var poll = pollOptional.get();
            for (PollOption pollOptions:poll.getPollOptions()) {
                for (User user: pollOptions.getUsers()) {
                    if(user.getId().equals(userId)){
                        return Boolean.TRUE;
                    }
                }
            }
            return Boolean.FALSE;
        }
        return false;
    }

}
