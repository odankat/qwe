package main;

import main.com.gridnine.testing.FlightBuilder;
import main.com.gridnine.testing.filter.ArrivalBeforeDepartureFilter;
import main.com.gridnine.testing.filter.BeforeCurrentTimeFilter;
import main.com.gridnine.testing.filter.GroundTimeFilter;

public class Main {
    public static void main(String[] args) {
        var flights = FlightBuilder.createFlights();
        System.out.println("No filter flights = " + flights);
        System.out.println("BeforeCurrentTimeFilter = " + new BeforeCurrentTimeFilter().filter(flights));
        System.out.println("FlightFilterTest = " + new ArrivalBeforeDepartureFilter().filter(flights));
        System.out.println("GroundTimeFilter = " + new GroundTimeFilter().filter(flights));


    }
}