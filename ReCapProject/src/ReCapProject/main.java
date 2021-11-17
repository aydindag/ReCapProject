package ReCapProject;

import ReCapProject.business.abstracts.BrandService;
import ReCapProject.business.abstracts.CarService;
import ReCapProject.business.abstracts.ColorService;
import ReCapProject.business.concretes.BrandManager;
import ReCapProject.business.concretes.CarManager;
import ReCapProject.business.concretes.ColorManager;
import ReCapProject.dataAccess.concretes.BrandDao;
import ReCapProject.dataAccess.concretes.CarDao;
import ReCapProject.dataAccess.concretes.ColorDao;
import ReCapProject.entities.concretes.Brand;
import ReCapProject.entities.concretes.Car;
import ReCapProject.entities.concretes.Color;

public class main {

	public static void main(String[] args) {
		
		BrandService brandService=new BrandManager(new BrandDao());
		
		brandService.add(new Brand(1,"Peugeot"));
		brandService.add(new Brand(2,"Bmw"));
		brandService.add(new Brand(3,"Mercedes"));
		brandService.add(new Brand(4,"Wolkswagen"));
		brandService.remove(2);
		brandService.getById(4);
		brandService.update(new Brand(3,"Mercedessss"));
		 for(Brand brands: brandService.getAll().getData()) {
			 System.out.println(brands.toString());
		 }
		
		ColorService colorService=new ColorManager(new ColorDao());
		colorService.add(new Color(1,"mavi"));
		colorService.add(new Color(2,"beyaz"));
		colorService.add(new Color(3,"siyah"));
		colorService.remove(3);
		
		for(Color colors: colorService.getAll().getData()) {
			 System.out.println(colors.toString());
		 }
		
		
		CarService carService = new CarManager(new CarDao());
		Car car = new Car(1,1,1,2021,150000,"Son Model");
		carService.add(car);
		carService.add(new Car(2,2,3,2021,150000,"Son Model"));
		carService.update(new Car(1,1,1,2020,255000,"Eski Model"));

		
		 for(Car cars: carService.getAll().getData()) {
			 System.out.println(cars.toString());
		 }
	
	}

}