    package com.example.profil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {

    private EditText name, email,password,confpassword;
    private Button registerbtn,imagebtn;
    private TextView wn,we,wp,wcp;
    private CheckBox agree;
    private RadioGroup gender;
    private Spinner country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Image picked",Toast.LENGTH_SHORT  ).show();
            }
        });
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean ok=false;
                ok=verify();
                if(ok==true)
                {
                    Toast.makeText(MainActivity.this,"Register succeed",Toast.LENGTH_SHORT  ).show();
                    Intent intent= new Intent(MainActivity.this, MapsActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
    private void init()
    {
        name=findViewById(R.id.nume);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        confpassword=findViewById(R.id.confirmPassword);
        registerbtn=findViewById(R.id.registerbtn);
        imagebtn=findViewById(R.id.pick);
        wn=findViewById(R.id.warningname);
        we=findViewById(R.id.warningemail);
        wp=findViewById(R.id.warningpassw);
        wcp=findViewById(R.id.warningconfpassw);
        agree=findViewById(R.id.confirmareTerms);
        gender=findViewById(R.id.genderGroup);
        country=findViewById(R.id.country);
    }
    private boolean verify()
    {
        wn.setVisibility(View.INVISIBLE);
        we.setVisibility(View.INVISIBLE);
        wp.setVisibility(View.INVISIBLE);
        wcp.setVisibility(View.INVISIBLE);
        if(name.getText().toString().equals(""))
        {
            wn.setVisibility(View.VISIBLE);
            return false;
        }
        if(email.getText().toString().equals(""))
        {
            we.setVisibility(View.VISIBLE);
            return false;
        }
        if(password.getText().toString().equals(""))
        {
            wp.setVisibility(View.VISIBLE);
            return false;
        }
        if(confpassword.getText().toString().equals(""))
        {
            wcp.setVisibility(View.VISIBLE);
            return false;
        }
        if(!agree.isChecked())
        {
            Toast.makeText(MainActivity.this,"You need to agree our terms",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password.getText().toString().equals(confpassword.getText().toString()))
        {
            return true;
        }
        else
        {
            Toast.makeText(MainActivity.this,"Incorect Password",Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}