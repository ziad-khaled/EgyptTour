package me.ziad_khaled.egypttour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class DishesFragment extends Fragment {
    private RecyclerView recyclerView;
    private DishesAdapter dishesAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.items_list, container, false);
        recyclerView =  rootView.findViewById(R.id.items_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        final ArrayList<Dish> dishesList = DataStorage.getDishesList();
        dishesAdapter = new DishesAdapter(dishesList);
        recyclerView.setAdapter(dishesAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }
}

