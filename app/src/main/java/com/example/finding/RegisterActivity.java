package com.example.finding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText instagram = findViewById(R.id.instagramLink);
        TextView errorLink = findViewById(R.id.errorInsta);
        TextView next = findViewById(R.id.nextStageOfRegistration);
        TextView errorPhoneNumber = findViewById(R.id.errorPhone);
        EditText phone = findViewById(R.id.phoneNumber);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable instagramLink = (instagram.getText());
                Editable phoneNumber = phone.getText();
                if(instagramLink.equals("")) {
                    errorLink.setText("I still do not have your instagram link");
                    errorLink.setTextColor(Color.RED);
                    Intent registerIntent = new Intent(
                            getApplicationContext(), RegisterActivity.class
                    );
                    startActivity(registerIntent);
                } else if (phoneNumber.equals("")) {
                    errorPhoneNumber.setText("I still do not know your phone number");
                    errorPhoneNumber.setTextColor(Color.RED);
                    Intent registerIntent = new Intent(
                            getApplicationContext(), RegisterActivity.class
                    );
                    startActivity(registerIntent);

                } else{
                    Intent verifyIntent = new Intent(
                            getApplicationContext(), VerificationActivity.class
                    );
                    startActivity(verifyIntent);
                }
            }
        });

    }
}