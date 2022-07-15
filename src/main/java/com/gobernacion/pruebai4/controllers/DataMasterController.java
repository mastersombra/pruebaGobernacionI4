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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/v1/masters")

public class DataMasterController {
    
    @Autowired
    DataMasterService dataMasterService;

    @Operation(summary = "--EN PROCESO DE IMPLEMENTACIÓN -- Servicio para guardar en el maestro los valores fijos que determinan el riesgo")
    @PostMapping()
    public DataMaster saveDataMaster(@RequestBody DataMaster dataMaster){
        return this.dataMasterService.saveDataMaster(dataMaster);
    }

    @Operation(summary = "--EN PROCESO DE IMPLEMENTACIÓN -- Servicio para obtener los valores según la categoria oxigeno, azucar, grasa")
    @GetMapping("/query")
    public ArrayList<DataMaster> findByCategory(@RequestParam("category") String category){
        return this.dataMasterService.findByCategory(category);
    }
}
