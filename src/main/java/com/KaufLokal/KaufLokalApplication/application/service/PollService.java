package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.UserDto;
import com.KaufLokal.KaufLokalApplication.application.dto.PollDto;
import com.KaufLokal.KaufLokalApplication.application.dto.PollOptionDto;
import com.KaufLokal.KaufLokalApplication.common.execptions.poll.PollIsEmptyException;
import com.KaufLokal.KaufLokalApplication.common.execptions.poll.PollNotFoundException;
import com.KaufLokal.KaufLokalApplication.common.utils.ObjectUtils;
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
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
public class PollService implements IDefaultService<Poll, PollDto> {

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private PollOptionRepository pollOptionRepository;

    @Autowired
    private UserRepository userRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PollDto> findAll() {
        return Optional.ofNullable(mapToDto(pollRepository.findAll()))
                .orElseThrow(() -> new PollIsEmptyException("Poll is empty"));
    }

    @Override
    public PollDto findById(@NonNull UUID id) {
        return mapToDto(pollRepository.findById(id).orElseThrow(() -> new PollIsEmptyException("Poll by id " + id.toString() + " was not found")));
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
    public void delete(UUID id) {}

    @Override
    public List<PollDto> mapToDto(@NonNull List<Poll> polls) {
        List<PollDto> pollDtos = new ArrayList<>();
        polls.forEach(poll -> pollDtos.add(mapToDto(poll)));
        return pollDtos;
    }

    @Override
    public PollDto mapToDto(@NonNull Poll poll) {
        PollDto pollDto = new PollDto();
        TypeMap<Poll, PollDto> typeWife = modelMapper.createTypeMap(Poll.class, PollDto.class);
        typeWife.addMappings(mapper -> mapper.skip(PollDto::setVotingOptions));
        this.modelMapper.map(poll, pollDto);
        Set<PollOptionDto> pollOptions = new HashSet<>();
        poll.getPollOptions().forEach(pollOption -> {
            PollOptionDto pollOptionDto = new PollOptionDto();
            pollOptionDto.setId(pollOption.getId());
            pollOptionDto.setTitle(pollOption.getTitle());
            pollOptionDto.setTotalAmountVoters(pollOption.getUsers().size());
            Set<UUID> users = new HashSet<>();
            pollOption.getUsers().forEach(user -> users.add(user.getId()));
            pollOptionDto.setUsers(users);
            pollOptions.add(pollOptionDto);
        });
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
    public Poll mapDtoToObject(@NonNull PollDto pollDto, @NonNull Poll poll) {
        this.modelMapper.map(pollDto, poll);
        return poll;
    }

    @Override
    public Poll mapDtoToObject(@NonNull PollDto pollDto) {
        return mapDtoToObject(pollDto, new Poll());
    }

    public PollDto userVotesAnOption(@NonNull UUID pollId, UUID voteOptionId, UserDto userDto) {
        var pollOption = pollOptionRepository.findById(voteOptionId).get();
        var user = userRepository.findById(userDto.getId()).get();
        if (ObjectUtils.isNotNull(pollOption,user)) {
            pollOption.getUsers().add(user);
            pollOptionRepository.save(pollOption);
            return findById(pollId);
        }
        throw new PollNotFoundException("Poll by id " + pollId.toString() + " and vote id " + voteOptionId.toString() + " was not found." );
    }

    public Boolean getUserVoted(@NonNull UUID pollId, @NonNull UUID userId) {
        var pollOptional = pollRepository.findById(pollId);
        if(pollOptional.isPresent())
        {
            var poll = pollOptional.get();
            for (PollOption pollOptions:poll.getPollOptions()) {
                for (User user: pollOptions.getUsers()) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        }
        return false;


    }
}
