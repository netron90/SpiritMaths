package com.applications.solutech.spiritmaths.Models;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import com.applications.solutech.spiritmaths.Constants.*;
import com.applications.solutech.spiritmaths.MainActivity;

/**
 * Created by USER on 06/06/2019.
 */

public class SpiritMathModel extends AsyncTask<String, Void, String>{
    public static String finalResultTextNumber = "";
    public static int divideValue = 0;
    public static int significationWord = 0;


    @Override
    protected String doInBackground(String... charSequence) {
        String finalStatemet = "";

        finalStatemet = wordSignification(charSequence[0]);
        return finalStatemet;
    }

    @Override
    protected void onPostExecute(String str) {
        super.onPostExecute(str);
        finalResultTextNumber = str;
        Log.d("WORD", "On Post excecute" + str);
        if(Integer.valueOf(finalResultTextNumber) == 0)
        {
            MainActivity.spiritMathTextValue.setText(SpiritMathConstant.NO_TEXT_VALUE_YET);
            MainActivity.spiritMathProgessBar.setVisibility(View.GONE);
        }else{
            MainActivity.spiritMathTextValue.setText(SpiritMathConstant.STATEMENT_NUMBER + finalResultTextNumber);
            MainActivity.spiritMathProgessBar.setVisibility(View.GONE);
        }


    }

    public String wordSignification(String wordToCalcul)
    {
        Character[] charactere = new Character[26];
        int[] textValueNumber = new int[0];
        int sommeTextIndex = 0;
        divideValue = 0;

        for(int i = 0; i < wordToCalcul.length(); i++)
        {
            //caractere[i] = wordToCalcul[i];

            charactere[i] = wordToCalcul.charAt(i);
            Log.d("WORD", "This is each word: " + charactere[i]);
            for(int j = 0; j < SpiritMathConstant.TAB_ALPHABET_UPPERCASE.length; j++)
            {
                if((charactere[i].equals(SpiritMathConstant.TAB_ALPHABET[j]) && j+1 == SpiritMathConstant.TAB_ALPHABET_INDICE[j])
                        || (charactere[i].equals(SpiritMathConstant.TAB_ALPHABET_UPPERCASE[j]) && j+1 == SpiritMathConstant.TAB_ALPHABET_INDICE[j]))
                {

                    sommeTextIndex = sommeTextIndex + SpiritMathConstant.TAB_ALPHABET_INDICE[j];
                    significationWord = sommeTextIndex;
                    if(sommeTextIndex % 9 < 9)
                    {
                        Log.d("MODULO", "Modulo < 9: " + sommeTextIndex % 9);
                        divideValue = sommeTextIndex;
                    }
                    else {
                        Log.d("MODULO", "Modulo > 9 " + sommeTextIndex % 9);
                        divideValue = sommeTextIndex % 9;
                    }
                }
                else
                {
                   // Log.d("INCORRECT", "InCorrect");
                }
            }

        }

        Log.d("SOMME INDEX", "La somme des nombres du texte est: " + divideValue);


        return String.valueOf(divideValue);
    }
}
