package com.example.thjen.swipelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ArrayList<item> list = new ArrayList<item>();

        list.add(new item("Hi 1", "Hi 2",  "Hi 3"));
        list.add(new item("Hii 1", "Hii 2","Hii 3"));
        list.add(new item("Hiii 1", "Hiii 2", "Hiii 3"));
        list.add(new item("Hiiii 1", "Hiiii 2", "Hiiii 3"));
        list.add(new item("Hiiiii 1", "Hiiiii 2", "Hiiiii 3"));
        list.add(new item("Hiiiiii 1", "Hiiiii 2", "Hiiiiii 3"));
        list.add(new item("Hiiiiiii 1", "Hiiiiii 2", "Hiiiiiii 3"));
        list.add(new item("Hiiiiiiii 1", "Hiiiiiii 2", "Hiiiiiiii 3"));
        list.add(new item("Hiiiiiiiii 1", "Hiiiiiiii 2", "Hiiiiiiiii 3"));
        list.add(new item("Hiiiiiiiiii 1", "Hiiiiiiiii 2", "Hiiiiiiiiii 3"));

        recycAdapter recycAdapter = new recycAdapter(this, list, R.layout.row);
        recyclerView.setAdapter(recycAdapter);

    }
}
