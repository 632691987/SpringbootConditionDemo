package com.example.springbootconditiondemo;

import com.example.springbootconditiondemo.dto.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ApplicationRunner implements CommandLineRunner {

  @Autowired
  private ApplicationContext appContext;


  /**
   * CarAgeCondition.java
   * ApplicationConfig.java
   * Property: car.age.min / car.age.max
   */
  @Override
  public void run(String... args) throws Exception {
    String[] names = appContext.getBeanNamesForType(Car.class);
    if (names.length == 0) {
      log.info("There is no such car bean, property car.age.min/car.age.max not correct");
    } else {
      log.info("Yes there are such car bean");
    }
  }
}
