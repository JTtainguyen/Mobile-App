package vn.edu.usth.facebookclone.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import vn.edu.usth.facebookclone.R;

public class PostActivity extends AppCompatActivity {
    ImageView closeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        closeBtn = findViewById(R.id.close);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostActivity.this, NewFeed.class);
                startActivity(intent);
            }
        });
    }
}