package yazilim.io.rentACar.business.abstracts;

import java.util.List;

import yazilim.io.rentACar.business.requests.CreateModelRequest;
import yazilim.io.rentACar.business.responses.GetAllModelsResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);
}
