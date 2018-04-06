package com.pachacama.examen.labcalificado_pachacama.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.pachacama.examen.labcalificado_pachacama.R;
import com.pachacama.examen.labcalificado_pachacama.modelo.Buscador;


public class MainActivity extends AppCompatActivity implements  SearchView.OnQueryTextListener{

    private SearchView searchView;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);



    }


    public boolean menu (Menu menu){

        searchView = (SearchView) findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(this);

        return true;
    }



    public void resultado( View view){

    Intent intent = new Intent(this, ResultActivity.class);
    startActivity(intent);

}

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {



        return false;
    }
}
