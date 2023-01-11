package vn.edu.usth.facebookclone.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import vn.edu.usth.facebookclone.model.Post;

public interface PostApi {
    @GET("/posts")
    Call<List<Post>> getPosts();
}
