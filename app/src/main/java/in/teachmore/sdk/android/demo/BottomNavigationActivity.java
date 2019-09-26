package in.teachmore.sdk.android.demo;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import in.teachmore.androidsdk.activities.HomeFragment;

public class BottomNavigationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        Fragment fragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        menuItem.setChecked(true);
        Fragment fragment;
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (menuItem.getItemId()) {
            case R.id.search:
                if (!(currentFragment instanceof SearchFragment)) {
                    fragment = new SearchFragment();
                    fragmentTransaction.replace(R.id.frame, fragment).commit();
                }
                return true;
            case R.id.courses:
                if (!(currentFragment instanceof HomeFragment)) {
                    fragment = new HomeFragment();
                    fragmentTransaction.replace(R.id.frame, fragment).commit();
                }
                return true;
        }
        return false;
    }
}