package com.lab1.entity;

import com.lab1.Interfaces.Airplane;

public class AirplaneModel implements Airplane
{
	private int capacity;

	private int carryingCapacity;

	private int rangeOfFlight;

	private double fuelConsumption;

	private String name;

	public AirplaneModel()
	{
	}

	public AirplaneModel(
		final int capacity,
		final int carryingCapacity,
		final int rangeOfFlight,
		final String name)
	{
		this.capacity = capacity;
		this.carryingCapacity = carryingCapacity;
		this.rangeOfFlight = rangeOfFlight;
		this.name = name;
	}

	public int getCapacity()
	{
		return capacity;
	}

	public void setCapacity(final int capacity)
	{
		this.capacity = capacity;
	}

	public int getCarryingCapacity()
	{
		return carryingCapacity;
	}

	public void setCarryingCapacity(final int carryingCapacity)
	{
		this.carryingCapacity = carryingCapacity;
	}

	public int getRangeOfFlight()
	{
		return rangeOfFlight;
	}

	public void setRangeOfFlight(final int rangeOfFlight)
	{
		this.rangeOfFlight = rangeOfFlight;
	}

	public double getFuelConsumption()
	{
		return fuelConsumption;
	}

	public void setFuelConsumption(final double fuelConsumption)
	{
		this.fuelConsumption = fuelConsumption;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}


}
