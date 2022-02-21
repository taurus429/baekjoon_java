package test;

public class Truck extends Car{
	private int weight;
	public Truck(int carNum,String carName,int weight) {
		super(carNum,carName);
		this.weight=weight;
	}
	@Override
	public String toString() {
		return  super.toString().concat("Truck [weight=" + weight + "]");
	}
	

}
