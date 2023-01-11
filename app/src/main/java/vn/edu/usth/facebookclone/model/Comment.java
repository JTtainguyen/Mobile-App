package vn.edu.usth.facebookclone.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.edu.usth.facebookclone.R;
import vn.edu.usth.facebookclone.api.PostApi;

public class Comment extends AppCompatActivity {
    ImageView back;
    LinearLayout like;
    TextView textlike;
    TextView commentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        back = findViewById(R.id.back);
        like = findViewById(R.id.like);
        textlike = findViewById(R.id.textlike);
        commentText = findViewById(R.id.commentText);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Comment.this, NewFeed.class);
                startActivity(intent);
            }
        });

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textlike.setTextColor(Color.parseColor("#2374e1"));
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://63bbc48ccf99234bfa638851.mockapi.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi postApi = retrofit.create(PostApi.class);

        Call<List<Post>> call = postApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.code() != 200) {
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    commentText.setText(post.getComment()[0]);
                    }
                }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
            });
        };;
    }
