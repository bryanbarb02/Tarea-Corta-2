package com.bryanbarb.ordenamiento;

import android.opengl.Visibility;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView [] txtnum;
    private int []numeros = {9,5,1,8,3,0};
    private Handler handler = new Handler();
    int loop = 0, n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnum = new TextView[6];
        txtnum[0] = (TextView)findViewById(R.id.textView1);
        txtnum[1] = (TextView)findViewById(R.id.textView2);
        txtnum[2] = (TextView)findViewById(R.id.textView3);
        txtnum[3] = (TextView)findViewById(R.id.textView4);
        txtnum[4] = (TextView)findViewById(R.id.textView5);
        txtnum[5] = (TextView)findViewById(R.id.textView6);

        for(int i=0; i<numeros.length; i++){
            txtnum[i].setText(String.valueOf(numeros[i]));
        }
        ((TextView)findViewById(R.id.ssort)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectionSort(0);
            }
        });

        ((TextView)findViewById(R.id.Desarreglar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desarreglar();
            }
        });
    }

    public void desarreglar(){
        int []numeros = {9,5,1,8,3,0};
        for(int i=0; i<numeros.length; i++){
            txtnum[i].setText(String.valueOf(numeros[i]));
        }
    }

    public void SelectionSort(final int m){
        handler.postDelayed(new Runnable() {
            public void run(){
                if (Integer.valueOf(txtnum[m].getText().toString()) > Integer.valueOf(txtnum[n].getText().toString())) {
                    String temp = txtnum[m].getText().toString();
                    txtnum[m].setText(txtnum[n].getText().toString());
                    txtnum[n].setText(temp);
                }
                int i = m + 1;
                if (i < numeros.length - 1) {
                    SelectionSort(i);
                }
            }
        },3000);
        n = findmin(m+1);
    }

    int findmin(int v){
        int mi = v;
        for(int k=v+1; k<numeros.length; k++){
            if(Integer.valueOf(txtnum[k].getText().toString())<Integer.valueOf(txtnum[mi].getText().toString())){
                mi=k;
            }
        }
        return mi;
    }
}

