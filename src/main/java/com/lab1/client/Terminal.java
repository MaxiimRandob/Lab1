package com.lab1.client;

import java.util.Scanner;

public class Terminal
{
	private Scanner scanner = new Scanner(System.in);

	private Airline airline;

	public void run()
	{
		while (true)
		{
			final String command = getCommand();

			if (isExit(command))
			{
				break;
			}

			if (isHelp(command))
			{
				displayHelp();
				continue;
			}

			if (isSupported(command))
			{
				processCommand(command);
			}
			else
			{
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
				System.out.println("Nothing to show yet");
			}
		}

		/*if (command.equals("fuel"))
		{
			if (airline == null)
			{
				System.out.println("Nothing to count yet");
				return;
			}

			double lowBound, highBound;
			Scanner in = new Scanner(System.in);
			System.out.println("Write low range bound: ");
			lowBound = in.nextDouble();
			System.out.println("Write high range bound: ");
			highBound = in.nextDouble();
			in.close();

			System.out.println("Airplane with fuel consumption of given range: " + airline.findAirplaneByFuelConsumptionRange(lowBound, highBound));
		} */
	}



	private boolean isSupported(final String command)
	{
		return command.equals("range") || command.equals("capacity") || command.equals("create") || /*command.equals("fuel") ||*/ command.equals("fill");
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
		//System.out.println("'fuel' - to show fuel consumption parameters in given range");
		System.out.println("help");
		System.out.println("exit");
	}
}
