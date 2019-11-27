package com.oracle.construction.aconex.simulation.service.repository;

import com.oracle.construction.aconex.simulation.exception.repository.SimulationRepositoyException;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    Optional<List<List<T>>> findAll() throws SimulationRepositoyException;
}
