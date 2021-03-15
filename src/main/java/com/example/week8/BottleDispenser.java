package com.example.week8;


import android.widget.TextView;

import java.util.ArrayList;


public class BottleDispenser {
    private int bottles;
    // The array for the Bottle-objects
    private double money;
    ArrayList<Bottle> bottlelist;
    private static BottleDispenser botdisp = null;


    // tässä määritelty 1 tehtävän vaatima singleton toiminto
    public static BottleDispenser getInstance() {
        if (botdisp == null){
           botdisp = new BottleDispenser();
        }
        return botdisp;
    }

    public BottleDispenser() {
        bottles = 5;
        money = 0;
        // Create the ArrayList
        bottlelist = new ArrayList<Bottle>();

        for (int i = 0;i<bottles;i++) {
            Bottle pullo = new Bottle();
            bottlelist.add(pullo);
        }

    }
    public void addMoney(TextView textfield, int seekMoney) {
        money = money + seekMoney;
        String massi = String.format("%.2f", money);
        textfield.setText("Klink! Added money! Balance: "+massi);
        //System.out.println("Klink! Added more money!");
        // 3 tehtävään lisätty seekMoneyn tuonti ja lisäys automaatin rahamäärään
    }

    public void buyBottle(TextView textfield) {

        int valinta = 0;

        if (bottles == 0) {
            //System.out.println("No bottles left!");
            textfield.setText("No bottles left!");
        }

        else if (money < bottlelist.get(valinta).getPrice()) {
            //System.out.println("Add money first!");
            textfield.setText("Add money first!");
        } else {
            //System.out.println("KACHUNK! "+bottlelist.get(valinta-1).getName()+" came out of the dispenser!");
            textfield.setText("KACHUNK! "+bottlelist.get(valinta).getName()+" came out of the dispencer!");
            money -= bottlelist.get(valinta).getPrice();
            bottlelist.remove(valinta);
            bottles -= 1;
        }
    }

    public void returnMoney(TextView textfield) {
        if (money == 0) {
            money = 0;
            //System.out.println("Klink klink. All money gone!");
            textfield.setText("Klink! Klink! All money gone!");
        } else {
            String raha = String.format("%.2f", money);
            //System.out.println("Klink klink. Money came out! You got "+raha+"€ back");
            textfield.setText("Klink klink. Money came out! You got "+ raha +"€ back");
            money = 0;
        }
    }
}