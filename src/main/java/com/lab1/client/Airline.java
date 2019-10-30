package com.lab1.client;

import com.lab1.Interfaces.Airplane;
import com.lab1.dao.AirplaneDao;
import com.lab1.dao.impl.AirplaneDaoImpl;
import com.lab1.model.An_2;
import com.lab1.model.An_225;
import com.lab1.model.An_24;
import com.lab1.model.Boeing_747;
import com.lab1.model.Boeing_767;
import com.lab1.model.Boeing_787;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Airline
{

	private static final Logger logger = Logger.getLogger(Airline.class);

	private Collection<Airplane> airplanes = new LinkedList<>();

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
		logger.info("Sorted list of airplanes is created");
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
			logger.error("Wrong range", e);
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
		AirplaneDao airplaneDao = new AirplaneDaoImpl();
		this.airplanes = airplaneDao.getAirplanes();
		logger.info("Airline is filled");
	}

	public Collection<Airplane> getAirplanes()
	{
		return airplanes;
	}
}

