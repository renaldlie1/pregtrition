package com.example.pregtrition.view.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.pregtrition.R;
import com.example.pregtrition.view.fragments.AnalyticFragment;
import com.example.pregtrition.view.fragments.ConsultFragment;
import com.example.pregtrition.view.fragments.LearnMoreFragment;
import com.example.pregtrition.view.fragments.MainMenuFragment;
import com.example.pregtrition.view.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainMenuActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    NavHostFragment navHostFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_menu);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.nav_home:
                        selectedFragment = new MainMenuFragment();
                        break;
                    case R.id.nav_analytics:
                        selectedFragment = new AnalyticFragment();
                        break;
                    case R.id.nav_learnmore:
                        selectedFragment = new LearnMoreFragment();
                        break;
                    case R.id.nav_consult:
                        selectedFragment = new ConsultFragment();
                        break;
                    case R.id.nav_profile:
                        selectedFragment = new ProfileFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, selectedFragment).commit();

                return true;
            }
        });
//


    }
}