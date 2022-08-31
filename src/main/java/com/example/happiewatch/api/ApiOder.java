package com.example.happiewatch.api;

import com.example.happiewatch.api.vm.DashboardVM;
import com.example.happiewatch.dto.OderDto;
import com.example.happiewatch.entity.OderEntity;
import com.example.happiewatch.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oder")
public class ApiOder {
    @Autowired
    private IOderService iOderService;

    @PostMapping(value = "/create")
    public OderDto createNew(@RequestBody OderDto oderDto) {
        return iOderService.create(oderDto);
    }

    @PutMapping(value = "/update")
    public OderDto update(@RequestBody OderDto oderDto) {
        return iOderService.update(oderDto);
    }

    @GetMapping(value = "/show")
    public List<OderEntity> display(){
        return iOderService.display();
    }

    @DeleteMapping(value = "/delete/code={code}")
    public void deleteNew(@PathVariable("code") String code) {
        iOderService.delete(code);
    }

    @PostMapping("/find-By-Date-Success")
    public List<Float> getByDateSuccess(@RequestBody DashboardVM dashboardVM) {
        return iOderService.findByDateSuccess(dashboardVM.getStartDate(),dashboardVM.getEndDate());
    }

    @PostMapping("/find-By-Date-Fall")
    public List<Float> getByDateFall(@RequestBody DashboardVM dashboardVM) {
        return iOderService.findByDateFall(dashboardVM.getStartDate(),dashboardVM.getEndDate());
    }

    @PostMapping("/find-By-Total-Order")
    public List<Integer> getByTotalOrder(@RequestBody DashboardVM dashboardVM) {
        return iOderService.getStatisticOrder(dashboardVM.getStartDate(),dashboardVM.getEndDate());
    }
}
