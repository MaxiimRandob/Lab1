package com.lab1.main;

import java.util.NoSuchElementException;

public class Main
{
	private static Terminal terminal;

	public static void main(String[] args)
	{
		terminal = new Terminal();
		try
		{
			terminal.run();
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Wrong input");
		}
	}
}

