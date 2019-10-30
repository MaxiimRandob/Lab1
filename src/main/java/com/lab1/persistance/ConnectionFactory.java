package com.lab1.persistance;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory
{
	private static final Logger LOG = Logger.getLogger(ConnectionFactory.class);

	private static final ConnectionFactory INSTANCE = new ConnectionFactory();

	private static DataSource dataSource;

	private ConnectionFactory()
	{

	}

	static
	{
		Properties properties = new Properties();
		try
		{
			properties.load(ConnectionFactory.class.getResourceAsStream("/db.properties"));
			MysqlDataSource mysqlDataSource = new MysqlDataSource();
			mysqlDataSource.setURL(properties.getProperty("DB_URL"));
			mysqlDataSource.setUser(properties.getProperty("DB_USERNAME"));
			mysqlDataSource.setPassword(properties.getProperty("DB_PASSWORD"));

			dataSource = mysqlDataSource;
			LOG.info("Database created: " + dataSource);
		}
		catch (IOException e)
		{
			LOG.error("Error while creating connection");
		}
	}

	public static Connection getConnection()
	{
		Connection connection = null;

		try
		{
			connection = dataSource.getConnection();
		}
		catch (SQLException e)
		{
			LOG.error("Error while connection creation", e);
		}
		return connection;
	}
}
