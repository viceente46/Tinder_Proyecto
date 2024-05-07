package com.jabirdeveloper.tinderswipe;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView signUpText = findViewById(R.id.sign_up_text);
        String text = "No tienes cuenta? Sign up";
        SpannableString spannableString = new SpannableString(text);

// Definir los colores
        int colorBlack = Color.BLACK;
        int colorBlue = Color.BLUE;

// Definir el ClickableSpan
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Intent intent = new Intent(LoginActivity.this, logueoActivity.class);
                startActivity(intent);
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                // Establecer el color azul
                ds.setColor(colorBlue);
            }
        };

        // Aplicar el ClickableSpan solo al texto "Sign up"
        spannableString.setSpan(clickableSpan, text.indexOf("Sign up"), text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Establecer el color negro para todo el texto
        spannableString.setSpan(new ForegroundColorSpan(colorBlack), 0, text.indexOf("Sign up"), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(colorBlack), text.indexOf("Sign up") + "Sign up".length(), text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        signUpText.setText(spannableString);
        signUpText.setMovementMethod(LinkMovementMethod.getInstance());
        signUpText.setHighlightColor(Color.TRANSPARENT); // Para quitar el color de resaltado


    }




    private boolean loginUser(String username, String password) {
        DatabaseHelper db = new DatabaseHelper(this);
        return db.checkUser(username, password);
    }
}