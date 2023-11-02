package yazilim.io.rentACar.business.rules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yazilim.io.rentACar.core.utilities.exceptions.BusinessException;
import yazilim.io.rentACar.dataAccess.abstracts.BrandRepository;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
	private BrandRepository brandRepository;
	
	public void checkIfBrandNameExists(String name) {
		if(this.brandRepository.existsByName(name)) {
			throw new BusinessException("Brand name Already exists"); // java exceptions types
		}
	}
}
