package yazilim.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yazilim.io.rentACar.business.abstracts.BrandService;
import yazilim.io.rentACar.business.requests.CreateBrandRequest;
import yazilim.io.rentACar.business.requests.UpdateBrandRequest;
import yazilim.io.rentACar.business.responses.GetAllBrandsResponse;
import yazilim.io.rentACar.business.responses.GetByIdResponse;
import yazilim.io.rentACar.business.rules.BrandBusinessRules;
import yazilim.io.rentACar.core.utilities.mappers.ModelMapperService;
import yazilim.io.rentACar.dataAccess.abstracts.BrandRepository;
import yazilim.io.rentACar.entities.concretes.Brand;

@Service  // Bu Sınıf Bir Business Nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService{
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;

	@Override
	public List<GetAllBrandsResponse> getAll() {
		// İŞ kuralları
		List<Brand> brands = brandRepository.findAll();
		/*
		 * List<GetAllBrandsResponse> brandResponse = new
		 * ArrayList<GetAllBrandsResponse>(); for(Brand brand:brands) {
		 * GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
		 * responseItem.setId(brand.getId()); responseItem.setName(brand.getName());
		 * brandResponse.add(responseItem); }
		 */
		
		List<GetAllBrandsResponse> brandResponse = brands.stream()
				.map(brand ->this.modelMapperService.forResponse()
						.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		
		return brandResponse;
	}




	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		//Brand brand = new Brand();
		//brand.setName(createBrandRequest.getName());
		
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandRepository.save(brand);
		
	}

	@Override
	public GetByIdResponse getById(int id) {
		
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		
		GetByIdResponse response = this.modelMapperService.forResponse().map(brand, GetByIdResponse.class);
		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
		
	}

	@Override
	public void delete(int id) {
		
		this.brandRepository.deleteById(id);
			
	}




	

}
