package demo;

public class Truck extends Car{
	private int weight;
	
	public Truck(int carNum, String carName, int weight) {
		super(carNum, carName);
		this.weight = weight;
		//선조에 기본 생성자가 없으면 에러 발생
	}

	@Override
	public String toString() {
		return super.toString().concat("Truck [weight=" + weight + "]");
	}
}
