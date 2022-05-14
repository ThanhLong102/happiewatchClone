package com.example.happiewatch.service;

import com.example.happiewatch.converter.MangesConverter;
import com.example.happiewatch.dto.ManagesOder;
import com.example.happiewatch.entity.DetailEntity;
import com.example.happiewatch.entity.ItemEntity;
import com.example.happiewatch.entity.Oder_ItemEntity;
import com.example.happiewatch.repository.DetailRepository;
import com.example.happiewatch.repository.ItemRepository;
import com.example.happiewatch.repository.ManagesRepository;
import com.example.happiewatch.repository.OderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangeService implements IManageService {
    @Autowired
    private MangesConverter mangesConverter;

    @Autowired
    private ManagesRepository managesRepository;

    @Autowired
    private OderRepository oderRepository;

    @Autowired
    private DetailRepository detailRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Oder_ItemEntity> display() {
        return (List<Oder_ItemEntity>) managesRepository.findAll();
    }

    @Override
    public ManagesOder update(ManagesOder managesOder) {
        Oder_ItemEntity oder_item = new Oder_ItemEntity();
        if (managesOder.getId() != null) {
            Oder_ItemEntity oldOder_ItemEntity = managesRepository.findOneById(managesOder.getId());
            oder_item = mangesConverter.toEntity(managesOder, oldOder_ItemEntity);
        } else {
            oder_item = mangesConverter.toEntity(managesOder);
        }
        ItemEntity itemEntity = itemRepository.findOneByName(managesOder.getName());
        DetailEntity newDetail = new DetailEntity();
        for (DetailEntity detail : itemEntity.getListDetails()) {
            if (detail.getMaterial().equals(managesOder.getMaterial())) {
                newDetail = detail;
            }
        }
        if (newDetail.getQuantity() >= managesOder.getQuantity()) {
            newDetail.setQuantity(newDetail.getQuantity() - managesOder.getQuantity());
            oder_item.setDetail(newDetail);
            oder_item.setOder(oderRepository.findOneByCode(managesOder.getCode()));
            oder_item.setItem(itemEntity);
            detailRepository.save(newDetail);
            managesRepository.save(oder_item);
        }
        return managesOder;
    }

}
