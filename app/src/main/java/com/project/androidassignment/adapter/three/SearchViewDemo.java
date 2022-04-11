package com.project.androidassignment.adapter.three;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import com.project.androidassignment.R;
import com.project.androidassignment.databinding.ActivitySearchViewDemoBinding;

import java.util.ArrayList;
import java.util.List;

public class SearchViewDemo extends AppCompatActivity {
    private ActivitySearchViewDemoBinding binding;
    public SearchAdapter adapter;
    public List<String> stringList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchViewDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        stringList = new ArrayList<>();
        stringList.add("Shashank");
        stringList.add("sadasd");
        stringList.add("asdasd");
        stringList.add("dasdasd");
        stringList.add("jghjghjg");
        stringList.add("qweqe");
        stringList.add("cvbcvb");
        stringList.add("zczxcz");
        stringList.add("dfgdfgdf");
        stringList.add("anwrawr");

        adapter = new SearchAdapter(stringList);
        binding.recyclerView7.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_view, menu);

        MenuItem item = menu.findItem(R.id.searchMenu);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                // Notify RecyclerView Adapter here
                List<String> newList = new ArrayList<>();
                newList.clear();

                for(String str: stringList)
                {
                    if(str.contains(newText)){
                        newList.add(str);
                    }
                }
                adapter.search(newList);

                return true;
            }
        });


        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                adapter.stringList = stringList;
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

}