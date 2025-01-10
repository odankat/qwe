package main.com.gridnine.testing.filter;
import main.com.gridnine.testing.model.Flight;

import java.util.List;

public interface FlightFilter {
    public List<Flight> filter(List<Flight> flights);


}
