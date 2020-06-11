package com.flyway.flywaydemo;

import com.flyway.flywaydemo.infraestructure.orm.Product;
import com.flyway.flywaydemo.infraestructure.repository.JpaProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FlywayTests {

	@Autowired
	JpaProductRepository productRepository;

	@Test
	void creates_database_tables_using_migrations() {
		Product product = Product.builder()
				.name("Test Product")
				.build();

		Product insertedProduct = productRepository.save(product);
		Product selectProduct = productRepository.findById(insertedProduct.getId())
				.orElse(null);

		assertThat(product.getName(), is(selectProduct.getName()));

	}

}
