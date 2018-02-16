package com.aquent.service;

import com.aquent.entity.Order;
import com.aquent.repository.FileRepository;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FileServiceUnitTest {

    @InjectMocks
    FileService fileService;

    @Mock
    FileRepository fileRepository;

    @Test
    public void test_repository_called_twice() {
        String inputFilePath = "someInputPath";
        String outputFilePath = "someOutputPath";

        fileService.fileSorter(inputFilePath, outputFilePath);
        verify(fileRepository, times(1)).readInputFromFile(eq(inputFilePath));
        verify(fileRepository, times(1)).writeOutputToFile(eq(outputFilePath), anyList());
    }

    @Test
    public void test_respository_returning_orders_from_inputfile() {

        ArgumentCaptor<List<Order>> arg = ArgumentCaptor.forClass(List.class);

        String inputFilePath = "someInputPath";
        String outputFilePath = "someOutputPath";

        Order order1 = new Order("Pizza", new Long(1477319087));
        Order order2 = new Order("Meat", new Long(1477319087));
        Order order3 = new Order("Pizza", new Long(1477319086));
        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        when(fileRepository.readInputFromFile(eq(inputFilePath))).thenReturn(orders);

        fileService.fileSorter(inputFilePath, outputFilePath);

        verify(fileRepository, times(1)).writeOutputToFile(eq(outputFilePath), arg.capture());

        Assert.assertEquals(3, arg.getValue().size());
        Assert.assertEquals("Meat", arg.getValue().get(0).getItemName()); // since it will contain sorted output, Meat will be the first item
        Assert.assertEquals(1477319086, arg.getValue().get(1).getOrderTime().longValue()); // since it will contain sorted output, Pizza with former order time will be the second item
    }
}
