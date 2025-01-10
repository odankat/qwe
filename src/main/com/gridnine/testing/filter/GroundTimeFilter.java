package main.com.gridnine.testing.filter;
import main.com.gridnine.testing.model.Flight;
import main.com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class GroundTimeFilter implements FlightFilter {
    public  List<Flight> filter(List<Flight> flights) {
        // отсеиваем полеты, у которых сумарное время на земле между полетами > 2 часов
        return flights.stream().
                filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    if (segments.size() < 2) {
                        return true;
                    }
                    long grundTime = 0;
                    for (int i = 0; i < segments.size() - 1; i++) {
                        LocalDateTime arrival = segments.get(i).getArrivalDate();
                        LocalDateTime nextDeparture = segments.get(i + 1).getDepartureDate();
                        grundTime += Duration.between(arrival, nextDeparture).toHours();
                    }
                    return grundTime <= 2;
                })
                .collect(Collectors.toList());
    }


}