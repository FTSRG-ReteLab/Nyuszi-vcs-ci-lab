package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {
    TrainController mockTC;
    TrainUser mockTU;
    TrainSensorImpl trainSensor;

    @Before
    public void before() {
        mockTC = mock(TrainController.class);
        mockTU = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(mockTC,mockTU);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
    }
    @Test
	public void checkSpeedLimit(){
	assertEquals(10,10);
  }

    @Test
    public void lowerMargin(){
        trainSensor.overrideSpeedLimit(-1);
        verify(mockTU,times(1)).setAlarmState(true);
    }

    @Test
    public void upperMargin(){
        trainSensor.overrideSpeedLimit(501);
        verify(mockTU,times(1)).setAlarmState(true);
    }

    public void relativeMargin(){
        trainSensor.overrideSpeedLimit(4);
        verify(mockTU,times(1)).setAlarmState(true);
    }

    @Test
    public void betweenMargin(){
        trainSensor.overrideSpeedLimit(250);
        verify(mockTU,times(0)).setAlarmState(false);
    }




}
