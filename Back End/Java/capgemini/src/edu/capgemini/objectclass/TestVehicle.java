package edu.capgemini.objectclass;

public class TestVehicle {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		VehicleClone v=new VehicleClone("Car");
		Object o=v.clone();
		VehicleClone v1=(VehicleClone)o;
		System.out.println(o);
		System.out.println(v.vehName);
		System.out.println(v1.vehName);
	}

}
