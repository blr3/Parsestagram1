package me.blr3.parsestagram;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.ParseImageView;

import java.util.List;

import me.blr3.parsestagram.model.Post;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private final List<Post> posts;
    private Context context;

    // pass in Tweets array in the constructor
    public ListAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int b) {
        LayoutInflater i = LayoutInflater.from(parent.getContext());
        View view = i.inflate(R.layout.activity_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //((RecyclerView.ViewHolder) holder).bindView(position);
        // get the data according to position
        Post post = posts.get(position);

        // populate the views according to this data
        holder.tvUsername.setText(post.getUser().getUsername());
        holder.tvdescript.setText(post.getDescription());
//        holder.tvTimeStamp.setText(post.createdAt.substring(0, 12));
//        holder.tvTimeStamp.setText(getRelativeTimeAgo(Post.createdAt));
        Glide.with(context).load(post.getImage().getUrl()).into(holder.pivpost);
    }
    // for each row, inflate the layout and cache references into ViewHolder - based on row we are showing we need to bind the value of the tweet object to that element


//
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
//        ((ListViewHolder) holder).bindView(position);
//    }
//
//
//    private abstract class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//
//        private TextView usern;
//        private ParseImageView postpic;
//        private BottomNavigationView lcs;
//        private BottomNavigationView saved;
//
//        public ListViewHolder(View itemView) {
//
//            super(itemView);
//
//        }
//

//}


    // bind the values based on the position of the element


    @Override
    public int getItemCount() {
        return posts.size();
    }

    // create ViewHolder class

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ParseImageView pivpost;
        public TextView tvUsername;
        public BottomNavigationView nbNavHom;
        public BottomNavigationView nbHom;
        public TextView tvTimeStamp;
        public TextView tvdescript;
        private static final String ABBR_DAY = "d";
        private static final String ABBR_HOUR = "h";
        private static final String ABBR_MINUTE = "m";

        public ViewHolder(View itemView) {
            super(itemView);

            // perform findViewById lookups

            tvdescript = (TextView) itemView.findViewById(R.id.tvdescript);
            tvUsername = (TextView) itemView.findViewById(R.id.tvUsername);
            pivpost = (ParseImageView) itemView.findViewById(R.id.pivpost);
            nbNavHom = (BottomNavigationView) itemView.findViewById(R.id.nbNavHom);
            nbHom = (BottomNavigationView) itemView.findViewById(R.id.nbHom);
            //tvTimeStamp = (TextView) itemView.findViewById(R.id.tvTimeStamp);
            //itemView.setOnClickListener();

        }
    }

//        public void bindView(int position) {
//            usern.setText(ParseUser.getCurrentUser().getUsername());
//            postpic.setImageBitmap(postpic.setParseFile(Post.getMedia());
//            postpic.loadInBackground();
//        }


//    // getRelativeTimeAgo("Mon Apr 01 21:16:23 +0000 2014");
//    public String getRelativeTimeAgo(String rawJsonDate) {
//        Log.d("*********", "im here");
//        String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
//        SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
//        sf.setLenient(true);
//
//        String relativeDate = "";
//        try {
//            long dateMillis = sf.parse(Post.getString("createdAT")).getTime();
//            relativeDate = DateUtils.getRelativeTimeSpanString(dateMillis,
//                    System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS, DateUtils.FORMAT_ABBREV_RELATIVE).toString();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        Log.d("********", relativeDate);
//
//        return relativeDate;
//    }

    /* Within the RecyclerView.Adapter class */

    // Clean all elements of the recycler
//    public void clear() {
//        mTweets.clear();
//        notifyDataSetChanged();
//    }
//
//    // Add a list of items -- change to type used
//    public void addAll(List<Tweet> list) {
//        mTweets.addAll(list);
//        notifyDataSetChanged();
//    }


}