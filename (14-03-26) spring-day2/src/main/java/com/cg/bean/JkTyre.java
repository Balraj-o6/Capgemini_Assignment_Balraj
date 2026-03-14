package com.cg.bean;

import org.springframework.stereotype.Component;

@Component("jk")
public class JkTyre implements ITyre {

	
	public String getTyreDetail() {
		
		return "JK Tyre";
	}

}
