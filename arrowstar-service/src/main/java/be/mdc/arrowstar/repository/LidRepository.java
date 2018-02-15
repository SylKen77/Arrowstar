package be.mdc.arrowstar.repository;

import be.mdc.arrowstar.domain.Lid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface LidRepository extends JpaRepository<Lid, Integer> {

	@Query("SELECT l FROM Lid l")
	Stream<Lid> streamAll();

	Stream<Lid> findAllByVerwijderdOpIsNull();

	Stream<Lid> findAllByVerwijderdOpIsNullAndZichtbaarOpHomeScreenIsTrue();


}
