package googleHashCode;

public class Map {

	private int x;
	private int y;
	private int t;
	
	
	public Map (int x,int y,int t){
		this.x=x;
		this.y=y;
		this.t=t;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public int getT(){
		return t;
	}
	public int difference(Map o){
		return Math.abs(this.getY()-o.getY())+Math.abs(this.getX()-o.getX());
	}
}
