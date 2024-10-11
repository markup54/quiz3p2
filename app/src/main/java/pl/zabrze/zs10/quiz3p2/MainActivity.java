package pl.zabrze.zs10.quiz3p2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPytanie = findViewById(R.id.textViewPytanie);
        buttonT = findViewById(R.id.buttonTak);
        buttonN = findViewById(R.id.buttonNie);
        buttonNastepne = findViewById(R.id.button4);
        buttonPodpowiedz= findViewById(R.id.button3);


        pytania.add(new Pytanie("Czy Niedźwiedż polarny je pingwiny?",
                false,
                "Zastanów się gdzie każde zwierze żyje"));
        pytania.add(new Pytanie("Czy żyrafa może polizać się po uchu?",
                true,
                "Żyrafy mają bardzo długi język"));
        pytania.add(new Pytanie("Czy zebry śpią na leząco?",
                false,
                "Z???"));

        textViewPytanie.setText(pytania.get(0).getTresc());
        buttonT.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,
                                "Wybrano tak",
                                Toast.LENGTH_SHORT).show();
                    }
                }
        );


        buttonNastepne.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        numerWyswietlanegoPytania++;
                        if(numerWyswietlanegoPytania == pytania.size()){
                            //TODO: znikanie przyciskow komunikat
                            buttonT.setVisibility(View.INVISIBLE);
                            buttonN.setVisibility(View.INVISIBLE);
                            buttonNastepne.setVisibility(View.INVISIBLE);
                            buttonPodpowiedz.setVisibility(View.INVISIBLE);
                            textViewPytanie.setText("Dziękujemy za rozwiązanie testu wyniki pojawią się wkrótce");
                        }
                        else {
                            textViewPytanie.setText(pytania.get(numerWyswietlanegoPytania).getTresc());
                        }

                    }
                }
        );

    }
}