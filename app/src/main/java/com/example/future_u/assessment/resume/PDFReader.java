package com.example.future_u.assessment.resume;

import android.content.res.AssetManager;

import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.text.PDFTextStripper;

import java.io.IOException;

public class PDFReader {
    AssetManager assetManager;

    public String read(String pathName){
        String parsedText = null;
        PDDocument document = null;
        try {
            document = PDDocument.load(assetManager.open(pathName));
        } catch(IOException e) {
            e.printStackTrace();
        }

        try {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            pdfStripper.setStartPage(0);
            pdfStripper.setEndPage(1);
            parsedText = pdfStripper.getText(document);

            return parsedText;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (document != null) document.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
