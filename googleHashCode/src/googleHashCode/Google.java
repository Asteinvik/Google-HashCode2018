package googleHashCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Google {

	public static void main (String args[]) throws IOException{
		FileReader file = new FileReader("b_should_be_easy.in");
		BufferedReader in = new BufferedReader(file);
		
		
		String[] firstRow=(in.readLine().split(" "));
		int gridRow = Integer.parseInt(firstRow[0]);
		int gridCol = Integer.parseInt(firstRow[1]);
		int nVehicles = Integer.parseInt(firstRow[2]);
		int nRides = Integer.parseInt(firstRow[3]);
		int bonus = Integer.parseInt(firstRow[4]);
		int steps = Integer.parseInt(firstRow[5]);
		
		ArrayList<Car> cars=new ArrayList<Car>();
		PriorityQueue<Ride> rides=new PriorityQueue<Ride>();
		for(int i=0;i<nVehicles;i++){
			cars.add(new Car(i));
		}
		for(int i=0;i<nRides;i++){
			rides.add(new Ride(i,in.readLine()));
		}
		for(int i=0;i<rides.size();i++){
			Ride trip=rides.poll();
			Map rideStart=trip.getStart();
			Car taxi=getClosestCar(trip,cars,steps);
			int finishTime=taxi.getPos().getT()+taxi.getPos().difference(rideStart)+trip.getDist();
			if(finishTime>steps||finishTime>trip.getLatest()){
				continue;
			}
			else{
				taxi.setRides(trip.getId(),trip.getEnd().getX(),trip.getEnd().getY(),finishTime);
				//System.out.println("found car"+taxi.getId()+" "+trip.getId());
			}
		}
		printRides(cars);
	}
	public static Car getClosestCar(Ride ride, ArrayList<Car> cars,int steps){
		Car closest=null;
		Collections.sort(cars);
		int dist=Integer.MAX_VALUE;
		Map rPos=ride.getStart();
		for(int i=0;i<cars.size();i++){
			Car car=cars.get(i);
			int distance=car.getPos().difference(rPos);
			int finishTime=car.getPos().getT()+car.getPos().difference(rPos)+ride.getDist();
			if(finishTime>steps||finishTime>ride.getLatest()){
				continue;
			}
			else{
				if(distance==0){
					return car;
				}
				else if (distance<dist) {
					
					closest=car;
					dist=distance;
				}
		}
		}
		if(closest!=null){
		return closest;
		}
		else{
			throw new NullPointerException();
		}
		
	}
	public static void printRides(ArrayList<Car> cars){
		for(Car car : cars){
			String rides=car.toStringRides();
			System.out.println(rides);
			}
	}
}

