package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.*;
import com.KaufLokal.KaufLokalApplication.domain.model.Coupon;
import com.KaufLokal.KaufLokalApplication.domain.model.Message;
import com.KaufLokal.KaufLokalApplication.domain.model.OpeningTime;
import com.KaufLokal.KaufLokalApplication.domain.model.enums.EventTypes;
import com.KaufLokal.KaufLokalApplication.domain.model.Vendor;
import com.KaufLokal.KaufLokalApplication.domain.model.enums.VendorCategory;
import com.KaufLokal.KaufLokalApplication.domain.repository.VendorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class VendorService implements IDefaultService<Vendor, VendorDto> {

    @Autowired
    VendorRepository vendorRepository;

    @Autowired
    CouponService couponService;

    @Autowired
    EventService eventService;

    @Autowired
    MessageService messageService;

    public List<VendorDto> findAll() {
        vendorRepository.findAll();
        return mapToDto(vendorRepository.findAll());
    }

    public VendorDto findById(UUID id)  {
        Optional<Vendor> vendorOptional = vendorRepository.findById(id);
        if (vendorOptional.isPresent())
        {
            return mapToDto(vendorOptional.get());
        }
        return null;
    }

    public VendorDto create(VendorDto vendorDto) {

        return mapToDto(vendorRepository.save(mapDtoToObject(vendorDto)));
    }

    public VendorDto update(VendorDto vendorDto) {

        Optional<Vendor> vendorOptional = vendorRepository.findById(vendorDto.getId());
        if (vendorOptional.isPresent())
        {
            Vendor vendor = vendorOptional.get();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(vendorDto, vendor);
            vendorRepository.save(vendor);
            return mapToDto(vendor);
        }
        return vendorDto;
    }

    public void delete(UUID id) {
        Optional<Vendor> vendorOptional = vendorRepository.findById(id);
        if (vendorOptional.isPresent()) {
            Vendor vendor = vendorOptional.get();
            vendorRepository.delete(vendor);
        }
    }

    public VendorDto addCoupon(UUID vendorId, CouponDto couponDto)
    {
        Optional<Vendor> vendorOptional = vendorRepository.findById(vendorId);
        if (vendorOptional.isPresent())
        {

            Coupon coupon = couponService.mapDtoToObject(couponService.create(couponDto));
            vendorOptional.get().getCoupons().add(coupon);
            vendorRepository.save(vendorOptional.get());

            EventDto eventDto = new EventDto();
            eventDto.setEventTypes(EventTypes.COUPON);
            eventDto.setCreated(new Date());
            eventDto.setRefId(coupon.getId());
            eventDto.setVendorId(vendorId);
            eventService.create(eventDto);

            return mapToDto(vendorOptional.get());
        }
        else
        {
            //TODO throw Exception.
            return null;
        }
    }


    public VendorDto addMessage(UUID vendorId, MessageDto messageDto)
    {
        Optional<Vendor> vendorOptional = vendorRepository.findById(vendorId);
        if (vendorOptional.isPresent())
        {
            Message message = messageService.mapDtoToObject(messageService.create(messageDto));
            vendorOptional.get().getMessages().add(message);
            vendorRepository.save(vendorOptional.get());

            EventDto eventDto = new EventDto();
            eventDto.setEventTypes(EventTypes.MESSAGE);
            eventDto.setCreated(new Date());
            eventDto.setRefId(message.getId());
            eventDto.setVendorId(vendorId);
            eventService.create(eventDto);

            return mapToDto(vendorOptional.get());
        }
        else
        {
            //TODO throw Exception.
            return null;
        }
    }

    public List<VendorDto> mapToDto(List<Vendor> vendors) {
        List<VendorDto> vendorDtos = new ArrayList<>();
        for (Vendor vendor : vendors) {
            vendorDtos.add(mapToDto(vendor));
        }
        return vendorDtos;
    }

    public VendorDto mapToDto(Vendor vendor){
        ModelMapper modelMapper = new ModelMapper();
        VendorDto vendorDto = new VendorDto();
        modelMapper.map(vendor, vendorDto);

        if(vendorDto.getOpeningTime() != null)
        {
            try {
                vendorDto.getOpeningTime().setIsOpen(isOpen(vendorDto.getOpeningTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }



        return vendorDto;
    }

    public Vendor mapDtoToObject(VendorDto vendorDto, Vendor vendor) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(vendorDto, vendor);
        return vendor;
    }

    public Vendor mapDtoToObject(VendorDto vendorDto) {
        return mapDtoToObject(vendorDto, new Vendor());
    }

    public List<VendorCategoryDto> getCategories()
    {
        List<VendorCategoryDto> vendorCategoriesDto = new ArrayList<>();
        for (VendorCategory vendorCategory : VendorCategory.values()) {
            VendorCategoryDto vendorCategoryDto = new VendorCategoryDto();
            vendorCategoryDto.setVendorCategory(vendorCategory);
            vendorCategoriesDto.add(vendorCategoryDto);
        }
        return vendorCategoriesDto;
    }


     private boolean isOpen(OpeningTime openingTime) throws ParseException {

         Calendar calendar = Calendar.getInstance();
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

         if(actualOpeningTime.equalsIgnoreCase("Closed"))
         {
            return false;
         }

         String[] times = actualOpeningTime.split("-");
         if(times.length == 2)
         {
             String openTime = times[0];
             String closeTime = times[1];
             Date openTimeDate = new SimpleDateFormat("HH:mm").parse(openTime);
             Date closeTimeDate = new SimpleDateFormat("HH:mm").parse(closeTime);
             Calendar currentTime = Calendar.getInstance();
             currentTime.set(1970,0,1);
             Date currentTimeDate = currentTime.getTime();

             return currentTimeDate.after(openTimeDate) && currentTimeDate.before(closeTimeDate);
         }
         return false;
     }
}
