package com.lab1.model;

import com.lab1.Interfaces.Airplane;

public class Boeing_787 implements Airplane
{
	@Override
	public int getCapacity()
	{
		return 312;
	}

	@Override
	public int getCarryingCapacity()
	{
		return 225500;
	}

	@Override
	public int getRangeOfFlight()
	{
		return 14100;
	}

	@Override
	public double getFuelConsumption()
	{
		return 0.9;
	}

	@Override
	public String getName()
	{
		return "Boeing 787";
	}
}

