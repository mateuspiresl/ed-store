package ed.store.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

	public static void write(String name, Object data) throws FileNotFoundException, IOException
	{
		FileOutputStream fos = new FileOutputStream(name);
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.close();
		} finally {
			try {
				fos.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
	
	public static Object read(String name) throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream(name);
		
		try {
			ObjectInputStream ois = new ObjectInputStream(fis);
			return ois.readObject();
		} finally {
			fis.close();
		}
	}
	
	public static Object[] readAll(String name) throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream(name);
		List<Object> objects = new ArrayList<Object>();
		
		try {
			ObjectInputStream ois = new ObjectInputStream(fis);
			objects.add(ois.readObject());
			return objects.toArray();
		} finally {
			fis.close();
		}
	}
	
}
