package vn.edu.usth.facebookclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NewFeed extends AppCompatActivity {
    ImageView imageView;
    RelativeLayout comment;
    RelativeLayout likebtn;
    TextView textlike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_feed);

        imageView = findViewById(R.id.imagepost);
        comment = findViewById(R.id.writecomment);
        likebtn = findViewById(R.id.likebutton);
        textlike = findViewById(R.id.textlike);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewFeed.this, PostActivity.class);
                startActivity(intent);
            }
        });

        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewFeed.this, Comment.class);
                startActivity(intent);
            }
        });

        likebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textlike.setTextColor(Color.parseColor("#2374e1"));
            }
        });

    }
}