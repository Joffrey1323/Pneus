package fr.unilim.iut.PressionPneus;

public class Alarm
{
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;
    
    private Sensor sensor;
    private SafetyRange safetyRange;
    private boolean alarmOn;

    public Alarm(Sensor sensor,double lowPreasureThreshold, double highPreasureThreshold){
    	this.sensor=sensor;
    	this.alarmOn=false;
    	this.safetyRange=new SafetyRange(lowPreasureThreshold,highPreasureThreshold);
    }

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
