package com.demo.manju.sms_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView num2,sms2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){

            String address = bundle.getString("number");
            String message = bundle.getString("message");

            num2 = (TextView) findViewById(R.id.num1);
            sms2 = (TextView) findViewById(R.id.sms1);

            num2.setText("Message From : "+address);
            sms2.setText("Message "+message);

        }
    }
}
