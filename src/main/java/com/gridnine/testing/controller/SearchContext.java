package com.gridnine.testing.controller;

import com.gridnine.testing.service.FlightFilter;
import com.gridnine.testing.service.filterrules.DepartureBeforeArrivalFlightFilter;
import com.gridnine.testing.service.filterrules.StartTimeFlightFilter;
import com.gridnine.testing.service.filterrules.TotalGroundTimeFlightFilter;

import java.util.List;

/**
 * Данный класс симулирует получение правил от клиента.
 */
public class SearchContext {

    public static List<FlightFilter> createFilters() {
        return List.of(new DepartureBeforeArrivalFlightFilter(),
                new StartTimeFlightFilter(),
                new TotalGroundTimeFlightFilter());
    }
}
