package com.br.cursoalcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText campoAlcool, campoGasolina;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoAlcool = findViewById(R.id.edit_alcool);
        campoGasolina = findViewById(R.id.edit_gasolina);
        txtResultado = findViewById(R.id.text_resultado);

    }

    public  void calcular(View view){
       String alcool = campoAlcool.getText().toString();
       String gasolina = campoGasolina.getText().toString();

       //Validar os campos digitados
       Boolean camposValidados =  validarCampos(alcool, gasolina);

       if (camposValidados){

           //converter String para números
           Double precoAlcool = Double.parseDouble(alcool);
           Double precoGasolina = Double.parseDouble(gasolina);

           Double resultado = precoAlcool / precoGasolina;

           if(resultado >= 0.7){
               txtResultado.setText("Coloque GASOLINA!");
           }else{
               txtResultado.setText("Coloque ÁLCOOL!3");
           }

       }else{

           txtResultado.setText("Preencha os preços primeiro!");
       }


    }

    public boolean validarCampos(String pAlcool, String pGAsolina){

        Boolean camposValidados = true;

        if (pAlcool ==  null || pAlcool.equals("")){
            camposValidados = false;
        }else if(pGAsolina == null|| pGAsolina.equals("")){
            camposValidados = false;
        }


            return camposValidados;
    }

}