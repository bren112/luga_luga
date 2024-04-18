package com.senai.lugaluga.view;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.senai.lugaluga.R;

public class MainActivity extends AppCompatActivity {

    private ListView listcidade;

    private String[] cidades = {
            "Sumaré", "Araras", "Itatiba", "Hortolândia", "Mogi das Cruzes",
            "Piracicaba", "Rio Claro", "Santo André", "São Bernardo do Campo",
            "São João da Boa Vista", "São José do Rio Pardo", "São José dos Campos",
            "São Vicente", "Sertãozinho", "Taboão da Serra", "Itaquaquecetuba", "Jundiaí",
            "Catanduva", "Fernandópolis"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listcidade = findViewById(R.id.listaNomes);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                cidades

        );
        listcidade.setAdapter(adapter);
        listcidade.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemSelecionado = listcidade.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext() , itemSelecionado, Toast.LENGTH_LONG).show();
            }
        });
    }
}