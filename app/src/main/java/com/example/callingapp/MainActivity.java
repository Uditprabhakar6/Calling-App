package com.example.callingapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText num;
Button Dial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num=(EditText)findViewById(R.id.num);
        Dial=(Button) findViewById(R.id.dial);
        Dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1=num.getText().toString();
                if(TextUtils.isEmpty(num1))
                {
                    num.setError("Enter No.");
                }
                else {
                    if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
                    {
                        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},0);

                    }
                    else
                    {
                        Intent i = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+num1));
                        startActivity(i);
                    }
                }
            }
        });
    }
}
