package com.project.androidassignment.menu.advanced.one;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityGmailDrawerBinding;
import com.project.androidassignment.databinding.FragmentAllInboxesBinding;

public class GmailDrawer extends AppCompatActivity {
    private ActivityGmailDrawerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGmailDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new AllInboxes()).commit();

        binding.nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.inbox:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new AllInboxes())
                                .commit();
                        binding.drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.primary:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new PrimaryFragment())
                                .commit();
                        binding.drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.Social:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new SocialFragment())
                                .commit();
                        binding.drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.Promotion:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new PromotionFragment())
                                .commit();
                        binding.drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.Starred:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new StarredFragment())
                                .commit();
                        binding.drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.Snoozed:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new SnoozedFragment())
                                .commit();
                        binding.drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.Important:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new ImportantFragment())
                                .commit();
                        binding.drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.Sent:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new SentFragment())
                            .commit();
                    binding.drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                }
                return false;
            }
        });
    }
}