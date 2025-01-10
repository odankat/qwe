package main.com.gridnine.testing.filter;
import main.com.gridnine.testing.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalBeforeDepartureFilter implements FlightFilter{
    @Override
    public List<Flight> filter(List<Flight> flights) {
        // отсеиваем полеты, у которрых дата прилета < даты вылета
        return flights.stream().
                filter(flight -> flight.getSegments().stream().
                        allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
