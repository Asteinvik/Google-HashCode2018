package googleHashCode;

public class Ride implements Comparable<Ride>{
	private int id;
	private Map start;
	private Map end;
	private int earliest;
	private int latest;
	private int distance;
	
	public Ride (int id,String input){
		this.id=id;
		String[] row=(input.split(" "));
		this.earliest=Integer.parseInt(row[4]);
		this.latest=Integer.parseInt(row[5]);
		this.start = new Map(Integer.parseInt(row[0]),Integer.parseInt(row[1]),this.earliest);
		this.end = new Map(Integer.parseInt(row[2]),Integer.parseInt(row[3]),this.latest);
		this.distance= Math.abs(end.getY()-start.getY())+Math.abs(end.getX()-start.getX());
		
	}
	public int getId(){
		return id;
	}

	public Map getStart() {
		return start;
	}

	public Map getEnd() {
		return end;
	}

	public int getEarliest() {
		return earliest;
	}

	public int getLatest() {
		return latest;
	}
	public int getDist(){
		return distance;
	}
	@Override
	public int compareTo(Ride o) {
		if(this.earliest<o.getEarliest()){
			return 1;
		}
		else if(this.earliest>o.getEarliest()){
			return -1;
		}
		else{
			if(this.start.difference(new Map(0,0,0))<o.start.difference(new Map(0,0,0))){
				return 1;
			}
			else if(this.start.difference(new Map(0,0,0))>o.start.difference(new Map(0,0,0))){
				return -1;
			}
		}
		return 0;
	}
	
	
}
