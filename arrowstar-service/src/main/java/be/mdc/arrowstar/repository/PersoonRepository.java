package be.mdc.arrowstar.repository;

import be.mdc.arrowstar.domain.Persoon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersoonRepository extends JpaRepository<Persoon, Integer> {

}
