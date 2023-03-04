package com.example.finding;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;

public class RegisterLastStageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_last_stage);
        LinkedList<UserClass> usernames = new LinkedList<>();
        EditText pass = findViewById(R.id.editTextTextPassword);
        EditText user = findViewById(R.id.create_username);
        EditText confirmPassword = findViewById(R.id.confirm_password);
        TextView isPasswordCorrect = findViewById(R.id.confirm_password_text);
        TextView submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = String.valueOf(pass.getText());
                String confirmPass = String.valueOf(confirmPassword.getText());
                String username = String.valueOf(user.getText());
                if(!password.equals(confirmPass)){
                    isPasswordCorrect.setText("Passwords do nt match");
                    isPasswordCorrect.setTextColor(Color.RED);
                }
                UserClass users = new UserClass(username,confirmPass);
                usernames.add(users);
            }
        });
    }
}