package com.example.happiewatch.service;

import com.example.happiewatch.entity.DetailEntity;

public interface IDetailsService {
    DetailEntity update(DetailEntity detailEntity);

    DetailEntity getItemId(long id);

    void delete(long id);
}
