package com.cg.sbu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("sbu")
public class SBU {
	@Value("${sbucode}")
	private int sbuCode;
	@Value("${sbuhead}")
	private String sbuHead;
	@Value("${sbuname}")
	private String sbuName;

	public void setSbuCode(int sbuCode) {
		this.sbuCode = sbuCode;
	}

	public void setSbuHead(String sbuHead) {
		this.sbuHead = sbuHead;
	}

	public void setSbuName(String sbuName) {
		this.sbuName = sbuName;
	}

	public String getSbuDetails() {
		return "SBU Details\n" + "SBU Code: " + sbuCode + "\n" + "SBU Head: " + sbuHead + "\n" + "SBU Name: " + sbuName;
	}
}
