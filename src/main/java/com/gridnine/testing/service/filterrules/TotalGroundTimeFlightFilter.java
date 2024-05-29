package com.gridnine.testing.service.filterrules;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.FlightFilter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Фильтр, исключающий полеты превышающие 2 часа на земле между сегментами
 */
public class TotalGroundTimeFlightFilter implements FlightFilter {
    @Override
    public Boolean filter(Flight flight) {
        List<Segment> segments = flight.getSegments();

        if (segments.size() <= 1) {
            return true;
        }

        for (int i = 0; i < (segments.size() - 1); i++) {
            if (isMoreThan2HoursOnGround(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate())) {
                return false;
            }
        }
        return true;
    }

    private boolean isMoreThan2HoursOnGround(final LocalDateTime arrivalDateTime, final LocalDateTime departureDateTime) {
        Duration duration = Duration.between(arrivalDateTime, departureDateTime);

        if (duration.toHours() > 2) {
            return true;
        }
        return false;
    }
}
