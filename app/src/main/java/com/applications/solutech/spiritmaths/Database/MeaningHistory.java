package com.applications.solutech.spiritmaths.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by USER on 06/06/2019.
 */

@Entity(tableName = "meaning_history")
public class MeaningHistory {

    @PrimaryKey(autoGenerate = true)
    public int id;


    @ColumnInfo(name = "value")
    public int value;


    @ColumnInfo(name = "number_explanation")
    public String numberExplanation;

    @ColumnInfo(name = "statement_text")
    public String statementText;

    public MeaningHistory() {
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public String getNumberExplanation() {
        return numberExplanation;
    }

    public String getStatementText() {
        return statementText;
    }
}
