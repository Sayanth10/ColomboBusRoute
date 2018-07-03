package com.sayanth10.colombobusroute;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new SearchOptions()).commit();
    }

    /**
     * Replace the fragment
     */

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment;

                    switch (item.getItemId()) {
                        case R.id.search_menu:
                            selectedFragment = new SearchOptions();
                            break;

                        case R.id.bus_menu:
                            selectedFragment = new Buses();
                            break;

                        case R.id.map_menu:
                            selectedFragment = new com.sayanth10.colombobusroute.Map();
                            break;

                        case R.id.help_menu:
                            selectedFragment = new Help();
                            break;

                        default:
                            selectedFragment = new SearchOptions();

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                    return true;
                }
            };


}
