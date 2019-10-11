package com.lab1.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.NoSuchElementException;

@SpringBootApplication
public class Main
	implements CommandLineRunner
{
	private static Terminal terminal;

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args)
	{

		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(Main.class, args);
		runTerminal();
		LOG.info("APPLICATION FINISHED");

	}

	static void runTerminal()
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

	@Override
	public void run(final String... args)
		throws
		Exception
	{
		LOG.info("EXECUTING : command line runner");

		for (int i = 0; i < args.length; ++i)
		{
			LOG.info("args[{}]: {}", i, args[i]);
		}
	}
}

