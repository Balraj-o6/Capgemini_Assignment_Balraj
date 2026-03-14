package com.cg.bean;

import org.springframework.stereotype.Component;

@Component
public class MrfTire implements ITyre{
	public String getTyreDetail() {
		return "MRF Tire";
	}
}
