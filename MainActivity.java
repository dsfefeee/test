package com.example.matteo.prova1_button;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    /* ciclo di vita di un app:
       onCreate()
       onStart()
       onResume()
       Activity Running
       onPause()
       onStop()
       onDestroy()
     */


    //creo delle variabili per salvare gli States
    private SharedPreferences mPrefs;
    private String mCurViewMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                         //cosa succede quando si clicca sul bottone
                TextView tv = (TextView) findViewById(R.id.Tw1);
                tv.setText("ciao rafa");
                System.out.println("sei un grande");  //stampa nella casella "Logcat" in basso negli output di sistema
                Log.d("Click","Hai cliccato");
                //tipi di log(messaggi) di debug: d(debug),e(error),i(info),w(warn),....     output sistema Logcat - UTILISSIMI PER FARE IL DEBUG!!!
            }
        });

        /* tutte le volte che lo schermo del telefono ruota, L'APP RIPARTE DALL'INIZIO (ritorna a onCreate())
           bisogna salvare lo State
           https://developer.android.com/reference/android/app/Activity.html
         */


        //imposto il valore della Textview con quello passato
        mPrefs = getSharedPreferences("referenze",MODE_PRIVATE);
        mCurViewMode = mPrefs.getString("view_mode", "Hello World!");
        TextView tv = (TextView) findViewById(R.id.Tw1);
        tv.setText(mCurViewMode);



    }






    @Override
    protected void onPause() {
        super.onPause();

        //salvo lo States e TUTTI i valori
        SharedPreferences.Editor ed = mPrefs.edit();
        TextView tv = (TextView) findViewById(R.id.Tw1);
        ed.putString("view_mode", tv.getText().toString());
        ed.commit();
    }
}
