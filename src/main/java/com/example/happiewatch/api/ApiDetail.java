package com.example.happiewatch.api;

import com.example.happiewatch.entity.DetailEntity;
import com.example.happiewatch.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detail")
public class ApiDetail {
    @Autowired
    private DetailService detailService;

    @GetMapping
    public List<DetailEntity> getAll() {
        return detailService.getAll();
    }

    @PostMapping(value = "/update")
    public DetailEntity createNew(@RequestBody DetailEntity detail) {
        return detailService.update(detail);
    }

    @GetMapping(value = "/search/id={id}")
    public DetailEntity getWatchById(@PathVariable("id")long id){
        return detailService.getItemId(id);
    }

    @DeleteMapping(value = "/delete/id={id}")
    public void deleteNew(@PathVariable("id") long id) {
        detailService.delete(id);
    }
}
