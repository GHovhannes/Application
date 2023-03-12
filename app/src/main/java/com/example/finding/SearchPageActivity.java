package com.example.finding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.opencv.android.Utils;
import org.opencv.core.Mat;

import java.io.IOException;

public class SearchPageActivity extends AppCompatActivity {

    Button select,camera;
    ImageView image;
    Bitmap bitmap;
    Mat mat;

    int SELECT_CODE = 100, CAMERA_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        ImageView profile = findViewById(R.id.profile);
        ImageView history = findViewById(R.id.history);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profilePage = new Intent(
                        getApplicationContext(), ProfilePageActivity.class);
                startActivity(profilePage);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent historyPage = new Intent(
                        getApplicationContext(), HistoryPageActivity.class);
                startActivity(historyPage);
            }
        });

        camera = findViewById(R.id.camera);
        select = findViewById(R.id.select);
        image = findViewById(R.id.search_image);

        getPermission();

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,SELECT_CODE);
            }
        });


        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAMERA_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SELECT_CODE&&data!=null){
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),data.getData());
                image.setImageBitmap(bitmap);

                mat = new Mat();
                Utils.bitmapToMat(bitmap,mat);


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if(requestCode == CAMERA_CODE && data!=null){
            bitmap = (Bitmap)data.getExtras().get("data");
            image.setImageBitmap(bitmap);
            mat = new Mat();
            Utils.bitmapToMat(bitmap,mat);
        }
    }

    void getPermission(){
        if(checkSelfPermission(android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.CAMERA},102);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 102 && grantResults.length>0){
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED){
                getPermission();
            }
        }
    }
}