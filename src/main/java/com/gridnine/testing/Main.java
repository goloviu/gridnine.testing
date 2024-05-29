package com.gridnine.testing;

import com.gridnine.testing.controller.SearchContext;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightFilter;
import com.gridnine.testing.util.FlightBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Однопотокове решение задачи
        List<Flight> flights = FlightBuilder.createFlights();
        List<FlightFilter> filters = SearchContext.createFilters();

        filters.stream()
                .peek(filter -> System.out.printf("%nОбработка правила фильтрации: %s%n",
                        filter.getClass().getSimpleName()))
                .map(filter -> flights.stream()
                        .filter(filter::filter)
                        .peek(System.out::println)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}