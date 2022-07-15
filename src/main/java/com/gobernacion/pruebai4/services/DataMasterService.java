package com.gobernacion.pruebai4.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gobernacion.pruebai4.repositories.DataMasterRepository;
import com.gobernacion.pruebai4.models.DataMaster;


@Service
public class DataMasterService {
    
    @Autowired
    DataMasterRepository dataMasterRepository;

    public ArrayList<DataMaster> findByCategory(String category){
        
        ArrayList<DataMaster> arreglo = this.categories(category);
        return arreglo;
        
    }

    public ArrayList<DataMaster> categories(String category){
        
        ArrayList<DataMaster> arreglo = (ArrayList<DataMaster>) dataMasterRepository.findByCategory(category);
        return arreglo; 
    }


    public DataMaster saveDataMaster(DataMaster dataMaster){
        return dataMasterRepository.save(dataMaster);
    }
}
