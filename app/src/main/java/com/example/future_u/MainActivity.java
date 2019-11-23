package com.example.future_u;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tom_roush.pdfbox.util.PDFBoxResourceLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
        setup();
    }

    public void setup(){
        PDFBoxResourceLoader.init(getApplicationContext());
    }
}
