package demo;

import java.io.Serializable;

public class Car implements Comparable<Car>, Serializable{ // 객체 직렬화, 생성자
	private int carNum;
	private String carName;
	private String maker;
	
	public Car() {
		
	}
	public Car(int carNum, String carName, String maker) {
		super();
		this.carNum = carNum;
		this.carName = carName;
		this.maker = maker;
	}
	

	@Override
	public String toString() {
		return "Car [carNum=" + carNum + ", carName=" + carName + ", maker=" + maker + "]";
	}
	public Car(int carNum, String carName) {
		super();
		this.carNum = carNum;
		this.carName = carName;
	}
	public int getCarNum() {
		return carNum;
	}
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	@Override
	public int compareTo(Car o) {
		// TODO Auto-generated method stub
		return 0;
	}
}