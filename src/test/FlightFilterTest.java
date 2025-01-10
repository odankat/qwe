package test;

import main.com.gridnine.testing.model.Flight;
import main.com.gridnine.testing.model.Segment;
import main.com.gridnine.testing.filter.ArrivalBeforeDepartureFilter;
import main.com.gridnine.testing.filter.BeforeCurrentTimeFilter;
import main.com.gridnine.testing.filter.GroundTimeFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class FlightFilterTest {
    @Test
    void correctBeforeCurrentTimeFilter() {
        //given
        LocalDateTime date = LocalDateTime.now();
        Flight flight = new Flight(List.of(new Segment(date.plusHours(1), date.plusHours(3))));
        Flight flight1 = new Flight(List.of(new Segment(date.minusHours(1), date.plusHours(2))));
        Flight flight2 = new Flight(List.of(new Segment(date.plusHours(3), date.plusHours(6))));
        List<Flight> flights = List.of(flight, flight1, flight2);

        //when
        List<Flight> expected = List.of(flight, flight2);
        List<Flight> resulting = new BeforeCurrentTimeFilter().filter(flights);


        //then
        Assertions.assertEquals(expected, resulting);


    }

    @Test
    void correctArrivalBeforeDepartureFilter () {
        //given
        LocalDateTime date = LocalDateTime.now();
        Flight flight = new Flight(List.of(new Segment(date.plusHours(1), date.plusHours(3))));
        Flight flight1 = new Flight(List.of(new Segment(date.plusHours(6), date.plusHours(2))));
        Flight flight2 = new Flight(List.of(new Segment(date.plusHours(3), date.plusHours(6))));
        List<Flight> flights = List.of(flight, flight1, flight2);

        //when
        List<Flight> expected = List.of(flight, flight2);
        List<Flight> resulting = new ArrivalBeforeDepartureFilter().filter(flights);

        //then
        Assertions.assertEquals(expected, resulting);

    }

    @Test
    void correctGroundTimeFilter() {
        //given
        LocalDateTime date = LocalDateTime.now();
        Flight flight = new Flight(List.of(new Segment(date.plusHours(1), date.plusHours(3)), new Segment(date.plusHours(4), date.plusHours(7))));
        Flight flight1 = new Flight(List.of(new Segment(date.plusHours(1), date.plusHours(3)), new Segment(date.plusHours(7), date.plusHours(9))));
        Flight flight2 = new Flight(List.of(new Segment(date.plusHours(3), date.plusHours(6))));
        List<Flight> flights = List.of(flight, flight1, flight2);

        //when
        List<Flight> expected = List.of(flight, flight2);
        List<Flight> resulting = new GroundTimeFilter().filter(flights);

        //then
        Assertions.assertEquals(expected,resulting);

    }




}
