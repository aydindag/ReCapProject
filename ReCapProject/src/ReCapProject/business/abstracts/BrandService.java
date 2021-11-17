package ReCapProject.business.abstracts;


import java.util.List;

import ReCapProject.core.utilities.result.DataResult;
import ReCapProject.core.utilities.result.Result;
import ReCapProject.entities.concretes.Brand;


public interface BrandService {
	
	DataResult<List<Brand>> getAll();
	Result add(Brand brand);
	Result remove(int brandId);
	Result update(Brand brand);
	Brand getById(int id);

}
