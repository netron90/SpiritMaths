package com.applications.solutech.spiritmaths.Models;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;

import com.applications.solutech.spiritmaths.Adapters.HistoryAdapter;
import com.applications.solutech.spiritmaths.Database.MeaningHistory;
import com.applications.solutech.spiritmaths.Database.SpiritMessagedb;
import com.applications.solutech.spiritmaths.HistoryActivity;
import com.applications.solutech.spiritmaths.MainActivity;

/**
 * Created by USER on 06/06/2019.
 */

public class SaveHistory extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... voids) {
        final SpiritMessagedb db = Room.databaseBuilder(MainActivity.context,
                SpiritMessagedb.class, "spirit_math").build();

        MeaningHistory meaningHistory = new MeaningHistory();
        meaningHistory.value = SpiritMathModel.significationWord;
        meaningHistory.statementText = MainActivity.spiritMathStatementText.getText().toString();
        meaningHistory.numberExplanation = MainActivity.spiritMathTextExplanation.getText().toString();
        db.userDao().insertSpiritNumberExplanation(meaningHistory);
        db.close();

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(HistoryActivity.historyAdapter != null)
        {
            HistoryActivity.historyAdapter.notifyDataSetChanged();
        }
    }
}

