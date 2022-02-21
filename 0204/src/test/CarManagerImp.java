package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarManagerImp  implements CarManager{
	private List<Car>list;
	public static CarManagerImp instance;
		
	public CarManagerImp() {
		list=new ArrayList<Car>();
	}
    public static CarManager getdInstance() {//싱글턴
    	 if(instance==null) {
    		 instance=new CarManagerImp();
    	 }
    	 return instance;
    }
	@Override
	public void add(Car car) throws SNumException {
		// TODO Auto-generated method stub
		try {
			searchByName(car.getCarNum());
			throw new SNumException("이미 등록된번호 "+car.getCarNum());
		} catch (NotFoundException e) {
			// TODO: handle exception
			list.add(car);
		}
	}

	@Override
	public List<Car> search() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Car searchByName(int carNum) throws NotFoundException {
		// TODO Auto-generated method stub
		for(Car car:list) {
			if(car.getCarNum()==carNum)return car;
		}
		throw new NotFoundException("Not Found Exception");
		//return null;
	}

	@Override
	public void delete(String carName) {//
		// TODO Auto-generated method stub
	    //for (int i = 0; i < list.size(); i++) {
		for(int i=list.size()-1;i>=0;i--) {
			if(carName.equals(list.get(i).getCarName()))list.remove(i);
		}
	}

	@Override
	public void fileSave() {
		// TODO Auto-generated method stub
		ObjectOutputStream oos=null;
		try {
			oos=new ObjectOutputStream(new FileOutputStream(new File(new String("d:\\car.dat"))));
			oos.writeObject(list);
			oos.flush();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(oos!=null)oos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

	@Override
	public List<Car> fileLoad() {
		// TODO Auto-generated method stub
		File file = new File("d:\\car.dat");
		if(file.exists()) {
			ObjectInputStream objectInputStream = null;
			try {
				objectInputStream = new ObjectInputStream(new FileInputStream(file));
				list = (List<Car>) objectInputStream.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					if(objectInputStream != null)
						objectInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return list;
		} else {
			return Collections.EMPTY_LIST;
		}
	}
	

}
