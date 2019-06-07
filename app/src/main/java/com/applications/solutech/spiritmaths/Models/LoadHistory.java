package com.applications.solutech.spiritmaths.Models;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.applications.solutech.spiritmaths.Database.MeaningHistory;
import com.applications.solutech.spiritmaths.Database.SpiritMessagedb;
import com.applications.solutech.spiritmaths.HistoryActivity;
import com.applications.solutech.spiritmaths.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 06/06/2019.
 */

public class LoadHistory extends AsyncTask<Void, Void, List<MeaningHistory>> {

    public static List<MeaningHistory> meaningHistory = new ArrayList<>();

    @Override
    protected List<MeaningHistory> doInBackground(Void... voids) {
        final SpiritMessagedb db = Room.databaseBuilder(MainActivity.context,
                SpiritMessagedb.class, "spirit_math").build();

        List<MeaningHistory> s = db.userDao().getHistory();

        db.close();
        return s ;
    }

    @Override
    protected void onPostExecute(List<MeaningHistory> meaningHistories) {
        super.onPostExecute(meaningHistories);

        meaningHistory = meaningHistories;
        Intent intent = new Intent(MainActivity.context, HistoryActivity.class);
        MainActivity.context.startActivity(intent);
        //MainActivity.loadHistory = null;
    }
}
