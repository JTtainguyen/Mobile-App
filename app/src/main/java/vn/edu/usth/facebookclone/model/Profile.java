package vn.edu.usth.facebookclone.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import vn.edu.usth.facebookclone.R;

public class Profile extends AppCompatActivity {

    ImageView backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        backbtn = findViewById(R.id.back);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, NewFeed.class);
                startActivity(intent);
            }
        });
    }
}