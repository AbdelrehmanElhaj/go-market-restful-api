package dev.hdrelhaj.go_market;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.hdrelhaj.go_market.employee.Employee;
import dev.hdrelhaj.go_market.employee.EmployeeRepository;
import dev.hdrelhaj.go_market.product.Product;
import dev.hdrelhaj.go_market.product.ProductRepository;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(EmployeeRepository employeeRepository, ProductRepository productRepository) {

    return args -> {
      log.info("Preloading " + employeeRepository.save(new Employee("Bilbo Baggins", "burglar")));
      log.info("Preloading " + employeeRepository.save(new Employee("Frodo Baggins", "thief")));

      log.info("Preloading " + productRepository.save(
          Product.builder()
              .name("Macbook Pro")
              .price(2000.0)
              .quantity(10)
              .build()));
      log.info("Preloading " + productRepository.save(
          Product.builder()
              .name("Macbook Air")
              .price(1500.0)
              .quantity(10)
              .build()));
    };
  }
}