package yazilim.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import yazilim.io.rentACar.business.abstracts.BrandService;
import yazilim.io.rentACar.business.requests.CreateBrandRequest;
import yazilim.io.rentACar.business.requests.UpdateBrandRequest;
import yazilim.io.rentACar.business.responses.GetAllBrandsResponse;
import yazilim.io.rentACar.business.responses.GetByIdResponse;

/**
 * 
 */
@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsControllers {
	private BrandService brandService;

	// @Autowired -> git conctructtor'un parametrelerine bak BrandService'i kim
	// implements ediyor ise onun new'lenmiş halini getir demek

	@GetMapping()
	public List<GetAllBrandsResponse> getAll() {
		return brandService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdResponse getById(@PathVariable int id) {
		return brandService.getById(id);
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
	@PutMapping
	public void update(@RequestBody() UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.brandService.delete(id);
	}
}
