package com.example.petbomi;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.petbomi.MainMenuHomeFragment;
import com.example.petbomi.MainMenuReservationFragment;
import com.example.petbomi.MainMenuReviewFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainMenuActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private MainMenuHomeFragment fragmentHome = new MainMenuHomeFragment();
    private MainMenuReservationFragment fragmentReservation = new MainMenuReservationFragment();
    private MainMenuReviewFragment fragmentReview = new MainMenuReviewFragment();
    private MainMenuMypageFragment fragmentMypage = new MainMenuMypageFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.menu_frame_layout, fragmentHome).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());

    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (menuItem.getItemId()) {
                case R.id.menu_home:
                    transaction.replace(R.id.menu_frame_layout, fragmentHome).commitAllowingStateLoss();
                    break;
                case R.id.menu_reservation:
                    transaction.replace(R.id.menu_frame_layout, fragmentReservation).commitAllowingStateLoss();
                    break;
                case R.id.menu_review:
                    transaction.replace(R.id.menu_frame_layout, fragmentReview).commitAllowingStateLoss();
                    break;
                case R.id.menu_mypage:
                    transaction.replace(R.id.menu_frame_layout, fragmentMypage).commitAllowingStateLoss();
                    break;

            }

            return true;
        }
    }
}