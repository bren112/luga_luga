package com.senai.lugaluga.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.senai.lugaluga.R;
import com.senai.lugaluga.model.Produto;

public class ProdutoActivity extends AppCompatActivity {

        private Produto produto;

        private TextView nomeProduto , qtdProduto , precoProduto , descProduto;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto2);

        nomeProduto = findViewById(R.id.nomeProdutoTv);
        qtdProduto = findViewById(R.id.qtdProdutotv);
        precoProduto = findViewById(R.id.precoTv);
        descProduto = findViewById(R.id.descTv);

        produto = getIntent().getExtras().getParcelable("produto");

        nomeProduto.setText(produto.getNome());
        qtdProduto.setText(produto.getQtd());
        precoProduto.setText(String.valueOf(produto.getPreco()));
        descProduto.setText(produto.getDesc());
    }
}