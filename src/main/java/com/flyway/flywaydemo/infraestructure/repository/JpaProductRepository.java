package com.flyway.flywaydemo.infraestructure.repository;

import com.flyway.flywaydemo.infraestructure.orm.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, Integer> {

}
