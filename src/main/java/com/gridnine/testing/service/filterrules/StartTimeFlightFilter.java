package com.gridnine.testing.service.filterrules;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.FlightFilter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Фильтр, исключающий вылеты до текущего момента
 */
public class StartTimeFlightFilter implements FlightFilter {
    @Override
    public Boolean filter(final Flight flight) {
        List<Segment> segments = flight.getSegments();

        for (Segment segment : segments) {
            if (segment.getDepartureDate().isBefore(LocalDateTime.now())) {
                return false;
            }
        }
        return true;
    }
}
