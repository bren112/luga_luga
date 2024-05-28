package com.senai.lugaluga.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.senai.lugaluga.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout inputEmail, inputSenha;
    private Button buttonLogin;
    private TextView fazerCadastro;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.outlinedTextField);
        inputSenha = findViewById(R.id.outlinedTextField2);
        buttonLogin = findViewById(R.id.btn_login);
        fazerCadastro = findViewById(R.id.text2);

        inputEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                Pattern pattern;
                Matcher matcher;
                String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                pattern = Pattern.compile(EMAIL_PATTERN);
                CharSequence cs = (CharSequence) s;
                matcher = pattern.matcher(cs);
                if (!(matcher.matches() == true)) {
                    inputEmail.setError("Invalid email");
                } else {
                    inputEmail.setError("");
                }


            }
        });

        Intent intent = new Intent(this, MainActivity2.class);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validaEmailSenha()) {
                    startActivity(intent);
                }
            }
        });

        Intent intentCadastro = new Intent(this, CadastroUserActivity.class);
        fazerCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentCadastro);
            }
        });
    }

    public boolean validaEmailSenha() {
        if (inputEmail.getEditText() != null
                && inputEmail.getEditText().getText().toString().equals("")) {
            inputEmail.setError("Informe seu Email");
            return false;
        }
        if (inputSenha.getEditText() != null && inputSenha.getEditText().getText().toString().equals("")) {
            inputSenha.setError("Informe sua Senha");
            return false;
        }

        return true;
    }

}