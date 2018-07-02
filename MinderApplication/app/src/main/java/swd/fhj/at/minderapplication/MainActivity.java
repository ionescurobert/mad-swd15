package swd.fhj.at.minderapplication;

import android.support.v4.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private NotificationFragment notificationFragment;
    private AccountFragment accountFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        homeFragment = new HomeFragment();
        notificationFragment = new NotificationFragment();
        accountFragment = new AccountFragment();

        setFragment(homeFragment);

        mMainNav.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_home:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(homeFragment);

                    case R.id.nav_notif:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(notificationFragment);

                    case R.id.nav_account:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(accountFragment);
                    default:


                }
            }
        });
    }

    private void setFragment(Fragment fragment) {

        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();


    }
}
