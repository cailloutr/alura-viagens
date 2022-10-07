package com.example.aluraviagens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.aluraviagens.ui.ListaDePacotesActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);

        if(preferences.contains("ja_abriu_app")){
            navegarParaListaDePacote();
        } else {
            adicionarPreferenceJaAbriu(preferences);
            mostrarSplashScreen();
        }

    }

    private void mostrarSplashScreen() {
        Handler handler = new Handler();
        handler.postDelayed((Runnable) this::navegarParaListaDePacote, 2000);
    }

    private void navegarParaListaDePacote() {
        startActivity(new Intent(this, ListaDePacotesActivity.class));
        finish();
    }

    private void adicionarPreferenceJaAbriu(SharedPreferences preferences) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("ja_abriu_app", true);
        editor.apply();
    }
}