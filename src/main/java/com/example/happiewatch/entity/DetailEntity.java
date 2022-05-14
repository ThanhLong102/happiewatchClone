package com.example.happiewatch.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "detail")
public class DetailEntity {

    @Id
    private Long id;

    private String material;

    private String image;

    private String features;

    private Long quantity;

    private Float price;

    @OneToMany(mappedBy = "detail", cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Oder_ItemEntity> oder_itemEntityCollection;
}