package com.jabirdeveloper.tinderswipe;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LoginEmpresa extends Activity {
    private EditText editTextNombre;
    private EditText editTextCIF;
    private Spinner spinnerTipoEmpresa;
    private EditText editTextDireccion;
    private EditText editTextTelefono;
    private EditText editTextEmail;
    private Button btnSeleccionarImagen;
    private Button btnInsertar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginempresa);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextCIF = findViewById(R.id.editTextCIF);
        spinnerTipoEmpresa = findViewById(R.id.spinnerTipoEmpresa);
        editTextDireccion = findViewById(R.id.editTextDirecc);
        editTextTelefono = findViewById(R.id.editTextTelf);
        editTextEmail = findViewById(R.id.editTextEmail);
        btnInsertar = findViewById(R.id.btnInsertar);
        btnSeleccionarImagen = findViewById(R.id.btnSeleccionarImagen);

        btnSeleccionarImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 100);
            }
        });

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreEmpresa = editTextNombre.getText().toString();
                String direccion = editTextDireccion.getText().toString();

                DatabaseHelper db = new DatabaseHelper(LoginEmpresa.this);
                boolean insertSuccessful = db.insertEmpresa(nombreEmpresa, direccion);

                if (insertSuccessful) {
                    Toast.makeText(LoginEmpresa.this, "Inserción exitosa", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginEmpresa.this, "Inserción fallida", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            // Aquí puedes usar imageUri para mostrar la imagen seleccionada en un ImageView, o guardar la ruta de la imagen para su uso posterior
        }
    }
}