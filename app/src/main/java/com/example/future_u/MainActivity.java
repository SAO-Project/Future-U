package com.example.future_u;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.future_u.assessment.resume.PDFReader;
import com.tom_roush.pdfbox.util.PDFBoxResourceLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    * initializes libraries for pdf reading
    *   it only is done one at the start of application
     */
    @Override
    protected void onStart() {
        super.onStart();
        setup();
    }

    public void setup(){
//        highly recommended to do before using libraries
        PDFBoxResourceLoader.init(getApplicationContext());

        PDFReader reader = new PDFReader();
        reader.read("hello.pdf");
    }
}
