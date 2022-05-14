package com.example.happiewatch.service;

import com.example.happiewatch.dto.ItemDto;
import com.example.happiewatch.entity.DetailEntity;
import com.example.happiewatch.entity.ItemEntity;
import com.example.happiewatch.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailService implements IDetailsService{

    @Autowired
    private DetailRepository detailRepository;

    @Override
    public DetailEntity update(DetailEntity detailEntity){
        DetailEntity detail =detailRepository.findOneById(detailEntity.getId());
        detail.setImage(detailEntity.getImage());
        detail.setQuantity(detailEntity.getQuantity());
        detail.setPrice(detailEntity.getPrice());
        detail.setMaterial(detailEntity.getMaterial());
        detail.setFeatures(detailEntity.getFeatures());
        return detailRepository.save(detail);
    }

    @Override
    public DetailEntity getItemId(long id){
        DetailEntity detail= detailRepository.findOneById(id);
        return detail;
    }

    @Override
    public void delete(long id) {
        DetailEntity detail=detailRepository.findOneById(id);
        detailRepository.delete(detail);
    }


}
