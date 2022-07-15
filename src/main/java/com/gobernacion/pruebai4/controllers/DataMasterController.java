package com.gobernacion.pruebai4.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gobernacion.pruebai4.models.DataMaster;
import com.gobernacion.pruebai4.services.DataMasterService;

@RestController
@RequestMapping("api/v1/masters")

public class DataMasterController {
    
    @Autowired
    DataMasterService dataMasterService;

    @PostMapping()
    public DataMaster saveDataMaster(@RequestBody DataMaster dataMaster){
        return this.dataMasterService.saveDataMaster(dataMaster);
    }

    @GetMapping("/query")
    public ArrayList<DataMaster> findByCategory(@RequestParam("category") String category){
        return this.dataMasterService.findByCategory(category);
    }
}
