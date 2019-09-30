package com.lab1.model;

import com.lab1.Interfaces.Airplane;

public class Boeing_747 implements Airplane
{
	@Override
	public int getCapacity()
	{
		return 270;
	}

	@Override
	public int getCarryingCapacity()
	{
		return 190000;
	}

	@Override
	public int getRangeOfFlight()
	{
		return 13100;
	}

	@Override
	public double getFuelConsumption()
	{
		return 0.7;
	}

	@Override
	public String getName()
	{
		return "Boeing 747";
	}
}

