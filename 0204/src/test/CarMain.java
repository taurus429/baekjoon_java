package test;

import java.util.Collection;
import java.util.Collections;

public class CarMain {
  public static void main(String[] args) {
	CarManager carManager=CarManagerImp.getdInstance();//싱글턴
	System.out.println("자동차 등록!");
	try {
		carManager.add(new Car(1111, "쏘나타"));
		carManager.add(new Car(2222, "제네시스"));		
		carManager.add(new Car(3333, "벤츠"));
		carManager.add(new Truck(4444, "봉고", 2500));		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	System.out.println("자동차 등록 완료 List!");
	for(Car c:carManager.search()) {
		System.out.println(c);
	}
	System.out.println("자동차 검색 2222");
	try {
		System.out.println(carManager.searchByName(2222));
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	System.out.println("자동차  삭제 쏘나타");
	carManager.delete("쏘나타");
	System.out.println("자동차 등록 완료 List!");
	for(Car c:carManager.search()) {
		System.out.println(c);
	}
	System.out.println("Car Save");
	carManager.fileSave();
	System.out.println("FileSave");
	
	System.out.println("CarName Sort");
	Collections.sort(carManager.search());
	for(Car c:carManager.search()) {
		System.out.println(c);
	}
	
	
  }
}













