/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kmercount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.SparkConf;

/**
 *
 * @author Maxim
 */
public class FastQFileProcessor {
    KMerProcessing kmering = new KMerProcessing();
    String appName = "k-mer Counter";
    String master = "mesos://127.0.0.1:5050";
    
    public void fastQParser() throws FileNotFoundException, IOException {

        SparkConf conf = new SparkConf().setAppName(appName).setMaster(master);
        JavaSparkContext sc = new JavaSparkContext(conf);
        FileWriter f = new FileWriter(new File("sequenceCollection.txt"));
        
        try (BufferedReader br = new BufferedReader(new FileReader("test.fastq"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            
            while (line != null) {
                if(line.startsWith("T") || line.startsWith("A") || line.startsWith("C") || line.startsWith("G")){
                    kmering.kMerCounter(line);
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                } else {
                    line = br.readLine();
                    
                }
            }
            
            String everything = sb.toString();
            f.write(everything);
            System.out.println(everything);
        }
        JavaRDD<String> lines = sc.textFile("sequenceCollection.txt");

    }
    
    public void init() {
        SparkConf conf = new SparkConf().setAppName(appName).setMaster(master);
        JavaSparkContext sc = new JavaSparkContext(conf);
    }

}
