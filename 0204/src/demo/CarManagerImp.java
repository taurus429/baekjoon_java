package demo;

import java.util.ArrayList;
import java.util.List;

public class CarManagerImp implements CarManager {
	private List<Car> list;
	public static CarManager instance;

	public CarManagerImp() {
		// TODO Auto-generated constructor stub
		super();
		list = new ArrayList<Car>();
	}

	public static CarManager getInstane() {
		if (instance == null) {
			instance = new CarManagerImp();
		}
		return instance;

	}

	@Override
	public void add(Car car) throws SNumException {
		// TODO Auto-generated method stub
		try {
			searchByName(car.getCarNum());
			throw new SNumException("이미 등록된 번호");
		} catch (NotFoundException e) {
			// TODO: handle exception
			list.add(car);
		}

	}

	@Override
	public List<Car> search() {
		// TODO Auto-generated method stub
		for(Car car:list) {
			System.out.println(car);
		}
		return null;
	}

	@Override
	public Car searchByName(int carNum) throws NotFoundException {
		// TODO Auto-generated method stub
		for (Car car : list) {
			if (car.getCarNum() == carNum)
				return car;
		}
		throw new NotFoundException("그런 차 없습니다");
	}

	@Override
	public void delete(String carName) {
		// TODO Auto-generated method stub
		for (Car car : list) {
			if (car.getCarName().equals(carName)) {
				list.remove(car);
				return;
			}
		}
	}

	@Override
	public void filesave() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Car> fileLoad() {
		// TODO Auto-generated method stub
		return null;
	}

}
