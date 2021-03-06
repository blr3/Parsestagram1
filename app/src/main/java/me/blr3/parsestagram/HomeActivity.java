package me.blr3.parsestagram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.blr3.parsestagram.model.Post;

public class HomeActivity extends AppCompatActivity {

    private static final String imagePath = "";
    ListAdapter listAdapter;
    ArrayList<Post> posts;
    RecyclerView recyclerView;
    private final int REQUEST_CODE = 20;


    public static final String TAG = TimelineActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Only ever call `setContentView` once right at the top
        setContentView(R.layout.fragment_home2);
        // implement method
        // find the RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.rvTimeline);
        // init the arrayList (data source)
        posts = new ArrayList<>();
        // construct the adapter from this datasource
        listAdapter = new ListAdapter(this, posts);
        // RecyclerView setup (layout manager, use adapter)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // set the adapter

        recyclerView.setAdapter(listAdapter);
        // Find the toolbar view inside the activity layout
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        //setSupportActionBar(toolbar);
        Log.d(TAG, "start");
        // Setup refresh listener which triggers new data loading
        // Lookup the swipe container view


        loadTopPost();

    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        //setSupportActionBar(toolbar);
//
////        descriptionInput = findViewById(R.id.etDescription);
////        createButton = findViewById(R.id.btnCreate);
////        refreshButton = findViewById(R.id.btnRefresh);
//
//        ListFragment fragment = new ListFragment();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.contentfragment, fragment);
//        fragmentTransaction.commit();
//
//

//        refreshButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadTopPost();
//            }
//        });


//
//       final Post.Query postQuery = new Post.Query();
////        postQuery.getTop().withUser();
////
////        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
////        //fab.setOnClickListener(new View.OnClickListener() {
//////            @Override
//////            public void onClick(View view) {
//////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//////                        .setAction("Action", null).show();
//////            }
//////        });
////
//        // grab all the post
//        postQuery.getTop().withUser().getPostsForUser(ParseUser.getCurrentUser());
//        postQuery.findInBackground(new FindCallback<Post>() {
//            @Override
//            public void done(List<Post> objects, ParseException e) {
//                if (e == null) {
//                    for (int i = 0; i < objects.size(); ++i) {
//                        Log.d("HomeActivity", "Post[" + i + "] = "
//                                + objects.get(i).getDescription()
//                                + "\nusername = " + objects.get(i).getUser().getUsername());
//                    }
//
//                } else {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//

//    private void createPost(String description, ParseFile imageFile, ParseUser user) {
//        final Post newPost = new Post();
//        newPost.setDescription(description);
//        newPost.setImage(imageFile);
//        newPost.setUser(user);
//
//        newPost.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e == null) {
//                    Log.d("HomeActivity", "Create post success!");
//                } else {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    private void loadTopPost() {
//        posts.clear();
//        listAdapter.clear();
        final Post.Query postQuery = new Post.Query();
        Toast.makeText(this, ParseUser.getCurrentUser().getUsername(), Toast.LENGTH_LONG).show();
        postQuery.getTop().withUser().getPostsForUser(ParseUser.getCurrentUser());
        postQuery.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> objects, ParseException e) {
                Log.i("mum", String.valueOf(objects.size()));
                if (e == null) {
                    posts.addAll(objects);
                    listAdapter.notifyDataSetChanged();

                } else {
                    e.printStackTrace();
                }
            }
        });
    }

//    public void fetchTimelineAsync(int page) {
//        final Post.Query postQuery = new Post.Query();
//        Toast.makeText(this, ParseUser.getCurrentUser().getUsername(), Toast.LENGTH_LONG).show();
//        postQuery.getTop().withUser().getPostsForUser(ParseUser.getCurrentUser());
//        postQuery.findInBackground(new FindCallback<Post>() {
//            @Override
//            public void done(List<Post> objects, ParseException e) {
//                if (e == null) {
//                    listAdapter.clear();
//                    listAdapter.addAll(posts);
//                    //swipeContainer.setRefreshing(false);
//                } else {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }


}


