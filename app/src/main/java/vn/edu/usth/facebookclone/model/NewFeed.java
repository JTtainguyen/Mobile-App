package vn.edu.usth.facebookclone.model;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.edu.usth.facebookclone.R;
import vn.edu.usth.facebookclone.api.PostApi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class NewFeed extends AppCompatActivity {
    ImageView imageView;
    RelativeLayout comment;
    RelativeLayout likebtn;
    ImageView profileBtn;
    TextView textlike;
    TextView username;
    TextView time;
    TextView postcontent;
    TextView like;
    TextView commentCount;
    TextView share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_feed);

        imageView = findViewById(R.id.imagepost);
        comment = findViewById(R.id.writecomment);
        likebtn = findViewById(R.id.likebutton);
        textlike = findViewById(R.id.textlike);
        profileBtn = findViewById(R.id.profile);

        username = findViewById(R.id.username);
        time = findViewById(R.id.time);
        postcontent = findViewById(R.id.postcontent);
        like = findViewById(R.id.like);
        commentCount = findViewById(R.id.comment);
        share = findViewById(R.id.share);


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
                    Log.v("post", post.getId());
                    username.setText(post.getAuthor());
                    time.setText(Integer.toString(post.getTime()) + " mins ago");
                    postcontent.setText(post.getContent().getText());
                    like.setText(Integer.toString(post.getLike()) + " \uD83E\uDD23\uD83D\uDE25❤");
                    share.setText(Integer.toString(post.getShareNum()) + " shares");
                    commentCount.setText(Integer.toString(post.getComment().length) + " comments");
                    if(post.isLike()) {
                        textlike.setTextColor(Color.parseColor("#2374e1"));
                    }
                }


            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });

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

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewFeed.this, Profile.class);
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