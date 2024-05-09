package com.senai.lugaluga.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.senai.lugaluga.R;
import com.senai.lugaluga.model.Produto;

public class ProdutoActivity extends AppCompatActivity {

        private Produto produto;

        private TextView nomeProduto , qtdProduto , precoProduto , descProduto;

        private Button btnAlugar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto2);
        
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        nomeProduto = findViewById(R.id.nomeProdutoTv);
        qtdProduto = findViewById(R.id.qtdProdutotv);
        precoProduto = findViewById(R.id.precoTv);
        descProduto = findViewById(R.id.descTv);

        btnAlugar = findViewById(R.id.alugar);

        produto = getIntent().getExtras().getParcelable("produto");

        nomeProduto.setText(produto.getNome());
        qtdProduto.setText(String.valueOf(produto.getQtd()));
        precoProduto.setText(String.valueOf(produto.getPreco()));
        descProduto.setText(produto.getDesc());

        btnAlugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProdutoActivity.this);
                builder.setMessage("Deseja realmente alugar este produto?");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext() , produto.getNome() + " adicionado ao carrinho"  , Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancelar" , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}