package edu.capgemini.objectclass;

public class VehicleClone implements Cloneable{
	String vehName;

	public VehicleClone(String vehName) {
		super();
		this.vehName = vehName;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	

}
