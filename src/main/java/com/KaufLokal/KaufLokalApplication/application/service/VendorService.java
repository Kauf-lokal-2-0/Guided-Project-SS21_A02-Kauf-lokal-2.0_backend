package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.*;
import com.KaufLokal.KaufLokalApplication.common.execptions.vendor.VendorIsEmptyException;
import com.KaufLokal.KaufLokalApplication.common.execptions.vendor.VendorNotFoundException;
import com.KaufLokal.KaufLokalApplication.common.utils.ObjectUtils;
import com.KaufLokal.KaufLokalApplication.domain.model.*;
import com.KaufLokal.KaufLokalApplication.domain.model.enums.EventTypes;
import com.KaufLokal.KaufLokalApplication.domain.model.enums.VendorCategory;
import com.KaufLokal.KaufLokalApplication.domain.repository.VendorRepository;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class VendorService implements IDefaultService<Vendor, VendorDto> {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private CouponService couponService;

    @Autowired
    private EventService eventService;

    @Autowired
    private MessageService messageService;

    private final EventDto eventDto = new EventDto();
    private final ModelMapper modelMapper = new ModelMapper();
    private static final Logger logger = LoggerFactory.getLogger(VendorService.class);

    public List<VendorDto> findAll() {
        return Optional.ofNullable(mapToDto(vendorRepository.findAll()))
                .orElseThrow(() -> new VendorIsEmptyException("Vendors are empty"));
    }

    public VendorDto findById(@NonNull UUID id) {
        return mapToDto(vendorRepository.findById(id)
                .orElseThrow(() -> new VendorNotFoundException("Vendor by id: " + id.toString() + "was not found")));
    }

    public VendorDto create(@NonNull VendorDto vendorDto) {
        return mapToDto(vendorRepository.save(mapDtoToObject(vendorDto)));
    }

    public VendorDto update(VendorDto vendorDto) {
        var vendor = vendorRepository.findById(vendorDto.getId()).get();
        if (ObjectUtils.isNotNull(vendor)) {
            this.modelMapper.map(vendorDto, vendor);
            vendorRepository.save(vendor);
            return mapToDto(vendor);
        }
        throw new VendorNotFoundException("Vendor by id: " + vendor.getId().toString() + "was not found");
    }

    public void delete(@NonNull UUID id) {
        vendorRepository.delete(vendorRepository.findById(id)
                .orElseThrow(() -> new VendorNotFoundException("Vendor by id: " + id.toString() + "was not found")));
    }

    public VendorDto addCoupon(UUID vendorId, @NonNull CouponDto couponDto) {
        var vendor = vendorRepository.findById(vendorId).get();
        if (ObjectUtils.isNotNull(vendor)) {
            var coupon = couponService.mapDtoToObject(couponService.create(couponDto));
            vendor.getCoupons().add(coupon);
            vendorRepository.save(vendor);
            eventDto.setEventTypes(EventTypes.COUPON);
            eventDto.setRefId(coupon.getId());
            eventDto.setVendorId(vendorId);
            eventService.create(eventDto);
            return mapToDto(vendor);
        }
       throw new VendorNotFoundException("Vendor by id: " + vendorId.toString() + " and coupon id" + couponDto.getId() + " was not found");
    }


    public VendorDto addMessage(UUID vendorId, @NonNull MessageDto messageDto) {
        var vendor = vendorRepository.findById(vendorId).get();
        if (ObjectUtils.isNotNull(vendor)) {
            var message = messageService.mapDtoToObject(messageService.create(messageDto));
            vendor.getMessages().add(message);
            vendorRepository.save(vendor);
            eventDto.setEventTypes(EventTypes.MESSAGE);
            eventDto.setRefId(message.getId());
            eventDto.setVendorId(vendorId);
            eventService.create(eventDto);
            return mapToDto(vendor);
        }
        throw new VendorNotFoundException("Vendor by id " + vendorId.toString() + " and massage id" + messageDto.getId().toString() + " was not found");
    }

    public List<VendorDto> mapToDto(@NonNull List<Vendor> vendors) {
        List<VendorDto> vendorDtos = new ArrayList<>();
        vendors.forEach(vendor -> vendorDtos.add(mapToDto(vendor)));
        return vendorDtos;
    }

    public VendorDto mapToDto(@NonNull Vendor vendor){
        var vendorDto = new VendorDto();
        modelMapper.map(vendor, vendorDto);
            try {
                if(ObjectUtils.isNotNull(vendorDto.getOpeningTime())) {
                    vendorDto.getOpeningTime().setIsOpen(isOpen(vendorDto.getOpeningTime()));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }catch (VendorNotFoundException e){
                logger.debug(e.getMessage());
            }
        vendorDto.setVendorScore(getArithmeticMeanRating(vendor.getRatings()));
        return vendorDto;
    }

    public Vendor mapDtoToObject(@NonNull VendorDto vendorDto, @NonNull Vendor vendor) {
        modelMapper.map(vendorDto, vendor);
        return vendor;
    }

    public Vendor mapDtoToObject(@NonNull VendorDto vendorDto) {
        return mapDtoToObject(vendorDto, new Vendor());
    }

    public List<VendorCategoryDto> getCategories() {
        List<VendorCategoryDto> vendorCategoriesDto = new ArrayList<>();
        Arrays.stream(VendorCategory.values()).forEach(vendorCategory -> {
            var vendorCategoryDto = new VendorCategoryDto();
            vendorCategoryDto.setVendorCategory(vendorCategory);
            vendorCategoriesDto.add(vendorCategoryDto);
        });
        return vendorCategoriesDto;
    }


     private boolean isOpen(@NonNull OpeningTime openingTime) throws ParseException {
         var calendar = Calendar.getInstance();
         calendar.setTime(new Date());
         String actualOpeningTime = "";
         switch (calendar.get(Calendar.DAY_OF_WEEK)){
             case Calendar.MONDAY:
                 actualOpeningTime = openingTime.getMonday();
                 break;
             case Calendar.TUESDAY:
                 actualOpeningTime = openingTime.getTuesday();
                 break;
             case Calendar.WEDNESDAY:
                 actualOpeningTime = openingTime.getWednesday();
                 break;
             case Calendar.THURSDAY:
                 actualOpeningTime = openingTime.getThursday();
                 break;
             case Calendar.FRIDAY:
                 actualOpeningTime = openingTime.getFriday();
                 break;
             case Calendar.SATURDAY:
                 actualOpeningTime = openingTime.getSaturday();
                 break;
             case Calendar.SUNDAY:
                 actualOpeningTime = openingTime.getSunday();
                 break;
             default:
                return false;
         }

         if(actualOpeningTime.equalsIgnoreCase("Closed")) {
            return false;
         }

         String[] times = actualOpeningTime.split("-");
         if(times.length == 2) {
             String openTime = times[0];
             String closeTime = times[1];
             var openTimeDate = new SimpleDateFormat("HH:mm").parse(openTime);
             var closeTimeDate = new SimpleDateFormat("HH:mm").parse(closeTime);
             var currentTime = Calendar.getInstance();
             currentTime.set(1970,0,1);
             var currentTimeDate = currentTime.getTime();
             return currentTimeDate.after(openTimeDate) && currentTimeDate.before(closeTimeDate);
         }
         return false;
     }

    private double getArithmeticMeanRating(@NonNull Set<Rating> ratings) {
        return ratings.stream().mapToDouble(Rating::getRatingScore).average().orElse(0.0);
    }
}
