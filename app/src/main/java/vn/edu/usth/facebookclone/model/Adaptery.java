//package vn.edu.usth.facebookclone.model;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//
//import java.util.List;
//import java.util.zip.Inflater;
//
//import vn.edu.usth.facebookclone.R;
//
//public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {
//
////    private Context mContext;
////    private List<Post> postList;
////
////    public Adaptery(Context mContext, List<Post> postList) {
////        this.mContext = mContext;
////        this.postList = postList;
////    }
////
////    @NonNull
////    @Override
////    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////        View v;
////        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
////        v = layoutInflater.inflate(R.layout.activity_new_feed, parent, false);
////        return new MyViewHolder(v);
////    }
////
////    @Override
////    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
////
////
////        holder.username.setText(postList.get(position).getAuthor());
////        holder.time.setText(postList.get(position).getTime());
////        holder.postcontent.setText(postList.get(position).getContent().getText());
////        holder.like.setText(postList.get(position).getLike());
////        holder.comment.setText(postList.get(position).getComment().length);
////        holder.share.setText(postList.get(position).getShareNum());
////
////        Glide.with(mContext).load(postList.get(position).getContent().getImgLink())
////                .into(holder.postimg);
////    }
////
////    @Override
////    public int getItemCount() {
////        return postList.size();
////    }
////
////
////    public static class MyViewHolder extends RecyclerView.ViewHolder{
////
////        TextView username;
////        TextView time;
////        TextView postcontent;
////        TextView like;
////        TextView comment;
////        TextView share;
////        ImageView postimg;
////
////        public MyViewHolder(@NonNull View itemView) {
////            super(itemView);
////
////            username = itemView.findViewById(R.id.username);
////            time = itemView.findViewById(R.id.time);
////            postcontent = itemView.findViewById(R.id.postcontent);
////            like = itemView.findViewById(R.id.like);
////            comment = itemView.findViewById(R.id.comment);
////            share = itemView.findViewById(R.id.share);
////
////        }
////    }
//}
