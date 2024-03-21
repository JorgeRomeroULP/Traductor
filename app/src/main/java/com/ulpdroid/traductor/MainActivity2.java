package com.ulpdroid.traductor;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ulpdroid.traductor.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;

    private MainActivity2ViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivity2ViewModel.class);

        vm.getMutablePalabraTraducida().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvPalabraTraducida.setText(s);
            }
        });

        vm.getMutableImagencita().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.ivTraducida.setImageResource(integer);
            }
        });

        vm.traducir(getIntent());
    }
}