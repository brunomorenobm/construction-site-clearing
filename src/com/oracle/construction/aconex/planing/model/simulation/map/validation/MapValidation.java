package com.oracle.construction.aconex.planing.model.simulation.map.validation;

import com.oracle.construction.aconex.planing.exception.map.MapSimulationException;
import com.oracle.construction.aconex.planing.model.simulation.map.block.Block;

import java.util.List;

public interface MapValidation {

    boolean validate(List<List<Block>> blocks) throws MapSimulationException;
}
