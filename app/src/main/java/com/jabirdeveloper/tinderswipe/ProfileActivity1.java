package com.jabirdeveloper.tinderswipe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil2);

        ImageView imageView = findViewById(R.id.imageView);
        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvEdad = findViewById(R.id.tvEdad);
        TextView tvLugar = findViewById(R.id.tvLugar);
        TextView tvTelefono = findViewById(R.id.tvTelefono);
        TextView tvInstagram = findViewById(R.id.tvInstagram);

        Intent intent = getIntent();
        ItemModel item = (ItemModel) intent.getSerializableExtra("item");

        if (item != null) {
            imageView.setImageResource(item.getImage());
            tvNombre.setText(item.getName());
            tvEdad.setText(item.getAge());
            tvLugar.setText(item.getLocation());
            tvTelefono.setText(item.getPhoneNumber());
            tvInstagram.setText(item.getInstagram());
        }
    }
}