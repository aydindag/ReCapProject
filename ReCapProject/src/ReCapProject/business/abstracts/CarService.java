package ReCapProject.business.abstracts;

import java.util.List;

import ReCapProject.core.utilities.result.DataResult;
import ReCapProject.core.utilities.result.Result;
import ReCapProject.entities.concretes.Car;

public interface CarService {
	
	DataResult<List<Car>> getAll();
	Result add(Car car);
	Result remove(int cardId);
	Result update(Car Car);
	Car getById(int id);
}
