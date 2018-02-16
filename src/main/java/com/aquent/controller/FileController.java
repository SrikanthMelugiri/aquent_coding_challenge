package com.aquent.controller;

import com.aquent.service.FileService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    public FileService fileService;

    final static Logger logger = Logger.getLogger(FileController.class);

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void sort(@RequestParam(value = "inputFilePath") String inputFilePath, @RequestParam(value = "outputFilePath") String outputFilePath) {
        logger.info("In FileController sort method");
        if (!StringUtils.isEmpty(inputFilePath) && !StringUtils.isEmpty(outputFilePath)) {
            fileService.fileSorter(inputFilePath, outputFilePath);
        }
    }
}
