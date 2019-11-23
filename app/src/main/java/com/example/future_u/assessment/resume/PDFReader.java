package com.example.future_u.assessment.resume;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFReader{
    /*
    * This method reads pdf document and strips all of the words into a string
    *   returns pdf as string
     */
    public String read(String pathName){
        try{
//        loading existing pdf document
            File file = new File(pathName);
            PDDocument document = PDDocument.load(file);
//        instantiate TextStripperClass
            PDFTextStripper pdfStripper = new PDFTextStripper();
//        read text from PDF
            String text = pdfStripper.getText(document);
//        close the document (finish)
            document.close();

            System.out.println(text.substring(0, 10));
            return text;
        }
        catch(IOException e){
            System.err.println("File cannot be found");
        }
        return null;
    }
}
