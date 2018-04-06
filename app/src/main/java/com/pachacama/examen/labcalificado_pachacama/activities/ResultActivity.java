package com.pachacama.examen.labcalificado_pachacama.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.pachacama.examen.labcalificado_pachacama.R;
import com.pachacama.examen.labcalificado_pachacama.adaptador.BuscadorAdapter;
import com.pachacama.examen.labcalificado_pachacama.modelo.Buscador;
import com.pachacama.examen.labcalificado_pachacama.repositorio.BuscadorRepository;

import java.util.ArrayList;
import java.util.List;


public class ResultActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Buscador> buscadors = BuscadorRepository.getList();
    private EditText editText;
    BuscadorAdapter buscadorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Toast.makeText(this, "Query"+this.getIntent().getExtras().get("query"), Toast.LENGTH_SHORT).show();;
        editText = findViewById(R.id.edit);
        editText.setText(this.getIntent().getExtras().getString("query"));



        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buscadorAdapter = new BuscadorAdapter();
        buscadorAdapter.setBuscadores(BuscadorRepository.getList());


        recyclerView.setAdapter(buscadorAdapter);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });
    }


    private void filter(String s) {

        ArrayList<Buscador> busca = new ArrayList<>();

        for (Buscador buscador : buscadors) {
            if (buscador.getName().toLowerCase().contains(s.toLowerCase())) {busca.add(buscador);}
        }

        buscadorAdapter.filterList(busca);

    }
}
