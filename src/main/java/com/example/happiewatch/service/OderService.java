package com.example.happiewatch.service;

import com.example.happiewatch.dto.OderDto;
import com.example.happiewatch.entity.*;
import com.example.happiewatch.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OderService implements IOderService {

    @Autowired
    private OderRepository oderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DetailRepository detailRepository;

    @Override
    public OderDto create(OderDto oderDto) {
        OderEntity oderEntity = new OderEntity();
        CustomerEntity customer = customerRepository.findOneById(oderDto.getCustomerId());
        oderEntity.setCode(oderDto.getCode());
        oderEntity.setCost(oderDto.getCost());
        oderEntity.setTotal_product(oderDto.getTotal_product());
        oderEntity.setIsPayed(oderDto.getIsPayed());
        oderEntity.setCustomer(customer);
        oderEntity.setIsPayed(false);
        oderRepository.save(oderEntity);
        return oderDto;
    }

    @Override
    public OderDto update(OderDto oderDto) {
        OderEntity oderEntity = new OderEntity();
        CustomerEntity customer = customerRepository.findOneById(oderDto.getCustomerId());
        oderEntity.setCode(oderDto.getCode());
        oderEntity.setCost(oderDto.getCost());
        oderEntity.setTotal_product(oderDto.getTotal_product());
        oderEntity.setIsPayed(oderDto.getIsPayed());
        oderEntity.setCustomer(customer);
        oderEntity.setIsPayed(true);
        oderRepository.save(oderEntity);
        return oderDto;
    }


    @Override
    public List<OderEntity> display() {
        List<OderEntity> oderEntities = (List<OderEntity>) oderRepository.findAll();
        List<OderEntity> oderEntitieIsPayed = new ArrayList<>();
        for (OderEntity o : oderEntities) {
            if (!o.getIsPayed()) {
                oderEntitieIsPayed.add(o);
            }
        }
        return oderEntitieIsPayed;
    }


    @Override
    public void delete(String code) {
        OderEntity newEntity = oderRepository.findOneByCode(code);
        for (Oder_ItemEntity oder_item : newEntity.getOder_itemEntityCollection()) {
            DetailEntity detail = oder_item.getDetail();
            detail.setQuantity(detail.getQuantity() + oder_item.getQuantity());
            detailRepository.save(detail);
        }
        oderRepository.delete(newEntity);
    }
}
