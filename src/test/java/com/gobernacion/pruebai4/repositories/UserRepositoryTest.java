package com.gobernacion.pruebai4.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.gobernacion.pruebai4.models.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest {

    @Mock
    UserRepository userRepository;

    User user;

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
    }

    @Test
    void testFindByIdentificationTypeAndIdentificationNumber() {
        when(userRepository.findByIdentificationTypeAndIdentificationNumber("CC", 12345)).thenReturn(Arrays.asList(user));
        assertNotNull(userRepository.findByIdentificationTypeAndIdentificationNumber("CC", 12345));
    }
}
