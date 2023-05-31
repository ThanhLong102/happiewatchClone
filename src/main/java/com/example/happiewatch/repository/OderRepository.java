package com.example.happiewatch.repository;

import com.example.happiewatch.entity.OderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OderRepository extends PagingAndSortingRepository<OderEntity,Long> {

    OderEntity findOneByCode(String code);

    @Query(value = "select u from OderEntity u where u.creatDate between :dateFrom and :dateEnd")
    List<OderEntity> findByDate(@Param("dateFrom") Date dateFrom, @Param("dateEnd") Date dateEnd);

    @Query(value = "select u from OderEntity u where u.customer.id = :customerId ")
    List<OderEntity> findByCustomer(@Param("customerId") long customerId);
}
