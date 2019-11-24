package com.example.future_u.assessment.resume;

import android.content.res.AssetManager;
import android.util.Log;

import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.text.PDFTextStripper;

import java.io.IOException;


public class PDFReader {
    AssetManager assetManager;
    public String[] parse(String pathName){
        return stringToArray(read(pathName));

    }

    public String read(String pathName){
        String parsedText = null;
        PDDocument document = null;
        try {
//            loads document
            document = PDDocument.load(assetManager.open(pathName));
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
}
