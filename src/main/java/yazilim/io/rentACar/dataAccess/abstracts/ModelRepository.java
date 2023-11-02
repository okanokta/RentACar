package yazilim.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import yazilim.io.rentACar.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer>{

}
