package com.joogps.lista;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import android.os.Bundle;
import android.widget.ListView;

import java.sql.Array;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<ItemAlbum> albuns = new ArrayList<ItemAlbum>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        albuns.add(new ItemAlbum(1, "Taylor Swift", "Taylor Swift", "2006", R.drawable.debut));
        albuns.add(new ItemAlbum(2, "Fearless (Taylor's Version)", "Taylor Swift",  "2008 / 2021", R.drawable.fearless));
        albuns.add(new ItemAlbum(3, "Speak Now (Taylor's Version)", "Taylor Swift",  "2010 / 2023", R.drawable.speak_now));
        albuns.add(new ItemAlbum(4, "Red (Taylor's Version)", "Taylor Swift",  "2012 / 2021", R.drawable.red));
        albuns.add(new ItemAlbum(5, "1989 (Taylor's Version)", "Taylor Swift",  "2014 / 2023", R.drawable._1989));
        albuns.add(new ItemAlbum(6, "Reputation", "Taylor Swift",  "2017", R.drawable.reputation));
        albuns.add(new ItemAlbum(7, "Lover", "Taylor Swift",  "2019", R.drawable.lover));
        albuns.add(new ItemAlbum(8, "Folklore", "Taylor Swift",  "2020", R.drawable.folklore));
        albuns.add(new ItemAlbum(9, "Evermore", "Taylor Swift",  "2020", R.drawable.evermore));
        albuns.add(new ItemAlbum(10, "Midnights", "Taylor Swift",  "2022", R.drawable.midnights));

        ItemAlbumAdapter adapter = new ItemAlbumAdapter(this, R.layout.album_item_layout, albuns);
        listView.setAdapter(adapter);
    }
}