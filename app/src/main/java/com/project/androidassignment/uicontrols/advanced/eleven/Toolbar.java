package com.project.androidassignment.uicontrols.advanced.eleven;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivityToolbarBinding;

import java.util.ArrayList;

public class Toolbar extends AppCompatActivity {
    private ActivityToolbarBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityToolbarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        getSupportActionBar().hide();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.searchbar, menu);

        MenuItem searchViewItem = menu.findItem(R.id.searchbar);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);


        // Spinner
        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

        ArrayList<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");
        list.add("Item 5");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        spinner.setAdapter(adapter);

        return super.onCreateOptionsMenu(menu);
    }
}