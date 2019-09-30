package com.lab1.model;

import com.lab1.Interfaces.Airplane;

public class An_24 implements Airplane
{
	@Override
	public int getCapacity()
	{
		return 57;
	}

	@Override
	public int getCarryingCapacity()
	{
		return 6500;
	}

	@Override
	public int getRangeOfFlight()
	{
		return 2820;
	}

	@Override
	public double getFuelConsumption()
	{
		final double i;
		i =(double)this.getRangeOfFlight()/4850;
		return i;
	}

	@Override
	public String getName()
	{
		return "An-24";
	}
}

