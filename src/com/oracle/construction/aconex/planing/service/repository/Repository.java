package com.oracle.construction.aconex.planing.service.repository;

import com.oracle.construction.aconex.planing.exception.repository.SimulationRepositoyException;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    Optional<List<List<T>>> findAll() throws SimulationRepositoyException;
}
