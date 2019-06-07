package com.applications.solutech.spiritmaths.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by USER on 06/06/2019.
 */

@Dao
public interface UserDao {


    @Insert
    void insertSpiritNumberExplanation(MeaningHistory meaningHistory);

    @Query("SELECT * FROM meaning_history")
    List<MeaningHistory> getHistory();
}
