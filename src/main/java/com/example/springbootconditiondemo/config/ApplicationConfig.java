package com.example.springbootconditiondemo.config;

import com.example.springbootconditiondemo.config.conditions.CarAgeCondition;
import com.example.springbootconditiondemo.dto.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

  @Conditional(CarAgeCondition.class)
  @Bean
  public Car car(@Value("${car.age.min}") Integer min, @Value("${car.age.max}") Integer max) {
    Car car = new Car();
    car.setName("name");
    car.setMaxAge(max);
    car.setMinAge(min);
    return car;
  }

}
