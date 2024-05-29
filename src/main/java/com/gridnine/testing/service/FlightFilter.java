package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

public interface FlightFilter {

    Boolean filter(final Flight flight);
}
