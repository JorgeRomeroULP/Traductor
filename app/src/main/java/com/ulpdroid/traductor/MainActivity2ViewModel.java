package com.ulpdroid.traductor;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2ViewModel extends AndroidViewModel {

    private final List<Palabra> palabras;
    private MutableLiveData<String> palabraTraducida;
    private MutableLiveData<Integer> imagencita;

    public MainActivity2ViewModel(@NonNull Application application) {
        super(application);

        palabras = new ArrayList<>();
        palabras.add(new Palabra("arbol", "tree", R.drawable.arbol));
        palabras.add(new Palabra("auto", "car", R.drawable.auto));
        palabras.add(new Palabra("casa", "house", R.drawable.casa));
        palabras.add(new Palabra("gato", "cat", R.drawable.michi));
        palabras.add(new Palabra("perro", "dog", R.drawable.perro));

    }

    public LiveData<String> getMutablePalabraTraducida() {
        if (palabraTraducida == null) {
            palabraTraducida = new MutableLiveData<>();
        }
        return palabraTraducida;
    }

    public LiveData<Integer> getMutableImagencita() {
        if (imagencita == null) {
            imagencita = new MutableLiveData<>();
        }
        return imagencita;
    }

    public void traducir(Intent intent) {
        String palabra = intent.getStringExtra("palabra");
        palabraTraducida.setValue("Not found");
        imagencita.setValue(R.drawable.nopalabra);
        palabras.forEach(p -> {
            if (p.getEspañol().equalsIgnoreCase(palabra)) {
                palabraTraducida.setValue(p.getIngles());
                imagencita.setValue(p.getImg());
            }
        });
    }
}
