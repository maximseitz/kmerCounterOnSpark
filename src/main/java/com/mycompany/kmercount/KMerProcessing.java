/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kmercount;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Maxim
 */
public class KMerProcessing {
    
    /**
     * k-mer length.
     */
    int kmer = 3;
    
    /**
     * Empty Constructor.
     */
    public KMerProcessing(){
        
    }
    
    /**
     * Counts k-mer by a parsed sequence 'seq'.
     * 
     * @param seq
     * @throws IOException 
     */
    public void kMerCounter(String seq) throws IOException {
        FileWriter f = new FileWriter(new File("output"));
        
        int seqLength = seq.length();
        int kmerCount = 0;
        if (seqLength > kmer) {
            for (int i = 0; i < seqLength - kmer + 1; i++) {
                kmerCount++;
                f.write(kmerCount + ": " + seq.substring(i, kmer + i));
                System.out.println(kmerCount + ": " + seq.substring(i, kmer + i));
            }
        } else {
            f.write("else case " + seq);
            System.out.println(seq);
            System.out.println(kmerCount);
        }
        
    }
    
}
