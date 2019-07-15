package com.check.time;

import androidx.appcompat.app.AppCompatActivity;
import controller.ControlMainActivity;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ControlMainActivity control;

    public ScrollView container;

    public TextView nombre_cl, nombre_ch, nombre_nz, nombre_au, nombre_uk, nombre_usa;
    public TextView time_cl, time_ch, time_nz, time_au, time_uk, time_usa;
    public TextView temperature_cl, temperature_ch, temperature_nz, temperature_au, temperature_uk, temperature_usa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_components();
        init_events();
    }

    private void init_components(){

        container      = findViewById(R.id.container);

        nombre_cl      = findViewById(R.id.nombre_cl);
        nombre_ch      = findViewById(R.id.nombre_ch);
        nombre_nz      = findViewById(R.id.nombre_nz);
        nombre_au      = findViewById(R.id.nombre_au);
        nombre_uk      = findViewById(R.id.nombre_uk);
        nombre_usa     = findViewById(R.id.nombre_usa);

        time_cl        = findViewById(R.id.time_cl);
        temperature_cl = findViewById(R.id.temperature_cl);

        time_ch        = findViewById(R.id.time_ch);
        temperature_ch = findViewById(R.id.temperature_ch);

        time_nz        = findViewById(R.id.time_nz);
        temperature_nz = findViewById(R.id.temperature_nz);

        time_au        = findViewById(R.id.time_au);
        temperature_au = findViewById(R.id.temperature_au);

        time_uk        = findViewById(R.id.time_uk);
        temperature_uk = findViewById(R.id.temperature_uk);

        time_usa        = findViewById(R.id.time_usa);
        temperature_usa = findViewById(R.id.temperature_usa);
    }

    private void init_events(){
        control = new ControlMainActivity(this);
    }

}