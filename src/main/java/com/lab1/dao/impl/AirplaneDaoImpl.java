package com.lab1.dao.impl;

import com.lab1.Interfaces.Airplane;
import com.lab1.dao.AirplaneDao;
import com.lab1.persistance.ConnectionFactory;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneDaoImpl implements AirplaneDao
{
	@Override
	public List<Airplane> getAirplanes()
	{
		List<Airplane> list = new ArrayList<>();
		Connection connection = ConnectionFactory.getConnection();
		try(Connection connection1 = ConnectionFactory.getConnection())
		{
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM 'airplanes'");
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				list.add(new Airplane() {
					@Override
					public int getCapacity()
					{
						try
						{
							return resultSet.getInt("capacity");
						}
						catch (SQLException e)
						{
							e.printStackTrace();
						}
						return 0;
					}

					@Override
					public int getCarryingCapacity()
					{
						try
						{
							return resultSet.getInt("capacity");
						}
						catch (SQLException e)
						{
							e.printStackTrace();
						}
						return 0;
					}

					@Override
					public int getRangeOfFlight()
					{
						try
						{
							return resultSet.getInt("capacity");
						}
						catch (SQLException e)
						{
							e.printStackTrace();
						}
						return 0;
					}

					@Override
					public double getFuelConsumption()
					{
						try
						{
							return resultSet.getInt("capacity");
						}
						catch (SQLException e)
						{
							e.printStackTrace();
						}
						return 0;
					}

					@Override
					public String getName()
					{
						try
						{
							return resultSet.getString("capacity");
						}
						catch (SQLException e)
						{
							e.printStackTrace();
						}
						return null;
					}
				});
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
}
