package yazilim.io.rentACar.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import yazilim.io.rentACar.entities.concretes.Brand;


public interface BrandRepository extends JpaRepository<Brand,Integer>{
	boolean existsByName(String name); // Spring jpa keywords'lere bak !!!
}
