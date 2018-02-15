package be.mdc.arrowstar.repository;

import be.mdc.arrowstar.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.verwijderdOp IS NULL")
	Stream<Product> streamAll();

	Stream<Product> findByZichtbaarIsTrueAndVerwijderdOpIsNull();
}
