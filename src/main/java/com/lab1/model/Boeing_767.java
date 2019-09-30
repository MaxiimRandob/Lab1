package com.lab1.model;

import com.lab1.Interfaces.Airplane;

public class Boeing_767 implements Airplane
{
	@Override
	public int getCapacity()
	{
		return 280;
	}

	@Override
	public int getCarryingCapacity()
	{
		return 213000;
	}

	@Override
	public int getRangeOfFlight()
	{
		return 13100;
	}

	@Override
	public double getFuelConsumption()
	{
		return 0.77;
	}

	@Override
	public String getName()
	{
		return "Boeing 767";
	}
}

