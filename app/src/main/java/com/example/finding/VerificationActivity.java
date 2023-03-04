package com.example.finding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VerificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        EditText verify = findViewById(R.id.verification_code);
        TextView submit = findViewById(R.id.last_stage);
        TextView verifyText = findViewById(R.id.verify_text);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String verifyCode = String.valueOf(verify.getText());
                if (verifyCode.equals("475896")){
                    verifyText.setText("Verification code is right");
                    verifyText.setTextColor(Color.GREEN);
                    Intent registerLastPageIntent = new Intent(
                            getApplicationContext(), RegisterLastStageActivity.class
                    );
                    startActivity(registerLastPageIntent);
                }else {
                    verifyText.setText("Verification code is wrong");
                    verifyText.setTextColor(Color.RED);
                    Intent reVerify = new Intent(
                            getApplicationContext(), VerificationActivity.class
                    );
                    startActivity(reVerify);
                }
            }
        });
    }
}