package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.CouponDto;
import com.KaufLokal.KaufLokalApplication.application.dto.UserDto;
import com.KaufLokal.KaufLokalApplication.application.dto.VendorDto;
import com.KaufLokal.KaufLokalApplication.common.execptions.user.UserIsEmptyException;
import com.KaufLokal.KaufLokalApplication.common.execptions.user.UserNotFoundByCouponException;
import com.KaufLokal.KaufLokalApplication.common.execptions.user.UserNotFoundByVendorException;
import com.KaufLokal.KaufLokalApplication.common.execptions.user.UserNotFoundException;
import com.KaufLokal.KaufLokalApplication.common.utils.ObjectUtils;
import com.KaufLokal.KaufLokalApplication.domain.model.User;
import com.KaufLokal.KaufLokalApplication.domain.repository.ExperienceRepository;
import com.KaufLokal.KaufLokalApplication.domain.repository.UserRepository;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements IDefaultService<User, UserDto>{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CouponService couponService;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private ExperienceRepository experienceRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<UserDto> findAll() {
        return Optional.ofNullable(mapToDto(userRepository.findAll()))
                .orElseThrow(() -> new UserIsEmptyException("Users is Empty"));
    }

    @Override
    public UserDto findById(@NonNull UUID id) {
        return mapToDto(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User by Id " + id.toString() +" was not found")));
    }

    @Override
    public UserDto create(@NonNull UserDto dto) {
        return mapToDto(userRepository.save(mapDtoToObject(dto)));
    }

    @Override
    public UserDto update(UserDto dto) {
            var user = userRepository.findById(dto.getId()).get();
            if (ObjectUtils.isNotNull(user)) {
                this.modelMapper.map(dto, user);
                userRepository.save(user);
                return mapToDto(user);
            }
        throw new UserNotFoundException("User by Id " + dto.getId().toString() +" was not found");
    }

    public UserDto addCouponAsFavorites(UUID id, CouponDto couponDto) {
        var user = userRepository.findById(id).get();
        var couponDtoToAdd = couponService.findById(couponDto.getId());
        if (ObjectUtils.isNotNull(user, couponDtoToAdd)) {
            user.getFavoriteCoupons().add(couponService.mapDtoToObject(couponDtoToAdd));
            return update(mapToDto(user));
        }
        throw new UserNotFoundByCouponException("User by id " + id.toString() + "and coupon id " + couponDto.getId().toString() + " was not found");

    }

    public UserDto addVendorAsFavorites(UUID id, VendorDto vendorDto) {
        var user = userRepository.findById(id);
        var vendorDtoToAdd = vendorService.findById(vendorDto.getId());
        if (ObjectUtils.isNotNull(user, vendorDtoToAdd)) {
            user.get().getFavoriteVendors().add(vendorService.mapDtoToObject(vendorDtoToAdd));
            return update(mapToDto(user.get()));
        }
       throw new UserNotFoundByVendorException("User by id " + id.toString() + "and vendor id " + vendorDto.getId().toString() + " was not found");
    }

    public User mapDtoToObject(@NonNull UserDto userDto) {
        return mapDtoToObject(userDto, new User());
    }

    @Override
    public void delete(UUID id) {

    }

    public List<UserDto> mapToDto(@NonNull List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> userDtos.add(mapToDto(user)));
        return userDtos;
    }

    public UserDto mapToDto(@NonNull User user){
        var userDto = new UserDto();
        this.modelMapper.map(user, userDto);
        user.getFavoriteVendors().forEach(vendor -> userDto.getFavoriteVendorsIDs().add(vendor.getId()));
        user.getFavoriteCoupons().forEach(coupon -> userDto.getFavoriteCouponIDs().add(coupon.getId()));
        userDto.setExperiences(experienceRepository.findAllExperienceByUser(user));
        return userDto;
    }

    public User mapDtoToObject(@NonNull UserDto userDto,@NonNull User user) {
        this.modelMapper.map(userDto, user);
        return user;
    }

}
