package com.gobernacion.pruebai4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gobernacion.pruebai4.repositories.UserRepository;

import com.gobernacion.pruebai4.models.User;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;
  String riskCalculated = "Error";
  /**
   * Método para buscar a un usuario por número y tipo de identificación
   * @param identificationType Tipo de identificación
   * @param identificationNumber Número de identificación
   * @return
   */
  public List<User> findByIdentificationTypeAndIdentificationNumber(String identificationType,
      Integer identificationNumber) {
    return userRepository.findByIdentificationTypeAndIdentificationNumber(identificationType, identificationNumber);
  }

  /**
   * Método para crear el usuario en la base de datos con sus datos personales y los valores de los 
   * estudios en la sangre
   * @param user Modelo del usuario
   * @return
   */
  public User saveUser(User user) {
    

    double oxygen = oxygenRisk(user.getOxygen());
    double fat = fatRisk(user.getFat());
    RangeSugar sugar = RangeSugar.from(user.getSugar());

    if (oxygen == 1 && fat == 1 && sugar == RangeSugar.Alto) {
      riskCalculated = "Alto";
    } else if (oxygen == 2 && fat == 2 && sugar == RangeSugar.Medio) {
      riskCalculated = "Medio";
    } else if (oxygen == 3 && fat == 3 && sugar == RangeSugar.Bajo) {
      riskCalculated = "Bajo";
    } else if (oxygen == 4 || fat == 4 || sugar == RangeSugar.Error) {
      riskCalculated = "Error";
    } else {
      riskCalculated = "SinRango";
    }

    user.setRisk(riskCalculated);
    switch (riskCalculated) {
      case "Error":
        user.setRisk("Error: El valor debe estar entre 0-100");
        return user;

      case "SinRango":
        user.setRisk("Los valores no se ajustan a ningún rango");
        return user;

      default:
        return userRepository.save(user);
    }
  }

  /**
   * Clase para calcular a que nivel corresponde según el estudio de azúcar
   */
  public enum RangeSugar {

    Alto(70.1, 100),
    Medio(50, 70),
    Bajo(0, 49.9),
    Error(-2, -1);

    private final double minValue;
    private final double maxValue;

    private RangeSugar(double min, double max) {
      this.minValue = min;
      this.maxValue = max;
    }

    /**
     * Método que recibe el valor del azúcar en la sangre
     * @param score
     * @return
     */
    public static RangeSugar from(double score) {
      return Arrays.stream(RangeSugar.values())
          .filter(range -> score >= range.minValue && score <= range.maxValue)
          .findAny()
          .orElse(Error);
    }
  }

  /**
   * Método para calcular el nivel al que corresponde según el valor de oxigeno en la sangre
   * @param number valor de oxigeno en la sangre
   * @return
   */
  public double oxygenRisk(double number) {

    int num = (number >= 0) && (number < 60) ? 1 : 4;
    num = (number >= 60) && (number <= 70) ? 2 : num;
    num = (number > 60) && (number <= 100) ? 3 : num;

    return num;
  }

  /**
   * Método para calcular el nivel al que corresponde según el valor de grasa en la sangre
   * @param number valor de grasa en la sangre
   * @return
   */
  public double fatRisk(double number) {

    // switch (true) {
    //   case (number > 88.5 && number <= 100):
    //     number = 1;
    //     break;

    //   case (number >= 62.2 && number <= 88.5):
    //     number = 2;
    //     break;

    //   case (number < 62.2 && number >= 0):
    //     number = 3;
    //     break;

    //   default:
    //     number = 4;
    //     break;
    // }

    
    if (number > 88.5 && number <= 100) {
      number = 1;
    } else if (number >= 62.2 && number <= 88.5) {
      number = 2;
    } else if (number < 62.2 && number >= 0) {
      number = 3;
    } else {
      number = 4;
    }

    return number;
  }
}
