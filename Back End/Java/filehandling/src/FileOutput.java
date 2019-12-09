import java.io.FileOutputStream;

public class FileOutput {
	public static void main(String[] args) {
		
		try
		{
			FileOutputStream f = new FileOutputStream("rams.txt");
			String name="Bhavana";
			byte[] b=name.getBytes();
			f.write(b);
			System.out.println("Success----");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
