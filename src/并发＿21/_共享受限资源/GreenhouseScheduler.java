package 并发＿21._共享受限资源;

import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by biezhihua on 16-7-17.
 */
public class GreenhouseScheduler {

    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";

    synchronized public String getThermostat() {
        return thermostat;
    }

    synchronized public void setThermostat(String thermostat) {
        this.thermostat = thermostat;
    }

    ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);

    public void scheduler(Runnable event, long delay) {
        scheduler.schedule(event, delay, TimeUnit.MILLISECONDS);
    }

    public void repeat(Runnable event, long initialDelay, long period) {
        scheduler.scheduleAtFixedRate(event, initialDelay, period, TimeUnit.MILLISECONDS);
    }


    class LightOn implements Runnable {

        @Override
        public void run() {
            System.out.println("Turning on lights");
            light = true;
        }
    }

    class LighOff implements Runnable {

        @Override
        public void run() {
            System.out.println("Turning off lights");
            light = false;
        }
    }

    class WaterOn implements Runnable {

        @Override
        public void run() {
            System.out.println("Turning greenhouse water on");
            water = true;
        }
    }

    class WaterOff implements Runnable {
        @Override
        public void run() {
            System.out.println("Turning greenhouse water off");
            water = false;
        }
    }

    class ThermostatNight implements Runnable {
        @Override
        public void run() {
            System.out.println("Thermostat to night setting");
            setThermostat("Night");
        }
    }

    class ThermostatDay implements Runnable {
        @Override
        public void run() {
            System.out.println("Thermostat to day setting");
            setThermostat("Day");
        }
    }


    class Bell implements Runnable {
        @Override
        public void run() {
            System.out.println("Bing!");
        }
    }

    class Terminate implements Runnable {

        @Override
        public void run() {
            System.out.println("Terminating");
            scheduler.shutdownNow();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (DataPoint d : data) {
                        System.out.println(d);
                    }
                }
            }).start();

        }
    }

    static class DataPoint {
        final Calendar time;
        final float temperature;
        final float humidity;

        public DataPoint(Calendar time, float temperature, float humidity) {
            this.time = time;
            this.temperature = temperature;
            this.humidity = humidity;
        }

        @Override
        public String toString() {
            return "DataPoint{" +
                    "time=" + time +
                    ", temperature=" + temperature +
                    ", humidity=" + humidity +
                    '}';
        }
    }

    private Calendar lastTime = Calendar.getInstance();

    {
        lastTime.set(Calendar.MINUTE, 30);
        lastTime.set(Calendar.SECOND, 00);
    }

    private float lastTemp = 65.0F;
    private int tempDirection = +1;
    private float lastHumidity = 50.f;
    private int humidityDirection = 1;
    private Random random = new Random(48);
    List<DataPoint> data = Collections.synchronizedList(new ArrayList<>());

    class CollectData implements Runnable {
        @Override
        public void run() {
            System.out.println("Collecting data");
            lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE) + 30);
            if (random.nextInt(5) == 4) {
                tempDirection = -tempDirection;
            }
            lastTemp = lastTemp + tempDirection * (1.0F + random.nextFloat());
            if (random.nextInt(5) == 4) {
                humidityDirection = -humidityDirection;
            }
            lastHumidity = lastHumidity + humidityDirection * random.nextFloat();

            data.add(new DataPoint((Calendar) lastTime.clone(), lastTemp, lastHumidity));
        }
    }


    public static void main(String[] args) {
        GreenhouseScheduler scheduler = new GreenhouseScheduler();
        scheduler.scheduler(scheduler.new Terminate(), 5000);

    }


}

