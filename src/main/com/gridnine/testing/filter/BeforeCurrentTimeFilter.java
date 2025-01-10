package main.com.gridnine.testing.filter;

import main.com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BeforeCurrentTimeFilter implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        //отсеиваем полеты, у которых дата вылета < текущий даты
        LocalDateTime time = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isAfter(time)))
                .collect(Collectors.toList());
    }
}
