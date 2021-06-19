package com.example.springbootconditiondemo;

import com.example.springbootconditiondemo.config.ApplicationConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

@SpringBootTest
class SpringbootConditionDemoApplicationTests {

  @Test
  public void testPropertyWhenIsValidRange() {
    ApplicationContextRunner context = new ApplicationContextRunner()
        .withPropertyValues("car.age.min=5")
        .withPropertyValues("car.age.max=50")
        .withUserConfiguration(ApplicationConfig.class);

    context.run(it -> Assertions.assertTrue(it.containsBean("car")));
  }

  @Test
  public void testPropertyWhenIsNotValidRange() {
    ApplicationContextRunner context = new ApplicationContextRunner()
        .withPropertyValues("car.age.min=-5")
        .withPropertyValues("car.age.max=5000000")
        .withUserConfiguration(ApplicationConfig.class);

    context.run(it -> Assertions.assertFalse(it.containsBean("car")));
  }

}
