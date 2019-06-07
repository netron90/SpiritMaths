package com.applications.solutech.spiritmaths.Utilities;

import android.util.Log;

import com.applications.solutech.spiritmaths.Constants.SpiritMathConstant;

/**
 * Created by USER on 06/06/2019.
 */

public class SpiritMathMethod {

    public static String wordSignification(String wordToCalcul)
    {
        Character[] charactere = new Character[26];
        int[] textValueNumber = new int[0];
        int sommeTextIndex = 0;

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
                    Log.d("CORRECT", "Correct");
                    sommeTextIndex = sommeTextIndex + SpiritMathConstant.TAB_ALPHABET_INDICE[j];
                }
                else
                {
                    Log.d("INCORRECT", "InCorrect");
                }
            }

        }

        Log.d("SOMME INDEX", "La somme des nombres du texte est: " + sommeTextIndex);


        return String.valueOf(sommeTextIndex);
    }
}
