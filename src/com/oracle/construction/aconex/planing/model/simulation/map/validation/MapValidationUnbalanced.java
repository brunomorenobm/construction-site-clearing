package com.oracle.construction.aconex.planing.model.simulation.map.validation;

import com.oracle.construction.aconex.planing.exception.map.MapSimulationException;
import com.oracle.construction.aconex.planing.exception.map.UnbalancedMapSimulationException;
import com.oracle.construction.aconex.planing.model.simulation.map.block.Block;

import java.util.Comparator;
import java.util.List;

public class MapValidationUnbalanced implements MapValidation {
    @Override
    public boolean validate(List<List<Block>> blocks) throws MapSimulationException {
        long min = blocks.stream().min(Comparator.comparing(line -> line.size())).get().size();
        long max = blocks.stream().max(Comparator.comparing(line -> line.size())).get().size();

        if (min != max) {
            throw new UnbalancedMapSimulationException();
        }
        return true;
    }
}
