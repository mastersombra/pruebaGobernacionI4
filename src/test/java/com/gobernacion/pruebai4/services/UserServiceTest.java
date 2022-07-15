package com.gobernacion.pruebai4.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gobernacion.pruebai4.models.User;
import com.gobernacion.pruebai4.repositories.UserRepository;

public class UserServiceTest {
    
    @Mock
    UserRepository userRepository;

    @Mock
    UserService userServices;

    @InjectMocks
    UserService userService;

    User user;
    User userBad;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);

        user = new User();
        user.setName("Prueba Alejo");
        user.setLastName("Prueba Herrera");
        user.setIdentificationType("CC");
        user.setIdentificationNumber(1234);
        user.setMail("pruebaAlejo@gmail.com");
        user.setCelPhone(456);
        user.setSugar(70.1);
        user.setFat(89);
        user.setOxygen(50);
        user.setStatus(true);
        user.setRisk("Alto");


        userBad = new User();
        userBad.setName("Prueba Alejo");
        userBad.setLastName("Prueba Herrera");
        userBad.setIdentificationType("CC");
        userBad.setIdentificationNumber(1234);
        userBad.setMail("pruebaAlejo@gmail.com");
        userBad.setCelPhone(456);
        userBad.setSugar(200);
        userBad.setFat(200);
        userBad.setOxygen(200);
        userBad.setStatus(true);
    }

    

    @Test
    void testFindByIdentificationTypeAndIdentificationNumber() {
        when(userRepository.findByIdentificationTypeAndIdentificationNumber("CC", 1234)).thenReturn(Arrays.asList(user));
        assertNotNull(userService.findByIdentificationTypeAndIdentificationNumber("CC", 1234));
    }

    @Test
    void testSaveUser() {
        when(userRepository.save(any(User.class))).thenReturn(user);
        assertNotNull(userService.saveUser(new User()));
    }

    @Test
    void testSaveUserRiskGood() {
        when(userRepository.save(any(User.class))).thenReturn(user);
        assertEquals(user.getRisk(), "Alto");
    }

    @Test
    void testSaveUserRiskCalculated() {
        when(userServices.saveUser(userBad)).thenReturn(userBad);
        assertEquals(userService.riskCalculated, "Error");
    }
    
    @Test
    void testFatRiskNotNull() {
        when(userServices.fatRisk(89)).thenReturn((double) 1);
        assertNotNull(userServices.fatRisk((double) 1));
    }

    @Test
    void testFatRisk() {
        when(userServices.fatRisk(89)).thenReturn((double) 1);
        assertEquals(1, userService.fatRisk(89));
    }
    
    @Test
    void testOxygenRiskNotNull() {
        when(userServices.oxygenRisk(50)).thenReturn((double) 1);
        assertNotNull(userServices.oxygenRisk((double) 1));
    }

    @Test
    void testOxygenRisk() {
        when(userServices.oxygenRisk(50)).thenReturn((double) 1);
        assertEquals(1, userServices.oxygenRisk(50));
    }
}
