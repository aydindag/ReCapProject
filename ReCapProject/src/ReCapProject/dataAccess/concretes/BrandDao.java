package ReCapProject.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ReCapProject.dataAccess.abstracts.BrandRepository;
import ReCapProject.entities.concretes.Brand;


public class BrandDao implements BrandRepository {
	
	List<Brand> brands;
	
	public BrandDao() {
		super();
		brands=new ArrayList<Brand>();
	}

	@Override
	public void insert(Brand brand) {
		brands.add(brand);
		
	}

	@Override
	public void delete(int brandId) {
		brands.remove(this.getById(brandId));
	}

	
	@Override
	public void update(int index, Brand brand) {
		brands.set(index,brand);
		
	}
	
	@Override
	public Brand getById(int id) {
		for(Brand item : brands) {
			if(item.getBrandId() == id)
				return item;
		}
		return null;
	}

	@Override
	public List<Brand> getAll() {
		
		return brands;
	}

	

	@Override
	public int getIndex(Brand brand) {
		int index=0;
		for(Brand item : this.brands ) {
			if(item.getBrandId() == brand.getBrandId()){
				return index;
			}
			index++;
		}
		return -1;
	}

	

	

}
