package com.example.future_u.assessment;

import android.util.Log;

import com.example.future_u.assessment.resume.PDFReader;
import com.example.future_u.assessment.resume.PercentageOfClassification;

public class Assessment {
    private PercentageOfClassification percentageOfClassification;
    private String path, major;
    private Double gpa;

    public Assessment(String path, String major, Double gpa) {
        this.path = path;
        this.major = major;
        this.gpa = gpa;
        this.percentageOfClassification = new PercentageOfClassification();
        runResumeScan();
    }

    private void runResumeScan() {
        PDFReader pdfReader = new PDFReader();
        String[] words = pdfReader.parse(this.path);

        if (this.percentageOfClassification.runAll(words)) {
            Log.i("percentageOfClass...", "Ran Successful");
        }
    }

    public PercentageOfClassification getPercentageOfClassification() {
        return this.percentageOfClassification;
    }
}
