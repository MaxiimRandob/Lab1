package com.lab1.model;

import com.lab1.Interfaces.Airplane;

public class An_2
	implements Airplane
{
	@Override
	public int getCapacity()
	{
		return 14;
	}

	@Override
	public int getCarryingCapacity()
	{
		return 1500;
	}

	@Override
	public int getRangeOfFlight()
	{
		return 990;
	}

	@Override
	public double getFuelConsumption()
	{
		final double i;
		i = (double)this.getRangeOfFlight() / 1250;
		return i;
	}

	@Override
	public String getName()
	{
		return "An-2";
	}
}

