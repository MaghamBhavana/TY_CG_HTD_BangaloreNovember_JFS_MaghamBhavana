package edu.capgemini.objectclass;

public class Student {
	int studId;
	String studName;
	public Student(int studId, String studName) {
		
		this.studId = studId;
		this.studName = studName;
	}
	@Override
	public String toString() {
		return "Student studId= " + studId + " studName= " + studName ;
	}
	
	
	

}
