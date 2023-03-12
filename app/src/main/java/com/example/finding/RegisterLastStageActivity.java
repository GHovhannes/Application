package com.example.finding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import database.UsersEntity;

public class RegisterLastStageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_last_stage);
        EditText pass = findViewById(R.id.editTextTextPassword);
        EditText username = findViewById(R.id.create_username);
        EditText confirmPassword = findViewById(R.id.confirm_password);
        TextView isPasswordCorrect = findViewById(R.id.confirm_password_text);
        TextView submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = String.valueOf(pass.getText());
                String confirmPass = String.valueOf(confirmPassword.getText());
                if(!password.equals(confirmPass)){
                    isPasswordCorrect.setText("Passwords do not match");
                    isPasswordCorrect.setTextColor(Color.RED);
                }else{
                DatabaseFiller db = new DatabaseFiller();
                db.run();
                Intent profilePageIntent = new Intent(
                        getApplicationContext(), ProfilePageActivity.class
                );
                startActivity(profilePageIntent);
                }
            }
        });
    }
    class DatabaseFiller extends Thread{
        EditText username = findViewById(R.id.create_username);
        EditText pass = findViewById(R.id.editTextTextPassword);
        @Override
        public void run() {
            super.run();

           UsersEntity user = new UsersEntity();
            user.username = String.valueOf(username.getText());
            user.password = String.valueOf(pass.getText());
        }
    }
}