package com.example.mvvmdesignpatternusingretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mvvmdesignpatternusingretrofit.modal.ResponseModal;
import com.example.mvvmdesignpatternusingretrofit.viewmodal.MainViewModal;

import java.util.List;

public class MainActivity extends AppCompatActivity {
TextView txtEmail,txtFirstname,txtLastname;
MainViewModal viewModal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail=findViewById(R.id.txt1);
        txtFirstname=findViewById(R.id.txt2);
        txtLastname=findViewById(R.id.txt3);

        viewModal=new ViewModelProvider(this).get(MainViewModal.class);
        viewModal.getLiveData().observe(this,responseModal ->  {
            txtEmail.setText(responseModal.getData().get(0).getEmail());
            txtFirstname.setText(responseModal.getData().get(0).getFirst_name());
            txtLastname.setText(responseModal.getData().get(0).getLast_name());



        });

    viewModal.makeApiCall();
    }
}