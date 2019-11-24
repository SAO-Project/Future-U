package com.example.future_u;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

import com.example.future_u.assessment.resume.PDFReader;
import com.example.future_u.assessment.resume.PercentageOfClassification;
import com.tom_roush.pdfbox.util.PDFBoxResourceLoader;

public class MainActivity extends AppCompatActivity {
    //Views
    Intent myFileIntent;
    Button uploadResume;
    TextView resumePath;

    //Attributes
    public File resume;

    public void uploadResume(View view) {
        Log.i("uploadResume", "STARTED");
        myFileIntent = new Intent(Intent.ACTION_GET_CONTENT);
        myFileIntent.setType("*/*");
        startActivityForResult(myFileIntent, 10);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uploadResume = findViewById(R.id.uploadResume);
        resumePath = findViewById(R.id.resumePath);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.i("requestCode", requestCode + "");
        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK) {
                    String path = data.getData().getPath();
                    Log.i("path", path);
                    resumePath.setText(path);
                    PDFReader reader = new PDFReader();
                    String[] words = reader.parse(path);
                    PercentageOfClassification percentageOfClassification = new PercentageOfClassification();
                    percentageOfClassification.parsePdf(words);
                    percentageOfClassification.insertPercentageOfClassifications();
                    HashMap<String, Double> hashMap = percentageOfClassification.getPercentageOfClassification();
                    Log.i("Hash Table", hashMap.toString());

                }
                break;
        }

    }
}
