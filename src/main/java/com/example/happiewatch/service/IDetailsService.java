package com.example.happiewatch.service;

import com.example.happiewatch.entity.DetailEntity;

import java.util.List;

public interface IDetailsService {
    DetailEntity update(DetailEntity detailEntity);

    DetailEntity getItemId(long id);

    void delete(long id);

    List<DetailEntity> getAll();
}
