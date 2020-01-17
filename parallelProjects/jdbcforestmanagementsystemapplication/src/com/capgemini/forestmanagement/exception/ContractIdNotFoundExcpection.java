package com.capgemini.forestmanagement.exception;

public class ContractIdNotFoundExcpection extends RuntimeException {
	public ContractIdNotFoundExcpection() {
		super("Contract not found with this Id");
	}
}
