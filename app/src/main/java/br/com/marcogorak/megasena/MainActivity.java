package br.com.marcogorak.megasena;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtSorteio1;
    TextView txtSorteio2;
    TextView txtSorteio3;
    TextView txtSorteio4;
    TextView txtSorteio5;
    TextView txtSorteio6;
    EditText edtSorteio1;
    EditText edtSorteio2;
    EditText edtSorteio3;
    EditText edtSorteio4;
    EditText edtSorteio5;
    EditText edtSorteio6;
    Button btnJogar;
    TextView txtResultado;
    int[] jogo = new int[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSorteio1 = (TextView) findViewById(R.id.txtSorteio1);
        txtSorteio2 = (TextView) findViewById(R.id.txtSorteio2);
        txtSorteio3 = (TextView) findViewById(R.id.txtSorteio3);
        txtSorteio4 = (TextView) findViewById(R.id.txtSorteio4);
        txtSorteio5 = (TextView) findViewById(R.id.txtSorteio5);
        txtSorteio6 = (TextView) findViewById(R.id.txtSorteio6);
        edtSorteio1 = (EditText) findViewById(R.id.edtSorteio1);
        edtSorteio2 = (EditText) findViewById(R.id.edtSorteio2);
        edtSorteio3 = (EditText) findViewById(R.id.edtSorteio3);
        edtSorteio4 = (EditText) findViewById(R.id.edtSorteio4);
        edtSorteio5 = (EditText) findViewById(R.id.edtSorteio5);
        edtSorteio6 = (EditText) findViewById(R.id.edtSorteio6);
        btnJogar = (Button) findViewById(R.id.btnJogar);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
        btnJogar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        inicializa();
    }

    public void jogo() {
        jogo[0] = Integer.parseInt(txtSorteio1.getText().toString());
        jogo[1] = Integer.parseInt(txtSorteio2.getText().toString());
        jogo[2] = Integer.parseInt(txtSorteio3.getText().toString());
        jogo[3] = Integer.parseInt(txtSorteio4.getText().toString());
        jogo[4] = Integer.parseInt(txtSorteio5.getText().toString());
        jogo[5] = Integer.parseInt(txtSorteio6.getText().toString());
        antiFraude();
        pontuacao();
    }

    public void pontuacao() {

        Integer intEdtSorteio1;
        Integer intEdtSorteio2;
        Integer intEdtSorteio3;
        Integer intEdtSorteio4;
        Integer intEdtSorteio5;
        Integer intEdtSorteio6;

        intEdtSorteio1 = Integer.parseInt(edtSorteio1.getText().toString());
        intEdtSorteio2 = Integer.parseInt(edtSorteio2.getText().toString());
        intEdtSorteio3 = Integer.parseInt(edtSorteio3.getText().toString());
        intEdtSorteio4 = Integer.parseInt(edtSorteio4.getText().toString());
        intEdtSorteio5 = Integer.parseInt(edtSorteio5.getText().toString());
        intEdtSorteio6 = Integer.parseInt(edtSorteio6.getText().toString());
        int pontuacao = 0;

        for (int i = 0; i < jogo.length; i++) {
            if (intEdtSorteio1 == jogo[i]) {
                pontuacao++;
            }
            if (intEdtSorteio2 == jogo[i]) {
                pontuacao++;
            }
            if (intEdtSorteio3 == jogo[i]) {
                pontuacao++;
            }
            if (intEdtSorteio4 == jogo[i]) {
                pontuacao++;
            }
            if (intEdtSorteio5 == jogo[i]) {
                pontuacao++;
            }
            if (intEdtSorteio6 == jogo[i]) {
                pontuacao++;
            }
        }

        String result = String.format("Você fez: %d pontos", pontuacao);
        txtResultado.setText(result);
    }

    public void inicializa() {
        txtSorteio1.setText(String.valueOf(randomNumber()));
        txtSorteio2.setText(String.valueOf(randomNumber()));
        txtSorteio3.setText(String.valueOf(randomNumber()));
        txtSorteio4.setText(String.valueOf(randomNumber()));
        txtSorteio5.setText(String.valueOf(randomNumber()));
        txtSorteio6.setText(String.valueOf(randomNumber()));
        jogo();
    }

    public int randomNumber() {
        Random random = new Random();
        int sorte = random.nextInt(60);
        return sorte;
    }

    public void antiFraude() {
        Integer intTxtSorteio1;
        Integer intTxtSorteio2;
        Integer intTxtSorteio3;
        Integer intTxtSorteio4;
        Integer intTxtSorteio5;
        Integer intTxtSorteio6;

        intTxtSorteio1 = Integer.parseInt(txtSorteio1.getText().toString());
        intTxtSorteio2 = Integer.parseInt(txtSorteio2.getText().toString());
        intTxtSorteio3 = Integer.parseInt(txtSorteio3.getText().toString());
        intTxtSorteio4 = Integer.parseInt(txtSorteio4.getText().toString());
        intTxtSorteio5 = Integer.parseInt(txtSorteio5.getText().toString());
        intTxtSorteio6 = Integer.parseInt(txtSorteio6.getText().toString());


        if (intTxtSorteio1 == intTxtSorteio2) {
            txtSorteio1.setText(String.valueOf(randomNumber()));
            antiFraude();
        }

        if (intTxtSorteio1 == intTxtSorteio3) {
            txtSorteio1.setText(String.valueOf(randomNumber()));
            antiFraude();
        }

        if (intTxtSorteio1 == intTxtSorteio4) {
            txtSorteio1.setText(String.valueOf(randomNumber()));
            antiFraude();
        }
        if (intTxtSorteio1 == intTxtSorteio5) {
            txtSorteio1.setText(String.valueOf(randomNumber()));
            antiFraude();
        }
        if (intTxtSorteio1 == intTxtSorteio6) {
            txtSorteio1.setText(String.valueOf(randomNumber()));
            antiFraude();
        }


        //validação segundo campo
        if (intTxtSorteio2 == intTxtSorteio3) {
            txtSorteio2.setText(String.valueOf(randomNumber()));
            antiFraude();
        }
        if (intTxtSorteio2 == intTxtSorteio4) {
            txtSorteio2.setText(String.valueOf(randomNumber()));
            antiFraude();
        }
        if (intTxtSorteio2 == intTxtSorteio5) {
            txtSorteio2.setText(String.valueOf(randomNumber()));
            antiFraude();
        }
        if (intTxtSorteio2 == intTxtSorteio6) {
            txtSorteio2.setText(String.valueOf(randomNumber()));
            antiFraude();
        }
        //Validação terceiro campo
        if (intTxtSorteio3 == intTxtSorteio4) {
            txtSorteio3.setText(String.valueOf(randomNumber()));
            antiFraude();
        }
        if (intTxtSorteio3 == intTxtSorteio5) {
            txtSorteio3.setText(String.valueOf(randomNumber()));
            antiFraude();
        }
        if (intTxtSorteio3 == intTxtSorteio6) {
            txtSorteio3.setText(String.valueOf(randomNumber()));
            antiFraude();
        }

        //Quarto campo
        if (intTxtSorteio4 == intTxtSorteio5) {
            txtSorteio4.setText(String.valueOf(randomNumber()));
            antiFraude();
        }
        if (intTxtSorteio4 == intTxtSorteio6) {
            txtSorteio4.setText(String.valueOf(randomNumber()));
            antiFraude();
        }
        //quinto campo
        if (intTxtSorteio5 == intTxtSorteio6) {
            txtSorteio5.setText(String.valueOf(randomNumber()));
            antiFraude();
        }




    }
}

