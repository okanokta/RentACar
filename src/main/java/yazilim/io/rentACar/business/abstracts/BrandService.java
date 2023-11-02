package yazilim.io.rentACar.business.abstracts;

import java.util.List;

import yazilim.io.rentACar.business.requests.CreateBrandRequest;
import yazilim.io.rentACar.business.requests.UpdateBrandRequest;
import yazilim.io.rentACar.business.responses.GetAllBrandsResponse;
import yazilim.io.rentACar.business.responses.GetByIdResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	GetByIdResponse getById(int id); 
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandResponse);
	void delete(int id);
}
