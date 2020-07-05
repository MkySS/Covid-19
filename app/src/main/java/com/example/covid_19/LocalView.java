package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class LocalView extends AppCompatActivity {/*implements LoaderManager.LoaderCallbacks<cursor>

    public static final String ID_NOTICIA = "ID_NOTICIA";
    public static final int ID_CURSOR_LOADER_NOTICIA = 0;
    private AdaptadorNoticias adaptadorNoticias;
    private RecyclerView recyclerViewNoticias;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_view);
    }
    Intent intentLV = getIntent();
}