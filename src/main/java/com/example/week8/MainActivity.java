package com.example.week8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button addMoneyButton;
    Button buyBottleButton;
    Button returnMoneyButton;
    TextView textfield;
    SeekBar seekBar;
    TextView sbview;
    BottleDispenser dispenser;
    int SeekMoney = 0;
    // 3 tehtävään määritelty seekbar ja toinen tekstikenttä lisäksi
    // lisäksi seekMoney määritelty  seekBarin summan lähettämiseen Bottledispenserille


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dispenser = BottleDispenser.getInstance();
        
        addMoneyButton = findViewById(R.id.addMoney);
        buyBottleButton = findViewById(R.id.buyBottle);
        returnMoneyButton = findViewById(R.id.returnMoney);
        textfield = findViewById(R.id.textView);
        seekBar = findViewById(R.id.seekBar);
        sbview = findViewById(R.id.seekBarAmount);


        seekBar.setMax(20);
        // maximum amount to add is set to 20€
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
             SeekMoney = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                sbview.setText("Adding: "+ seekBar.getProgress()+ "€");

            }
        });

        buyBottleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispenser.buyBottle(textfield);

            }

        });

        addMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispenser.addMoney(textfield, SeekMoney);
                seekBar.setProgress(0);
                sbview.setText("Move the bar to add money");

            }

        });

        returnMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispenser.returnMoney(textfield);

            }

        });

    }
}
