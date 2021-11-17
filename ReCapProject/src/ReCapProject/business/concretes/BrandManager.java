package ReCapProject.business.concretes;

import java.util.List;

import ReCapProject.business.abstracts.BrandService;
import ReCapProject.core.utilities.result.DataResult;
import ReCapProject.core.utilities.result.ErrorResult;
import ReCapProject.core.utilities.result.Result;
import ReCapProject.core.utilities.result.SuccessDataResult;
import ReCapProject.core.utilities.result.SuccessResult;
import ReCapProject.dataAccess.abstracts.BrandRepository;
import ReCapProject.entities.concretes.Brand;



public class BrandManager implements BrandService {

	private BrandRepository brandRepository;
	
	public BrandManager(BrandRepository brandRepository) {
		super();
		this.brandRepository = brandRepository;
	}
	
	

	@Override
	public DataResult<List<Brand>> getAll() {		
		return new SuccessDataResult<List<Brand>>(this.brandRepository.getAll());		
	}

	@Override
	public Result add(Brand brand) {
		this.brandRepository.insert(brand);
		return new SuccessResult("Marka eklendi");
	}

	@Override
	public Result remove(int brandId) {
		Brand brand= this.brandRepository.getById(brandId);
		int index=this.brandRepository.getIndex(brand);
		if(index != -1) {
			this.brandRepository.delete(brandId);
			return new SuccessResult("Marka silindi");
		}
		return new ErrorResult("Marka silme gerçekleştirilemedi");
	}

	@Override
	public Result update(Brand brand) {
		int index=this.brandRepository.getIndex(brand);
		if(index != -1) {
			this.brandRepository.update(index, brand);
			return new SuccessResult("Marka update edildi.");
		}
		return new ErrorResult("Marka update edilemedi.");
	}

	@Override
	public Brand getById(int id) {
		return this.brandRepository.getById(id);
		
	}
	
		
}
