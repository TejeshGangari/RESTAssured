package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationTest {

	public static void main(String[] args) {
		Rectangle rect = new Rectangle(10, 10);
		//writeToStream(rect, "serializeObj");
		
		Rectangle obj = (Rectangle) deserializeFromFile("serializeObj");
		System.out.println(obj);

	}
	
	public static void writeToStream(Object obj,String fileName) {
		FileOutputStream fo;
		try {
			fo = new FileOutputStream(new File(fileName));
			ObjectOutputStream objStream = new ObjectOutputStream(fo);
			objStream.writeObject(obj);
			objStream.close();
			fo.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Object deserializeFromFile(String fileName) {
		try {
			FileInputStream fi = new FileInputStream(new File(fileName));
			ObjectInputStream objIn = new ObjectInputStream(fi);
			Object desObj = objIn.readObject();
			fi.close();
			objIn.close();
			return desObj;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
