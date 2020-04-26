package base;

import java.io.Serializable;

public class Rectangle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 558423574059226353L;
	public int width;
	public int height;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
		
	}
	
	public int getArea() {
		return width*height;
	}
}
