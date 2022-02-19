package demo;

public class CarMain {
	public static void main(String[] args) {		
		CarManager carManager = CarManagerImp.getInstane();
		System.out.println("자동차 등록");
		try {
			carManager.add(new Car(1111,"쏘나타"));
			carManager.add(new Car(2222,"제네시스"));
			carManager.add(new Car(3333,"벤츠"));
			carManager.add(new Truck(4444,"봉고",2500));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		carManager.search();
	}
}
