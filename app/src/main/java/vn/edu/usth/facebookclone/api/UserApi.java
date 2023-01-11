package vn.edu.usth.facebookclone.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import vn.edu.usth.facebookclone.model.User;

public interface UserApi {

    @GET("/users")
    Call<List<User>> getUsers();

    @POST("/users")
    Call<User> postUsers(@Body User user);
}
