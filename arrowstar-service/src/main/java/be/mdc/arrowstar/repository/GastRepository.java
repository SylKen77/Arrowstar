package be.mdc.arrowstar.repository;

import be.mdc.arrowstar.domain.Gast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface GastRepository extends JpaRepository<Gast, Integer> {

	@Query("select g from Gast g")
	Stream<Gast> streamAll();

	Stream<Gast> findAllByAfgerekendIsFalse();

}
