package com.applications.solutech.spiritmaths.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by USER on 06/06/2019.
 */

@Entity
public class SpiritMathNumber {


    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "number")
    public int number;

    @ColumnInfo(name = "explanation")
    public String explamation;

    public SpiritMathNumber() {
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getExplamation() {
        return explamation;
    }
}
