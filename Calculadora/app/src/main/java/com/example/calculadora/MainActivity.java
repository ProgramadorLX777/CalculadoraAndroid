package com.example.calculadora;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Declaración de variables:
    private EditText editText;
    private Button btnAdd, btnRest, btnMulti, btnDiv, btnPoten, btnCalculate;
    private double primerValor, segundoValor;
    private boolean isSegundoValor = false;
    private String currentOperation = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Instancias:
        editText = findViewById(R.id.txtPrimerValor);
        btnAdd = findViewById(R.id.btnSumar);
        btnRest = findViewById(R.id.btnRestar);
        btnMulti = findViewById(R.id.btnMultiplicar);
        btnDiv = findViewById(R.id.btnDividir);
        btnPoten = findViewById(R.id.btnPotencia);
        btnCalculate = findViewById(R.id.btnCalcular);

        // Llamada al objeto del boton Sumar:
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSegundoValor) {
                    primerValor = Double.parseDouble(editText.getText().toString().trim());
                    editText.setText("");
                    isSegundoValor = true;
                    currentOperation = "sumar";

                }
            }
        });

        // Llamada al objeto del boton Restar:
        btnRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSegundoValor) {
                    primerValor = Double.parseDouble(editText.getText().toString().trim());
                    editText.setText("");
                    isSegundoValor = true;
                    currentOperation = "restar";
                }
            }
        });

        // Llamada al objeto del boton Multiplicar:
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSegundoValor) {
                    primerValor = Double.parseDouble(editText.getText().toString().trim());
                    editText.setText("");
                    isSegundoValor = true;
                    currentOperation = "multiplicar";

                }
            }
        });

        // Llamada al objeto del boton Dividir:
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSegundoValor) {
                    primerValor = Double.parseDouble(editText.getText().toString().trim());
                    editText.setText("");
                    isSegundoValor = true;
                    currentOperation = "dividir";

                }
            }
        });

        // Llamada al objeto del boton Potencia:
        btnPoten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSegundoValor) {
                    primerValor = Double.parseDouble(editText.getText().toString().trim());
                    editText.setText("");
                    isSegundoValor = true;
                    currentOperation = "potenciar";

                }
            }
        });

        // Switch Case para cada operación matemática:
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSegundoValor) {
                    segundoValor = Double.parseDouble(editText.getText().toString().trim());
                    double result = 0;
                    switch (currentOperation) {
                        case "sumar":
                            result = primerValor + segundoValor;
                            break;
                        case "restar":
                            result = primerValor - segundoValor;
                            break;
                        case "multiplicar":
                            result = primerValor * segundoValor;
                            break;
                        case "dividir":
                            if (segundoValor != 0) {
                                result = primerValor / segundoValor;
                            } else {
                                editText.setText("Error");
                                return;
                            }
                            break;
                        case "potenciar":
                            result = Math.pow(primerValor, segundoValor);
                            break;
                    }
                    editText.setText(String.valueOf(result));
                    isSegundoValor = false;
                    currentOperation = "";
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}