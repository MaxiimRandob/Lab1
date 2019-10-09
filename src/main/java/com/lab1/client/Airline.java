package com.lab1.client;

import com.lab1.Interfaces.Airplane;
import com.lab1.model.An_2;
import com.lab1.model.An_225;
import com.lab1.model.An_24;
import com.lab1.model.Boeing_747;
import com.lab1.model.Boeing_767;
import com.lab1.model.Boeing_787;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Airline
{

	private final Collection<Airplane> airplanes = new LinkedList<>();

	public int getTotalCarryingCapacity()
	{
		return airplanes.stream().map(Airplane::getCarryingCapacity).reduce(0, Integer::sum);
	}

	public int getTotalCapacity()
	{
		return airplanes.stream().map(Airplane::getCapacity).reduce(0, Integer::sum);
	}

	public Collection<Airplane> getAirplanesSortedByRangeOfFlight()
	{
		final List<Airplane> list = new ArrayList<>(airplanes);
		list.sort(Comparator.comparingInt(Airplane::getRangeOfFlight));
		return list;
	}

	public String findAirplaneByFuelConsumptionRange(
		double lowRangeBound,
		double highRangeBound)
	{
		String result = null;
		try
		{
			result = airplanes
				.stream()
				.filter(airplane -> airplane.getFuelConsumption() >= lowRangeBound && airplane.getFuelConsumption() <= highRangeBound)
				.findFirst().get().getName();
		}
		catch (NoSuchElementException e)
		{
			System.out.println("No elements in given range");
		}
		return result;
	}

	public void addAirplane(final Airplane airplane)
	{
		Objects.requireNonNull(airplane);

		airplanes.add(airplane);
	}

	public void fillAirline()
	{
		An_2 an_2 = new An_2();
		An_24 an_24 = new An_24();
		An_225 an_225 = new An_225();
		Boeing_747 boeing_747 = new Boeing_747();
		Boeing_787 boeing_787 = new Boeing_787();
		Boeing_767 boeing_767 = new Boeing_767();

		this.addAirplane(an_2);
		this.addAirplane(an_24);
		this.addAirplane(an_225);
		this.addAirplane(boeing_747);
		this.addAirplane(boeing_787);
		this.addAirplane(boeing_767);
	}

	public Collection<Airplane> getAirplanes()
	{
		return airplanes;
	}
}

