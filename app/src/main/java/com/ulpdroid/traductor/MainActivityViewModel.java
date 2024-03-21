package com.ulpdroid.traductor;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainActivityViewModel extends AndroidViewModel {

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

    }

    public void enviarPalabra(String palabra) {

        Intent intent = new Intent(getApplication(), MainActivity2.class);

        intent.putExtra("palabra", palabra);

        getApplication().startActivity(intent);
    }
}
