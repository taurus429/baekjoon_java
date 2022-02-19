package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareableTest {
	
	public static void main(String[] args) {
		Integer []i= {50,54,67,99,100,45};
		/*System.out.println(Arrays.toString(i));
		Arrays.sort(i);
		
		System.out.println(Arrays.toString(i));	*/
		
		List<Integer>numList=Arrays.asList(i);
		/*System.out.println(numList);
		Collections.sort(numList);//오름차순
		System.out.println("1."+numList);
		Collections.reverse(numList);//내림차순
		System.out.println("2."+numList);*/
		
		/*Collections.sort(numList, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				//return o1.intValue()-o2.intValue();
				return o2.intValue()-o1.intValue();
			}
			
		});
		System.out.println(numList);
*/	
		
		Car car1 = new Car(2460, "SonataB", "HD");
		Car car2 = new Car(3488, "SonataC", "HD");
		Car car3 = new Car(1479, "Avante", "HD");
		Car car4 = new Car(6825, "K5", "KIA");
		Car car5 = new Car(6951, "SonataA", "HD");
		Car car6 = new Car(3910, "SM6", "SS");
		Car car7 = new Car(2136, "GENESIS", "HD");
		Car car8 = new Car(1306, "QM6", "SS");
		Car car9 = new Car(9667, "K7", "KIA");
		Car car10 = new Car(9668, "K5D", "KIA");
		
		List<Car> list = new ArrayList<>();
		list.add(car1);
		list.add(car2);
		list.add(car3);
		list.add(car4);
		list.add(car5);
		list.add(car6);
		list.add(car7);
		list.add(car8);
		list.add(car9);
		list.add(car10);	
		
		Comparator<Car>comparator = new Comparator<Car>() {

			@Override
			public int compare(Car o1, Car o2) {
				// TODO Auto-generated method stub
				return o1.getCarName().compareTo(o2.getCarName());
			}
		};
		Collections.sort(list, comparator);
		view(list);
		
	}
	static void view(List<Car>list) {
		System.out.println("CarList");
		for(Car c:list) {
			System.out.println(c);
		}
	}

}


