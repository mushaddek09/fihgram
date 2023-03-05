package com.example.fihgram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.karumi.dexter.Dexter;

public class AddPostActivity extends AppCompatActivity {


    TextView t1, t2;
    Button browse , upload;
    ImageView img;
    String encodeImage;

    private  static  final String url = "http://192.168.1.13/instagram/upload.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post2);


//        browse.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Dexter.withActivity(AddPostActivity.this)
//                        .withPermission(Manifest.permission.R);
//            }
//        });




    }
}