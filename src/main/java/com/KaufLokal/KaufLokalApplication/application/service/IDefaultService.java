package com.KaufLokal.KaufLokalApplication.application.service;

import com.KaufLokal.KaufLokalApplication.application.dto.MerchantDto;
import com.KaufLokal.KaufLokalApplication.domain.model.Merchant;

import java.util.List;
import java.util.UUID;

public interface IDefaultService<T,DtoT> {

    List<DtoT> findAll();

    DtoT findById(UUID id) throws Exception;

    DtoT create(DtoT dto);

    DtoT update(DtoT dto);

    void delete(UUID id);

    List<DtoT> mapToDto(List<T> objects);

    DtoT mapToDto(T object);

    T mapDtoToObject(DtoT dto, T object);

    T mapDtoToObject(DtoT dto);
}
