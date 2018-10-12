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
        // Asignacion de valores para la interfas
        txtnum = new TextView[6]; // Tamaño de la lista de valores
        txtnum[0] = (TextView)findViewById(R.id.textView1); //Asignacion de posicion del primer valor de la lista
        txtnum[1] = (TextView)findViewById(R.id.textView2);
        txtnum[2] = (TextView)findViewById(R.id.textView3);
        txtnum[3] = (TextView)findViewById(R.id.textView4);
        txtnum[4] = (TextView)findViewById(R.id.textView5);
        txtnum[5] = (TextView)findViewById(R.id.textView6);
        // Colocacion de cada valor
        for(int i=0; i<numeros.length; i++){
            txtnum[i].setText(String.valueOf(numeros[i]));
        }
        // Boton que ejecuta Selection Sort
        ((TextView)findViewById(R.id.ssort)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectionSort(0);
            }
        });
        // Boton que ejecuta desarregar
        ((TextView)findViewById(R.id.Desarreglar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desarreglar();
            }
        });
        // Boton que ejecuta Bubble Sort
        ((TextView)findViewById(R.id.bsort)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loop = 0;
                BubbleSort(0, 1);
            }
        });
    }

    /**
     * Metodo que vulve la lista al estado inicial
     */
    public void desarreglar(){
        int []numeros = {9,5,1,8,3,0};
        for(int i=0; i<numeros.length; i++){
            txtnum[i].setText(String.valueOf(numeros[i]));
        }
    }

    /**
     * Metodo que ordena la lista mediante bubblesort
     * @param m: primer valor
     * @param n: segundo valor
     */
    public void BubbleSort(final int m, final int n){
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                if(Integer.valueOf(txtnum[m].getText().toString())>Integer.valueOf(txtnum[n].getText().toString())){
                    String temp = txtnum[m].getText().toString();
                    txtnum[m].setText(txtnum[n].getText().toString());
                    txtnum[n].setText(temp);
                }
                int j = n+1;
                int i = m+1;
                if(j==numeros.length-loop){
                    i = 0;
                    j = i+1;
                    loop++;
                }
                if(loop<numeros.length-1){
                    BubbleSort(i, j);
                }
            }
        },500);
    }

    /**
     * Metodo que ordena la lista mediante selectiosort
     * @param m: valor
     */
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
        },1000);
        n = findmin(m+1);
    }

    /**
     * Metodo que verifica que la lista esta ordenada
     * @param v
     * @return mi
     */
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

