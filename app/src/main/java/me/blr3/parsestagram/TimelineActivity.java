package me.blr3.parsestagram;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class TimelineActivity extends AppCompatActivity {

    private BottomNavigationView tool;
    private FrameLayout feedFrame;

    private HomeFragment homeFragment;
    private SearchFragment searchFragment;
    private NewPostFragment newPostFragment;
    private NotificationFragment notificationFragment;
    private ProfileFragment profileFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        feedFrame = (FrameLayout) findViewById(R.id.main_frame);
        tool = (BottomNavigationView) findViewById(R.id.nbNav);

        homeFragment = new HomeFragment();
        searchFragment = new SearchFragment();
        newPostFragment = new NewPostFragment();
        notificationFragment = new NotificationFragment();
        profileFragment = new ProfileFragment();


        tool.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.navHome :
                        setFragment(homeFragment);
                        return true;

                    case R.id.navSearch :
                        setFragment(searchFragment);
                        return true;

                    case R.id.navCampost :
                        setFragment(newPostFragment);
                        return true;

                    case R.id.navNotify :
                        setFragment(notificationFragment);
                        return true;

                    case R.id.navProfile :
                        setFragment(profileFragment);
                        return true;

                    default:
                        return false;

                    }
                }
            });
        }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }
}
