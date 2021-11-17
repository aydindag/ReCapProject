package ReCapProject.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;
import ReCapProject.dataAccess.abstracts.CarRepository;
import ReCapProject.entities.concretes.Car;

public class CarDao implements CarRepository {

	List<Car> cars;
	
	public CarDao() {
		super();
		cars = new ArrayList<Car>();
	}
	
	@Override
	public void insert(Car car) {
		cars.add(car);
	}

	@Override
	public void delete(int carId) {
		cars.remove(this.getById(carId));
		
	}

	@Override
	public void update(int index, Car car) {
		cars.set(index, car);
	}

	@Override
	public Car getById(int id) {
		for(Car item : cars) {
			if(item.getCarId() == id)
				return item;
		}
		return null;
		
	}

	@Override
	public List<Car> getAll() {
	
		return cars;
	}

	@Override
	public int getIndex(Car car) {
		int index=0;
		for(Car item : this.cars ) {
			if(item.getCarId() == car.getCarId()){
				return index;
			}
			index++;
		}
		return -1;
	}


	
}
