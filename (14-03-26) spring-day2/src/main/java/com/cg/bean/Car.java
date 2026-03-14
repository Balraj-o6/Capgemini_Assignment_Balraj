package com.cg.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {
	@Value("${carname}")
	private String name;
	@Autowired
	@Qualifier("cng")
	private IEngine engine;
	@Autowired
	@Qualifier("jk")
	private ITyre tyre;

	public Car() {}
	public Car(IEngine petrolEngine, ITyre mrfTire) {
		super();
		this.engine = petrolEngine;
		this.tyre = mrfTire;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IEngine getEngine() {
		return engine;
	}

	public void setEngine(IEngine petrolEngine) {
		this.engine = petrolEngine;
	}

	public ITyre getTire() {
		return tyre;
	}

	public void setTyre(ITyre mrfTire) {
		this.tyre = mrfTire;
	}
	
	public void printCar() {
		System.out.println("Car Name: "+name);
		System.out.println("BHP: "+engine.getBhp());
		System.out.println("Tyre Detail: "+tyre.getTyreDetail());
	}

}
