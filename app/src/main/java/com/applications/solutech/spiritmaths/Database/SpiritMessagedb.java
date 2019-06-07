package com.applications.solutech.spiritmaths.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by USER on 06/06/2019.
 */

@Database(entities = {SpiritMathNumber.class, MeaningHistory.class}, version = 1)
public abstract class SpiritMessagedb extends RoomDatabase {

    public abstract UserDao userDao();
}
