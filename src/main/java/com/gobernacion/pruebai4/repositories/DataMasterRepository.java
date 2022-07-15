package com.gobernacion.pruebai4.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.gobernacion.pruebai4.models.DataMaster;

@Repository
public interface DataMasterRepository extends CrudRepository<DataMaster, Integer>{
    public abstract ArrayList<DataMaster> findByCategory(String category);
}
