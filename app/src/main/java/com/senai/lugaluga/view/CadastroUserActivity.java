package com.senai.lugaluga.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputLayout;
import com.senai.lugaluga.R;

public class CadastroUserActivity extends AppCompatActivity {
  
    
    
    private Spinner spinnerUf;

    private TextInputLayout inputCpf;
    private TextInputLayout inputCep;
    private TextInputLayout inputDate;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_user);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Cadastro");
        setSupportActionBar(myToolbar);

        inputCpf = findViewById(R.id.input_cpf);
        inputCep = findViewById(R.id.input_cep);
        inputDate = findViewById(R.id.input_data);
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

     inputCep.getEditText().addTextChangedListener(new TextWatcher() {

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
             inputCep.getEditText().setText(mascara);
             inputCep.getEditText().setSelection(mascara.length());

         }


         @Override
         public void afterTextChanged(Editable s) {

         }
     });
        inputDate.getEditText().addTextChangedListener(new TextWatcher() {
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
                inputDate.getEditText().setText(mascara);
                inputDate.getEditText().setSelection(mascara.length());

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

    }

}