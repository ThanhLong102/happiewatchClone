package com.example.happiewatch.service;

import com.example.happiewatch.dto.OderDto;
import com.example.happiewatch.entity.OderEntity;

import java.util.Date;
import java.util.List;

public interface IOderService {
    OderDto create(OderDto oderDto);

    OderDto update(OderDto oderDto);

    List<OderEntity> display();

    void delete(String code);

    List<Float> findByDateSuccess(Date form, Date end);

    List<Float> findByDateFall(Date form, Date end);

    List<Integer> getStatisticOrder(Date form, Date end);

    List<OderEntity> getOrderByCustomerId(long customerId);
}
