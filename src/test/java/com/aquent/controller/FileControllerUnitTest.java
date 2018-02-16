package com.aquent.controller;

import com.aquent.service.FileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.eq;

@RunWith(MockitoJUnitRunner.class)
public class FileControllerUnitTest {

    @InjectMocks
    FileController fileController;

    @Mock
    FileService fileService;

    @Test
    public void test_inputFilePath_isNotNull() {
        fileController.sort(null, "someOutputFilePath");
        verify(fileService, times(0)).fileSorter(anyString(), anyString());
    }

    @Test
    public void test_outputFilePath_isNotNull() {
        fileController.sort("someInputFilePath", null);
        verify(fileService, times(0)).fileSorter(anyString(), anyString());
    }

    @Test
    public void test_service_is_called_once() {
        fileController.sort("someInputPath", "someOutputPath");
        verify(fileService, times(1)).fileSorter(eq("someInputPath"), eq("someOutputPath"));
    }
}
