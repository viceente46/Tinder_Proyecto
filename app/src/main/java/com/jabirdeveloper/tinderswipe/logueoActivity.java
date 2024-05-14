package com.jabirdeveloper.tinderswipe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class logueoActivity extends Activity {
    DatabaseHelper myDb;
    EditText editName, editSurname, editEmail, editPassword, editTextEmail;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loguear);
        myDb = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.editTextName);
        editSurname = (EditText)findViewById(R.id.editTextSurname);
        editEmail = (EditText)findViewById(R.id.editTextEmail);
        editPassword = (EditText)findViewById(R.id.editTextPassword);
        btnRegister = (Button)findViewById(R.id.btn_login);
        AddData();
        //hazme para controlar el patern del email
        editTextEmail = findViewById(R.id.editTextEmail);
        btnRegister = findViewById(R.id.btn_login);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();

                if (!isValidEmail(email)) {
                    editTextEmail.setError("Email inválido. Debe seguir el patrón xx@xx.xx");
                } else {
                    // Procede con el inicio de sesión
                    btnRegister.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String email = editTextEmail.getText().toString().trim();

                            if (!isValidEmail(email)) {
                                editTextEmail.setError("Email inválido. Debe seguir el patrón xx@xx.xx");
                            } else {
                                // Procede con el inicio de sesión
                                AddData();
                            }
                        }
                    });

                }
            }
        });
    }
    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }
    public void AddData() {
        btnRegister.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editSurname.getText().toString(),
                                editEmail.getText().toString(),
                                editPassword.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(logueoActivity.this,"registro Insertado ",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(logueoActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}