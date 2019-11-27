package com.oracle.construction.aconex.simulation.service.repository;

import com.oracle.construction.aconex.simulation.exception.repository.ErrorReadingMapFileException;
import com.oracle.construction.aconex.simulation.exception.repository.FileNotFoundException;
import com.oracle.construction.aconex.simulation.service.infra.FileRead;
import com.oracle.construction.aconex.simulation.domain.simulation.map.Coordinate;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.Block;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.BlockFactory;
import com.oracle.construction.aconex.simulation.domain.simulation.map.block.BlockType;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class BlockRepository implements Repository<Block> {


    public String fileSource;

    public BlockRepository(String fileSource) throws FileNotFoundException {
        // Validate input File
        File file = new File(fileSource);
        if (!file.exists()) {
            throw new FileNotFoundException(fileSource);
        }
        this.fileSource = fileSource;
    }

    public Optional<List<List<Block>>> findAll() throws ErrorReadingMapFileException {

        AtomicInteger index = new AtomicInteger();

        List<List<Block>> blocks;

        try {
            blocks = FileRead
                    .readFile(this.fileSource)
                    .map(line -> parseLine(index.getAndIncrement(), line)
                    ).collect(Collectors.toList());
        } catch (IOException ex) {
            throw new ErrorReadingMapFileException(fileSource);
        }

        return Optional.ofNullable(blocks);
    }

    private List<Block> parseLine(int rowIndex, String line) {
        BlockFactory blockFactory = new BlockFactory();
        List<Block> row = new Vector();
        AtomicInteger index = new AtomicInteger();
        for (char character : line.toCharArray()) {
            // Create a new coordinate object to query the position of the block
            Coordinate coordinate = new Coordinate(index.getAndIncrement(), rowIndex);

            // Add new Block to the map
            Block block = blockFactory.createBlock(BlockType.valueOf(String.valueOf(character)));
            block.setCoordinate(coordinate);
            row.add(block);
        }
        return row;
    }

}

