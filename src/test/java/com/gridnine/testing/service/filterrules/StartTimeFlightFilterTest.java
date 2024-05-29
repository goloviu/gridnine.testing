package com.gridnine.testing.service.filterrules;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightFilter;
import com.gridnine.testing.util.FlightBuilder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StartTimeFlightFilterTest {
    private List<Flight> createExpectFlights() {
        List<Flight> resultFlights = new ArrayList<>();
        List<Flight> flights = FlightBuilder.createFlights();

        resultFlights.add(flights.get(0));
        resultFlights.add(flights.get(1));
        resultFlights.add(flights.get(3));
        resultFlights.add(flights.get(4));
        resultFlights.add(flights.get(5));
        return resultFlights;
    }

    private List<Flight> createFlights() {
        return FlightBuilder.createFlights();
    }

    @Test
    void filter() {
        // given
        List<Flight> expectFlights = createExpectFlights();
        List<Flight> flights = createFlights();
        FlightFilter filter = new StartTimeFlightFilter();
        // do
        List<Flight> result = flights.stream()
                .filter(filter::filter)
                .collect(Collectors.toList());
        // expect
        for (int i = 0; i < expectFlights.size(); i++) {
            assertEquals(expectFlights.get(i).toString(), result.get(i).toString(), "Результат не совпадает");
        }
    }
}