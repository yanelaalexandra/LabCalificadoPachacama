package com.pachacama.examen.labcalificado_pachacama.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.pachacama.examen.labcalificado_pachacama.R;

public class DetailActivity extends AppCompatActivity {


    private TextView name;

    private TextView info;

    private String numbercall;

    private String urlw;

    private TextView image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = findViewById(R.id.name);

        info = findViewById(R.id.info);

        image = findViewById(R.id.imglogo);

        name.setText(this.getIntent().getExtras().getString("name"));
        info.setText(this.getIntent().getExtras().getString("info"));



        image.setText(this.getIntent().getExtras().getString("logo"));
        numbercall=this.getIntent().getExtras().getString("phone");
        urlw=this.getIntent().getExtras().getString("url");


    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        switch (requestCode) {
            case PERMISSIONS_REQUEST: {
                if (permissions[0].equals(Manifest.permission.CALL_PHONE)) {
                    if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                        openCallApplication();
                    }else{
                        Toast.makeText(this, "CALL_PHONE permissions declined!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }


    private static final int PERMISSIONS_REQUEST = 100;

    public void call(View view){

        // Check permission (Api 22 check in Manifest, Api 23 check by requestPermissions)
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // Dont have permission => request one or many permissions (String[])
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_REQUEST);
        }else {
            // Have permission
            openCallApplication();
        }
    }

    public void openCallApplication(){
        String phoneNumber = numbercall;
        if(phoneNumber.isEmpty()){
            Toast.makeText(this, "Phone number required!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+phoneNumber));

        // Is necesary to check permission again before startActivity
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
            startActivity(intent);
    }

    public void openWebsite(View view){
        String urlweb = urlw;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("url:"+urlweb));
        startActivity(intent);
    }



}
