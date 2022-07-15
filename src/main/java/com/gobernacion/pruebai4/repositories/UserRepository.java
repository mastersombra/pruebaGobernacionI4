package com.gobernacion.pruebai4.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gobernacion.pruebai4.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    public abstract List<User> findByIdentificationTypeAndIdentificationNumber(String identificationType, Integer identificationNumber);
}
