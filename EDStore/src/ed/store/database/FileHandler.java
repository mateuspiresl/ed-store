package ed.store.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import ed.store.database.exceptions.InvalidNameException;
import ed.store.database.exceptions.NoPermissionException;

public class FileHandler {

	public static File createFile(String name) throws InvalidNameException, NoPermissionException
	{
		File file = new File(name);

		if (file.exists())
			throw new InvalidNameException("A structure named " + name + " already exists");

		try {
			file.createNewFile();
		} catch (IOException e) {
			throw new NoPermissionException(e);
		}
		
		return file;
	}

	public static File getFile(String name) throws InvalidNameException
	{
		File file = new File(name);

		if ( ! file.exists())
			throw new InvalidNameException("A structure named " + name + " doesn't exists");

		return file;
	}
	
	public static void write(File file, Object data) throws NoPermissionException
	{		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.close();
			fos.close();
		} catch (IOException e) {
			throw new NoPermissionException(e);
		}
	}

	public static void write(String path, Object data) throws NoPermissionException {
		write(new File(path), data);
	}
	
	public static Object read(File file) throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream(file);
		
		try {
			ObjectInputStream ois = new ObjectInputStream(fis);
			return ois.readObject();
		} finally {
			fis.close();
		}
	}

	public static Object read(String name) throws IOException, ClassNotFoundException, InvalidNameException {
		return read(FileHandler.getFile(name));
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
