package com.lab1.dao.impl;

import com.lab1.Interfaces.Airplane;
import com.lab1.dao.AirplaneDao;
import com.lab1.entity.AirplaneModel;
import com.lab1.persistance.ConnectionFactory;

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
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM airplane");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				AirplaneModel airplane = new AirplaneModel();
				airplane.setCapacity(resultSet.getInt("capacity"));
				airplane.setCarryingCapacity(resultSet.getInt("carrying_capacity"));
				airplane.setRangeOfFlight(resultSet.getInt("flying_range"));
				airplane.setFuelConsumption(resultSet.getDouble("fuel_consumption"));
				airplane.setName(resultSet.getString("name"));
				list.add(airplane);
				System.out.println(list);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
}
