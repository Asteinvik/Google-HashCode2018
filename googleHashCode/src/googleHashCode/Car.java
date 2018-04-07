package googleHashCode;

import java.util.ArrayList;

public class Car implements Comparable<Car>{

	private Map pos;
	private ArrayList<Integer> rides;
	private int id;
	
	public Car(int id){
		this.id=id;
		this.pos=new Map(0,0,0);
		this.rides= new ArrayList<Integer>();
	}

	public Map getPos() {
		return pos;
	}

	public void setPos(Map pos) {
		this.pos = pos;
	}
	
	public ArrayList<Integer> getRides() {
		return rides;
	}

	public void setRides(Integer ride, int x,int y, int t) {
		this.rides.add(ride);
		this.pos= new Map(x,y,t);
	}
	public int getId(){
		return id;
	}
	public String toStringRides(){
		String string=Integer.toString(rides.size());
		for(int i : rides){
			string+=" "+(Integer.toString(i));
		}
		return string;
	}
	@Override
	public int compareTo(Car o){
		if(this.pos.getT()<o.getPos().getT()){
			return 1;
		}
		if(this.pos.getT()>o.getPos().getT()){
			return -1;
		}
		return 0;
	}
}
