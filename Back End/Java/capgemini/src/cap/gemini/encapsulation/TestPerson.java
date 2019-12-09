package cap.gemini.encapsulation;

public class TestPerson 
{
	public static void main(String[] args) {
		
		Person p=new Person();
		
		p.setAge(22);
		p.setName("Bhavana");
		
		System.out.println(p.getAge());
		System.out.println(p.getName());
		
		p.setAge(21);
		p.setName("Ramya");
		
		System.out.println(p.getAge());
		System.out.println(p.getName());
	}

}
