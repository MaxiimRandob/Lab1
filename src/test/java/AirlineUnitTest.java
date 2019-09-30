import com.lab1.client.Airline;
import com.lab1.Interfaces.Airplane;
import com.lab1.model.An_2;
import com.lab1.model.An_225;
import com.lab1.model.An_24;
import com.lab1.model.Boeing_747;
import com.lab1.model.Boeing_767;
import com.lab1.model.Boeing_787;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class AirlineUnitTest
{
	private Airline airline;

	@Test
	public void shouldAddAirplaneIntoAirline()
	{
		airline = new Airline();
		Airplane airplane = new An_2();
		airline.addAirplane(airplane);
		assertTrue(airline.getAirplanes().contains(airplane));
	}

	@Test
	public void shouldAddCorrectAirplaneIntoAirline()
	{
		airline = new Airline();
		Airplane airplane = new An_2();
		airline.addAirplane(airplane);
		assertEquals(airplane.getName(), "An-2");
	}

	@Test
	public void shouldReturnCorrectTotalCapacity()
	{
		airline = new Airline();
		Airplane airplane1 = new An_2();
		Airplane airplane2 = new An_24();
		airline.addAirplane(airplane1);
		airline.addAirplane(airplane2);

		assertEquals(airplane1.getCapacity() + airplane2.getCapacity(), airline.getTotalCapacity());
	}

	@Test
	public void shouldReturnCorrectTotalCarryingCapacity()
	{
		airline = new Airline();
		Airplane airplane1 = new An_2();
		Airplane airplane2 = new An_24();
		airline.addAirplane(airplane1);
		airline.addAirplane(airplane2);

		assertEquals(airplane1.getCarryingCapacity() + airplane2.getCarryingCapacity(), airline.getTotalCarryingCapacity());
	}

	@Test
	public void shouldReturnCorrectlySortedByFlyRangeList()
	{
		airline = new Airline();
		Airplane airplane1 = new Boeing_747();
		Airplane airplane2 = new Boeing_787();
		airline.addAirplane(airplane2);
		airline.addAirplane(airplane1);
		assertNotEquals(airline.getAirplanes().stream().findFirst().get(), airline.getAirplanesSortedByRangeOfFlight().stream().findFirst().get());
	}

	@Test
	public void shouldFillSinglyWithEveryKindOfAirplane()
	{
		airline = new Airline();
		Airplane airplane1 = new Boeing_747();
		Airplane airplane2 = new Boeing_787();
		Airplane airplane3 = new Boeing_767();
		Airplane airplane4 = new An_24();
		Airplane airplane5 = new An_2();
		Airplane airplane6 = new An_225();

		airline.fillAirline();
		assertEquals(airline.getTotalCapacity(),
					 (airplane1.getCapacity()
						 + airplane2.getCapacity())
						 + airplane3.getCapacity()
						 + airplane4.getCapacity()
						 + airplane5.getCapacity()
						 + airplane6.getCapacity());
	}
}
