package com.pachacama.examen.labcalificado_pachacama.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.pachacama.examen.labcalificado_pachacama.R;

public class DetailActivity extends AppCompatActivity {


    private TextView name;

    private TextView info;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = findViewById(R.id.name);

        info = findViewById(R.id.info);

        name.setText(this.getIntent().getExtras().getString("name"));
        info.setText(this.getIntent().getExtras().getString("info"));

    }
}
