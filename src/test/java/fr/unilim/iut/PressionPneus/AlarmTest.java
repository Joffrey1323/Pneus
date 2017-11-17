package fr.unilim.iut.PressionPneus;

import junit.framework.TestCase;

import junit.framework.TestCase;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlarmTest extends TestCase {

	public void testIsAlarmOnAfterPressureTooLow() {
		
		Sensor mockedSensor = mock(Sensor.class);
		when(mockedSensor.popNextPressurePsiValue()).thenReturn(16.0);
		Alarm alarm = new Alarm(mockedSensor,17.0,21.0);
		alarm.check();
		assertEquals(alarm.isAlarmOn(), true);
	}
	
	public void testIsAlarmOnAfterPressureTooHigh() {
		Sensor mockedSensor = mock(Sensor.class);
		when(mockedSensor.popNextPressurePsiValue()).thenReturn(22.0);
		Alarm alarm = new Alarm(mockedSensor,17.0,21.0);
		alarm.check();
		assertEquals(alarm.isAlarmOn(), true);
	}
	
	public void testIsAlarmOffAfterNormalPressure() {
		Sensor mockedSensor = mock(Sensor.class);
		when(mockedSensor.popNextPressurePsiValue()).thenReturn(18.0);
		Alarm alarm = new Alarm(mockedSensor,17.0,21.0);
		alarm.check();
		assertEquals(alarm.isAlarmOn(), false);
	}
	
	public void testIsAlarmAlwaysOn() {
		Sensor mockedSensor = mock(Sensor.class);
		when(mockedSensor.popNextPressurePsiValue()).thenReturn(22.0);
		Alarm alarm = new Alarm(mockedSensor,17.0,21.0);
		alarm.check();
		assertEquals(alarm.isAlarmOn(), true);
		when(mockedSensor.popNextPressurePsiValue()).thenReturn(18.0);
		alarm.check();
		assertEquals(alarm.isAlarmOn(), true);
	}

}
