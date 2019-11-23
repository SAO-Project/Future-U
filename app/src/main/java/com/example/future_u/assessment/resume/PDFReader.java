package com.example.future_u.assessment.resume;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFReader{
    String name;
// Create instance with file directory
    public PDFReader(String name){
        this.name = name;
    }
    public String[] read(){
        //    TODO: remove static pdf pathname
        try{
//        loading existing pdf document
            File file = new File("exampleHere.pdf");
            PDDocument document = PDDocument.load(file);
//        instantiate TextStripperClass
            PDFTextStripper pdfStripper = new PDFTextStripper();
//        read text from PDF
            String text = pdfStripper.getText(document);
//        close the document (finish)
            document.close();

            return stringToArray(text);
        }
        catch(IOException e){
            System.err.println("Something wrong happened");
        }
        return null;
    }
//    converts large string into array of words
    public String[] stringToArray(String text){
//        \\W+ includes different separators in ASCII only
        String[] tokens = text.split("\\W+");
        return tokens;
    }
}
