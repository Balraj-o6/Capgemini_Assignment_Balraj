package com.cg.bean;

import org.springframework.stereotype.Component;

@Component("cng")
public class CngEngine implements IEngine {

	@Override
	public String getBhp() {
		// TODO Auto-generated method stub
		return "110 BHP";
	}

}
