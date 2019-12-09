import java.io.FileInputStream;

public class FileInput {
	public static void main(String[] args) {
		
		try
		{
			FileInputStream f = new FileInputStream("rams.txt");
			
			int j = 0;
			while((j = f.read()) != -1)
			{
				System.out.print((char)j);
			}

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
