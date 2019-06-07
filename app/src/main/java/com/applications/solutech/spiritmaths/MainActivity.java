package com.applications.solutech.spiritmaths;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.applications.solutech.spiritmaths.Constants.SpiritMathConstant;
import com.applications.solutech.spiritmaths.Database.MeaningHistory;
import com.applications.solutech.spiritmaths.Database.SpiritMessagedb;
import com.applications.solutech.spiritmaths.Models.LoadHistory;
import com.applications.solutech.spiritmaths.Models.SaveHistory;
import com.applications.solutech.spiritmaths.Models.SpiritMathModel;
import com.applications.solutech.spiritmaths.Utilities.SpiritMathMethod;


public class MainActivity extends AppCompatActivity {

    private Toolbar     spiritMathToolbar ;
    private ImageView   spiritMathImgDefault;
    private TextView    spiritMathImgTextDefault;
    public static TextView    spiritMathTextExplanation;
    public static TextView    spiritMathTextValue;
    public static ProgressBar spiritMathProgessBar;
    public static EditText    spiritMathStatementText;
    private Button      spiritMathGetResultButton;
    public static SpiritMathModel wordCalcul;
    public static SaveHistory saveHistory = null;
    public static  LoadHistory loadHistory;
    public static Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spiritMathToolbar         = (Toolbar) findViewById(R.id.toolbar);
        spiritMathImgDefault      = (ImageView) findViewById(R.id.img_no_spirit_value);
        spiritMathImgTextDefault  = (TextView)  findViewById(R.id.text_no_spirit_value);
        spiritMathTextExplanation = (TextView) findViewById(R.id.text_spirit_signification);
        spiritMathTextValue       = (TextView) findViewById(R.id.text_meaning);
        spiritMathProgessBar      = (ProgressBar) findViewById(R.id.progress_bar);
        spiritMathStatementText   = (EditText) findViewById(R.id.statement_edit_text);
        spiritMathGetResultButton = (Button) findViewById(R.id.btn_search_meaning);
        context = MainActivity.this;

        setSupportActionBar(spiritMathToolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));



        spiritMathStatementText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                spiritMathProgessBar.setVisibility(View.VISIBLE);

                //Start background task for begin word signification

                spiritMathProgessBar.setVisibility(View.GONE);
                if(wordCalcul != null)
                {
                    wordCalcul.cancel(true);
                    wordCalcul = null;
                }
                wordCalcul = new SpiritMathModel();
                //Log.d("Editable", "Editable word: " + charSequence.toString());
                wordCalcul.execute(charSequence.toString());
                spiritMathProgessBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                spiritMathProgessBar.setVisibility(View.VISIBLE);
            }
        });

        spiritMathGetResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //spiritMathStatementText.setText("");
                if (SpiritMathModel.significationWord == 1)
                {
                    saveHistory = new SaveHistory();
                    saveHistory.execute();
                    spiritMathImgDefault.setVisibility(View.GONE);
                    spiritMathImgTextDefault.setVisibility(View.GONE);
                    spiritMathTextExplanation.setText("GOD");
                    spiritMathTextExplanation.setVisibility(View.VISIBLE);
                }
                else{
                    saveHistory = new SaveHistory();
                    saveHistory.execute();
                    spiritMathImgDefault.setVisibility(View.GONE);
                    spiritMathImgTextDefault.setVisibility(View.GONE);
                    spiritMathTextExplanation.setText("No signification");
                    spiritMathTextExplanation.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.refresh)
        {
            spiritMathProgessBar.setVisibility(View.GONE);
            spiritMathStatementText.setText("");
            spiritMathImgDefault.setVisibility(View.VISIBLE);
            spiritMathImgTextDefault.setVisibility(View.VISIBLE);
            spiritMathTextExplanation.setVisibility(View.GONE);
            spiritMathTextValue.setText(SpiritMathConstant.NO_TEXT_VALUE_YET);
        }
        if(item.getItemId() == R.id.history)
        {
            loadHistory = new LoadHistory();
            loadHistory.execute();

        }
        return super.onOptionsItemSelected(item);
    }


}
