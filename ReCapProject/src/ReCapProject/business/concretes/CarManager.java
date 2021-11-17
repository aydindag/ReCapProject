package ReCapProject.business.concretes;

import java.util.List;

import ReCapProject.business.abstracts.CarService;
import ReCapProject.core.utilities.result.DataResult;
import ReCapProject.core.utilities.result.ErrorResult;
import ReCapProject.core.utilities.result.Result;
import ReCapProject.core.utilities.result.SuccessDataResult;
import ReCapProject.core.utilities.result.SuccessResult;
import ReCapProject.dataAccess.abstracts.CarRepository;
import ReCapProject.entities.concretes.Car;

public class CarManager implements CarService {

	private CarRepository carRepository;
	
	public CarManager(CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}

	@Override
	public DataResult<List<Car>> getAll() {
		return new SuccessDataResult<List<Car>>(this.carRepository.getAll());
		
	}

	@Override
	public Result add(Car car) {
		this.carRepository.insert(car);
		return new SuccessResult("Araba eklendi");
	}

	@Override
	public Result remove(int carId) {
		Car car= this.carRepository.getById(carId);
		int index=this.carRepository.getIndex(car);
		if(index != -1) {
			this.carRepository.delete(carId);
			return new SuccessResult("Araba silindi");
		}
		return new ErrorResult("Araba silme gerçekleştirilemedi");
	
	}

	@Override
	public Result update(Car car) {
		int index=this.carRepository.getIndex(car);
		if(index != -1) {
			this.carRepository.update(index, car);
			return new SuccessResult("Araba update edildi.");
		}
		return new ErrorResult("Araba update edilemedi.");
	}

	@Override
	public Car getById(int id) {
		return this.carRepository.getById(id);
	}

}
