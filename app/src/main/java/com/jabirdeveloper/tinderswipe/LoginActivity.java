package com.jabirdeveloper.tinderswipe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
    private EditText usernameField;
    private EditText passwordField;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usernameField = (EditText) findViewById(R.id.editTextEmail);
        passwordField = (EditText) findViewById(R.id.editTextPassword);
        loginButton = (Button) findViewById(R.id.btn_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameField.getText().toString();
                String password = passwordField.getText().toString();

                if (loginUser(username, password)) {
                    Toast.makeText(LoginActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                    // Iniciar MainActivity
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Inicio de sesión fallido", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    private boolean loginUser(String username, String password) {
        // Aquí debes implementar la lógica de inicio de sesión
        // Este es solo un ejemplo y siempre devolverá false
        String correctUsername = "a";
        String correctPassword = "a";

        return username.equals(correctUsername) && password.equals(correctPassword);
    }
}