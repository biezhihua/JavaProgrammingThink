package 类型信息_14;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by biezhihua on 16-6-22.
 */
public class Part {

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Factory<? extends Part>> partFactories = new ArrayList<>();

    static {
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }

    private static Random random = new Random();

    public static Part createRandom() {
        return partFactories.get(random.nextInt(partFactories.size())).create();
    }
}

class Filter extends Part {

}

class Belt extends Part {

}

class FuelFilter extends Filter {

    public static class Factory implements 类型信息_14.Factory<FuelFilter> {
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {

    public static class Factory implements 类型信息_14.Factory<AirFilter> {
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter {

    public static class Factory implements 类型信息_14.Factory<CabinAirFilter> {
        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter {

    public static class Factory implements 类型信息_14.Factory<OilFilter> {
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class FanBelt extends Belt {

    public static class Factory implements 类型信息_14.Factory<FanBelt> {
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}


class GeneratorBelt extends Belt {

    public static class Factory implements 类型信息_14.Factory<GeneratorBelt> {
        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {

    public static class Factory implements 类型信息_14.Factory<PowerSteeringBelt> {
        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}

class RegisteredFactories {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }

}