package com.aquent.service;

import com.aquent.entity.Order;
import com.aquent.repository.FileRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    final static Logger logger = Logger.getLogger(FileService.class);

    public void fileSorter(String inputFilepath, String outputFilePath) {
        logger.info("In FileServie fileSorter method");
        List<Order> orders = fileRepository.readInputFromFile(inputFilepath);
        Collections.sort(orders);
        fileRepository.writeOutputToFile(outputFilePath, orders);
    }
}
