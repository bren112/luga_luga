package com.senai.lugaluga.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.senai.lugaluga.R;
import com.senai.lugaluga.controller.UsuarioController;
import com.senai.lugaluga.model.User;

public class CadastroUserActivity extends AppCompatActivity {
  
    
    
    private Spinner spinnerUf;

    private TextInputLayout inputCpf , input_nome , input_data , input_cep , input_cidade , input_bairro , input_email , input_senha , input_logradouro , input_numero , input_complemento;

    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_user);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Cadastro");
        setSupportActionBar(myToolbar);

        inputCpf = findViewById(R.id.input_cpf);
        input_nome = findViewById(R.id.input_nome);
        input_cidade = findViewById(R.id.input_cidade);
        input_bairro = findViewById(R.id.input_bairro);
        input_email = findViewById(R.id.input_email);
        input_cep = findViewById(R.id.input_cep);
        input_data = findViewById(R.id.input_data);
        input_senha = findViewById(R.id.input_senha);
        input_logradouro = findViewById(R.id.input_logradouro);
        input_numero = findViewById(R.id.input_numero);
        input_complemento = findViewById(R.id.input_complemento);
        input_cidade = findViewById(R.id.input_cidade);
        btnCadastrar = findViewById(R.id.btn_cadastrar);
        inputCpf.getEditText().addTextChangedListener(new TextWatcher() {

            private static final String maskCPF = "###.###.###-##";
            boolean isUpdating;
            String old = "";
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String str = s.toString().replaceAll("[^0-9]*" , "");
                String mask = maskCPF;

                String mascara = "";
                if (isUpdating){
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (char m : mask.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i)) {
                        mascara += m;
                        continue;
                    }


                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                inputCpf.getEditText().setText(mascara);
                inputCpf.getEditText().setSelection(mascara.length());

            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });

     input_cep.getEditText().addTextChangedListener(new TextWatcher() {

         private static final String maskCep = "#####-###";
         boolean isUpdating;
         String old = "";
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {


         }

         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {

             String str = s.toString().replaceAll("[^0-9]*" , "");
             String mask = maskCep;

             String mascara = "";
             if (isUpdating){
                 old = str;
                 isUpdating = false;
                 return;
             }
             int i = 0;
             for (char m : mask.toCharArray()) {
                 if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i)) {
                     mascara += m;
                     continue;
                 }


                 try {
                     mascara += str.charAt(i);
                 } catch (Exception e) {
                     break;
                 }
                 i++;
             }
             isUpdating = true;
             input_cep.getEditText().setText(mascara);
             input_cep.getEditText().setSelection(mascara.length());

         }


         @Override
         public void afterTextChanged(Editable s) {

         }
     });
        input_data.getEditText().addTextChangedListener(new TextWatcher() {
            private static final String maskDate = "##-##-####";
            boolean isUpdating;
            String old = "";
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString().replaceAll("[^0-9]*" , "");
                String mask = maskDate;

                String mascara = "";
                if (isUpdating){
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (char m : mask.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i)) {
                        mascara += m;
                        continue;
                    }


                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                input_data.getEditText().setText(mascara);
                input_data.getEditText().setSelection(mascara.length());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });






                spinnerUf = (Spinner) findViewById(R.id.spinner_uf);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.uf_cadastro,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUf.setAdapter(adapter);

        btnCadastrar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {


                UsuarioController crud = new UsuarioController(getApplicationContext());
                User usuario = new User();
                usuario.setNome(input_nome.getEditText().getText().toString());
                usuario.setCep(input_cep.getEditText().getText().toString());
                usuario.setCpf(inputCpf.getEditText().getText().toString());
                usuario.setDataNascimento(input_data.getEditText().getText().toString());
                usuario.setMunicipio(input_cidade.getEditText().getText().toString());
                usuario.setUf(spinnerUf.getSelectedItem().toString());
                usuario.setLogradouro(input_logradouro.getEditText().getText().toString());
                usuario.setNumero(Integer.parseInt(input_numero.getEditText().getText().toString()));

                String resultado;
                resultado = crud.iserDados(usuario.getNome(), usuario.getCpf(),
                        usuario.getDataNascimento(), usuario.getCep(), usuario.getMunicipio(),
                        usuario.getUf(), usuario.getLogradouro(), usuario.getNumero(),
                        usuario.getComplemento(), usuario.getBairro(), usuario.getEmail(), usuario.getSenha());
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_SHORT).show();

            }
        });


    }

}