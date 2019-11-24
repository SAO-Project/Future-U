package com.example.future_u.assessment.resume;

import android.content.res.AssetManager;
import android.util.Log;

import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
/*
* create instance to read pdf
*   - use PDFReader.read(pathName) to read pdf
 */
public class PDFReader {
    AssetManager assetManager;
    public String[] parse(String pathName){
        return stringToArray(read(pathName));
    }
    /*
    * reads document and returns large string of data
     */
    public String read(String pathName){
        String parsedText = null;
        PDDocument document = new PDDocument();
        try {
//            loads document
            Log.i("path", pathName);
            document = PDDocument.load(new File(pathName));
        } catch(IOException e) {
            Log.e("PdfBox-Android-Sample", "Exception thrown while loading document to strip", e);
        }

//        reads text
        try {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            pdfStripper.setStartPage(0);
            pdfStripper.setEndPage(1);
            parsedText = pdfStripper.getText(document);

            return parsedText;
        }
        catch (IOException e)
        {
            Log.e("PdfBox-Android-Sample", "Exception thrown while stripping text", e);
        } finally {
            try {
                if (document != null) document.close();
            }
            catch (IOException e)
            {
                Log.e("PdfBox-Android-Sample", "Exception thrown while closing document", e);
            }
        }
        return null;

    }
    /*
    * converts large string to array of words
    *   -use to compare similarities
     */
    public String[] stringToArray(String text){
        String[] words = text.split("\\W+");
        return words;
    }
}
