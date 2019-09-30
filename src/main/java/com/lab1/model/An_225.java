package com.lab1.model;

import com.lab1.Interfaces.Airplane;

public class An_225 implements Airplane
{
	@Override
	public int getCapacity()
	{
		return 94;
	}

	@Override
	public int getCarryingCapacity()
	{
		return 250000;
	}

	@Override
	public int getRangeOfFlight()
	{
		return 15400;
	}

	@Override
	public double getFuelConsumption()
	{
		return 0.6;
	}

	@Override
	public String getName()
	{
		return "An-225";
	}
}

