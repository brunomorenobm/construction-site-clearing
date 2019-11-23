package com.oracle.construction.aconex.planing.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileRead {
    public static Stream<String> readFile (String fileName) throws IOException{
        return Files.lines(Paths.get(fileName));
    }
}