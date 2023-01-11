package vn.edu.usth.facebookclone.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.edu.usth.facebookclone.R;
import vn.edu.usth.facebookclone.api.UserApi;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button signIn;
    EditText usernameField;
    EditText passwordField;
    private String[] username = new String[0];
    private  String[] password = new String[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://63bbc48ccf99234bfa638851.mockapi.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserApi userApi = retrofit.create(UserApi.class);

        Call<List<User>> call = userApi.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.code() != 200) {
                    return;
                }

                List<User> users = response.body();

                for (User user : users) {
                    username = push(username, user.getUsername());
                    password = push(password, user.getPassword());
                }


            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });

        button = findViewById(R.id.signup);
        signIn = findViewById(R.id.signin);
        usernameField = findViewById(R.id.username);
        passwordField = findViewById(R.id.password);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < username.length; i++) {
                    if(username[i].equals(usernameField.getText().toString()) && password[i].equals(passwordField.getText().toString())) {
                        Intent intent = new Intent(MainActivity.this, NewFeed.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private static String[] push(String[] array, String push) {
        String[] longer = new String[array.length + 1];
        System.arraycopy(array, 0, longer, 0, array.length);
        longer[array.length] = push;
        return longer;
    }
}
