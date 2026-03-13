package com.cg.sbu;

public class SBU {
	private int sbuCode;
	private String sbuHead;
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
