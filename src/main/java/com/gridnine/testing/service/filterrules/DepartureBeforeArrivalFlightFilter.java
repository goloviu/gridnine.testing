package com.gridnine.testing.service.filterrules;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.FlightFilter;

import java.util.List;

/**
 * Фильтр, исключающий полеты, в которых сегмент с датой прилета раньше даты вылета
 */
public class DepartureBeforeArrivalFlightFilter implements FlightFilter {
    @Override
    public Boolean filter(Flight flight) {
        List<Segment> segments = flight.getSegments();

        for (Segment segment : segments) {
            if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                return false;
            }
        }
        return true;
    }
}
