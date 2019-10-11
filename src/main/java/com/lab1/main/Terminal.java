package com.lab1.main;

import com.lab1.client.Airline;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Terminal
{
	private Scanner scanner = new Scanner(System.in);

	private Airline airline;

	private static final Logger LOG = Logger.getLogger(Terminal.class);

	public void run()
	{
		while (true)
		{
			LOG.info("Terminal is working");
			final String command = getCommand();

			if (isExit(command))
			{
				LOG.info("User typed Exit");
				break;
			}

			if (isHelp(command))
			{
				LOG.info("Printed Help");
				displayHelp();
				continue;
			}

			if (isSupported(command))
			{
				processCommand(command);
			}
			else
			{
				LOG.info("Command id not supported");
				displayHelp();
			}
		}
	}

	private String getCommand()
	{
		return scanner.next().toLowerCase();
	}

	private void processCommand(final String command)
	{
		if (command.equals("create"))
		{
			if (this.airline == null)
			{
				this.airline = new Airline();
				System.out.println("Airline is created!");
			}
			else
			{

				System.out.println("Airline is already created!");
			}
		}

		if (command.equals("fill"))
		{
			try
			{
				airline.fillAirline();
				System.out.println("Airline is filled!");
			}
			catch (NullPointerException e)
			{
				LOG.error("failed to fill airline with airplanes", e);
				System.out.println("Nothing to fill yet");
			}
		}

		if (command.equals("capacity"))
		{
			try
			{
				System.out.println("Total capacity is: " + airline.getTotalCapacity());
				System.out.println("Total carrying capacity is: " + airline.getTotalCarryingCapacity());
			}
			catch (NullPointerException e)
			{
				LOG.error("failed to show capacity of airline", e);
				System.out.println("Nothing to show yet");
			}
		}
		if (command.equals("range"))
		{
			try
			{
				airline.getAirplanesSortedByRangeOfFlight().forEach(airplane -> System.out.println(airplane.getName() + " "));
			}
			catch (NullPointerException e)
			{
				LOG.error("failed to show search range of airline", e);
				System.out.println("Nothing to show yet");
			}
		}

	}



	private boolean isSupported(final String command)
	{
		return command.equals("range") || command.equals("capacity") || command.equals("create") || command.equals("fill");
	}

	private boolean isExit(final String command)
	{
		return command.equals("exit");
	}

	private boolean isHelp(final String command)
	{
		return command.equals("help");
	}

	private void displayHelp()
	{
		System.out.println("'create' - create new Airline");
		System.out.println("'fill' - to fill Airline with airplanes");
		System.out.println("'capacity' - to calculate and show total capacity and load capacity");
		System.out.println("'range' - to sort airplanes by range and show");
		System.out.println("help");
		System.out.println("exit");
	}
}
