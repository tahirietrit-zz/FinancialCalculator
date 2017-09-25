package com.example.financialcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    EditText shumaEditText;
    EditText periudhaEditText;
    EditText interesiEditText;
    TextView rataTextView;
    TextView kthimiTotatlTextView;
    Button llogaritButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shumaEditText = (EditText) findViewById(R.id.shuma_kerkuar);
        periudhaEditText = (EditText) findViewById(R.id.muajt_edittext);
        interesiEditText = (EditText) findViewById(R.id.interesi_edittext);

        kthimiTotatlTextView = (TextView) findViewById(R.id.kthimitotal_textview);
        llogaritButton = (Button) findViewById(R.id.kalkulo_button);
        llogaritButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    rataTextView.setText("Rata: " + llogaritRaten());
                    rataTextView = (TextView) findViewById(R.id.rata_textview);
                }catch (NullPointerException e){
                    rataTextView = (TextView) findViewById(R.id.rata_textview);
                    rataTextView.setText("Rata: " + llogaritRaten());

                }
                Toast.makeText(getApplicationContext(), "Mbushni fushat para se te vazhdojme", Toast.LENGTH_SHORT).show();
                kthimiTotatlTextView.setText("Total per kthim: " + getShumaTotale());
            }
        });
    }
    double llogaritRaten(){
        double p1 = getShuma() * getInteresi();
        double p2 = (1 - Math.pow((1 + getInteresi()), -getPeriudha()));
        double rata = p1 / p2;
        return rata;
    }

    public double getShumaTotale() {
        return llogaritRaten() * getPeriudha();
    }

    public double getShuma() {
        try{
        return Double.parseDouble(shumaEditText.getText().toString());
        }catch (Exception e){
            return 0;
        }
    }

    public double getPeriudha() {
        try{
            return Double.parseDouble(periudhaEditText.getText().toString());
        }catch (Exception e){
            return 0;
        }
    }

    public double getInteresi() {
        try{
            double d = Double.parseDouble(interesiEditText.getText().toString());
            return (d / 100) / 12;
        }catch (Exception e){
            return 0;
        }

    }

}
