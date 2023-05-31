package com.example.happiewatch.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "oder")
public class OderEntity {

    @Id
    private String code;

    private Date creatDate;

    private Float cost;

    private Long total_product;

    private Boolean isPayed;

    @ManyToOne
    @JoinColumn(name="customer_id",referencedColumnName = "id")
    private CustomerEntity customer;

    @OneToMany(mappedBy = "oder", cascade = CascadeType.ALL)
    private Collection<Oder_ItemEntity> oder_itemEntityCollection;

}
