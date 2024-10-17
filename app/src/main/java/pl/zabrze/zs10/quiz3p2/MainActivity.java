package pl.zabrze.zs10.quiz3p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView textViewPytanie;
    private Button buttonT;
    private Button buttonN;
    private Button buttonNastepne;
    private Button buttonPodpowiedz;
    private ArrayList<Pytanie> pytania = new ArrayList<>();
    private int numerWyswietlanegoPytania = 0;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPytanie = findViewById(R.id.textViewPytanie);
        buttonT = findViewById(R.id.buttonTak);
        buttonN = findViewById(R.id.buttonNie);
        buttonNastepne = findViewById(R.id.button4);
        buttonPodpowiedz= findViewById(R.id.button3);
        imageView = findViewById(R.id.imageView);

        pytania.add(new Pytanie("Czy Niedźwiedż polarny je pingwiny?",
                false,
                "Zastanów się gdzie każde zwierze żyje",
                R.drawable.niedzwiedz));
        pytania.add(new Pytanie("Czy żyrafa może polizać się po uchu?",
                true,
                "Żyrafy mają bardzo długi język",
                R.drawable.zyrafa));
        pytania.add(new Pytanie("Czy zebry śpią na leząco?",
                false,
                "Z???",
                R.drawable.zebra));

       wyswietlPytanie(0);
        buttonT.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(pytania.get(numerWyswietlanegoPytania).isPoprawnaOdpowiedz()){
                            pytania.get(numerWyswietlanegoPytania).setCzyOdpowiedzianoPoprawnie(true);
                            Toast.makeText(MainActivity.this, "dobra odpowiedz", Toast.LENGTH_SHORT).show();
                        }
                        else {

                            Toast.makeText(MainActivity.this,
                                    "Zła odpowiedź",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        buttonN.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!pytania.get(numerWyswietlanegoPytania).isPoprawnaOdpowiedz()){
                            pytania.get(numerWyswietlanegoPytania).setCzyOdpowiedzianoPoprawnie(true);
                            Toast.makeText(MainActivity.this,
                                    "dobra odpowiedz", Toast.LENGTH_SHORT)
                                    .show();
                        }
                        else {

                            Toast.makeText(MainActivity.this,
                                    "Zła odpowiedź",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );


        buttonNastepne.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        numerWyswietlanegoPytania++;
                        if(numerWyswietlanegoPytania == pytania.size()){
                            buttonT.setVisibility(View.INVISIBLE);
                            buttonN.setVisibility(View.INVISIBLE);
                            buttonNastepne.setVisibility(View.INVISIBLE);
                            buttonPodpowiedz.setVisibility(View.INVISIBLE);
                            textViewPytanie.setText("Dziękujemy za rozwiązanie testu \n" +
                                    "wynik: "+String.valueOf(podliczPunktyZaTest()));
                        }
                        else {
                           wyswietlPytanie(numerWyswietlanegoPytania);
                        }

                    }
                }
        );

    }

    private int podliczPunktyZaTest(){
        int suma =0 ;
        for (Pytanie pytanko:pytania) {
            if(pytanko.isCzyOdpowiedzianoPoprawnie()){
                suma++;
            }
        }
        return suma;
    }
private void wyswietlPytanie(int i){
        textViewPytanie.setText(pytania.get(i).getTresc());
    imageView.setImageResource(pytania.get(i).getIdObrazka());}
}