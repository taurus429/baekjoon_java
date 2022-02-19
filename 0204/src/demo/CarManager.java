package demo;

import java.util.List;

public interface CarManager {
	public void add(Car car) throws SNumException;
	List<Car> search();
	Car searchByName(int carNum) throws NotFoundException;
	void delete(String carName);
	void filesave();
	List<Car> fileLoad();
}
