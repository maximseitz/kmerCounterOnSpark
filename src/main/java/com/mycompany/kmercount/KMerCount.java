/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.kmercount;

import java.io.IOException;


/**
 *
 * @author maxim
 */
public class KMerCount {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        FastQFileProcessor fqPro = new FastQFileProcessor();
        fqPro.init();
        fqPro.fastQParser();
    }

    
    
    
    

}
