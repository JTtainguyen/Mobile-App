package vn.edu.usth.facebookclone.model;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.edu.usth.facebookclone.R;
import vn.edu.usth.facebookclone.api.UserApi;

public class SignUp extends AppCompatActivity {
    Button button;
    EditText username;
    EditText passord;
    EditText retypePassword;
    EditText fullName;
    Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        button = findViewById(R.id.signin);
        username = findViewById(R.id.username);
        passord = findViewById(R.id.password);
        retypePassword = findViewById(R.id.password_again);
        signUp = findViewById(R.id.signup);
        fullName = findViewById(R.id.full_name);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passord.getText().toString().equals(retypePassword.getText().toString())) {
                    postData(username.getText().toString(), passord.getText().toString());
                }

            }
        });
    }

    private void postData(String text, String text1) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://63bbc48ccf99234bfa638851.mockapi.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserApi userApi = retrofit.create(UserApi.class);

        User user = new User(text, text1);

        Call<User> call = userApi.postUsers(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                username.setText("");
                passord.setText("");
                retypePassword.setText("");
                fullName.setText("");

                User userResponse = response.body();
                Log.v("code" , Integer.toString(response.code()));
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}