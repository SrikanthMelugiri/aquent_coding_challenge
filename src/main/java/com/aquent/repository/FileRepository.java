package com.aquent.repository;

import com.aquent.entity.Order;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class FileRepository {

    final static Logger logger = Logger.getLogger(FileRepository.class);

    public List<Order> readInputFromFile(String inputFilepath) {
        List<Order> orders = new ArrayList<>();
        try {
            File file = new File(inputFilepath);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String readLine = bufferedReader.readLine();

            logger.info("Reading file using Buffered Reader");

            while ((readLine = bufferedReader.readLine()) != null && !readLine.isEmpty()) {
                System.out.println(readLine);
                String[] output = readLine.split("\\s+");
                Order order = new Order(output[0], Long.valueOf(output[1]));
                orders.add(order);
            }
            bufferedReader.close();
        } catch (IOException e) {
            logger.error("Exception in reading file");
        } catch (Exception e) {
            logger.error("Exception in reading input file");
            e.printStackTrace();
        }

        return orders;
    }

    public void writeOutputToFile(String outputFilePath, List<Order> orders) {
        try {
            logger.info("Writing output to the file");

            PrintWriter outputStream = new PrintWriter(outputFilePath);
            outputStream.println("Order\t\tTime");
            for (Order order : orders) {
                outputStream.println(order.getItemName() + "\t\t" + dateFormatter(order.getOrderTime()));
            }
            outputStream.close();
        } catch (Exception e) {
            logger.error("Exception in writing output to file");
            e.printStackTrace();
        }
    }

    private String dateFormatter(Long orderTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        return formatter.format(new Date(orderTime*1000));
    }
}
