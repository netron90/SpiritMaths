package com.applications.solutech.spiritmaths.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.applications.solutech.spiritmaths.Database.MeaningHistory;
import com.applications.solutech.spiritmaths.MainActivity;
import com.applications.solutech.spiritmaths.Models.LoadHistory;
import com.applications.solutech.spiritmaths.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 06/06/2019.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private List<MeaningHistory> meaningHistoryList = new ArrayList<>();

    public HistoryAdapter(List<MeaningHistory> meaningHistories){
        this.meaningHistoryList = meaningHistories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_model,
                null, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.numeroHistory.setText(MainActivity.context.getResources().getString(R.string.numero_history, LoadHistory.meaningHistory.get(position).getId()));
        holder.valeurMeaning.setText(MainActivity.context.getResources().getString(R.string.valeur_history, LoadHistory.meaningHistory.get(position).getValue()));
        holder.explanationText.setText(LoadHistory.meaningHistory.get(position).getNumberExplanation());
        holder.statementText.setText(LoadHistory.meaningHistory.get(position).getStatementText());
    }

    @Override
    public int getItemCount() {
        return meaningHistoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView numeroHistory;
        private TextView valeurMeaning;
        private TextView statementText;
        private TextView explanationText;

        public ViewHolder(View itemView) {
            super(itemView);

            numeroHistory = (TextView) itemView.findViewById(R.id.numero_history);
            valeurMeaning = (TextView) itemView.findViewById(R.id.value_history);
            statementText = (TextView) itemView.findViewById(R.id.content_meaning);
            explanationText = (TextView) itemView.findViewById(R.id.text_meaning);
        }
    }
}
