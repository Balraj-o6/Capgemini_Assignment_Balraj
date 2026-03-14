package com.cg.bean;

import org.springframework.stereotype.Component;

@Component
public class PetrolEngine implements IEngine{
	public String getBhp() {
		return "150 BHP";
	}
}
