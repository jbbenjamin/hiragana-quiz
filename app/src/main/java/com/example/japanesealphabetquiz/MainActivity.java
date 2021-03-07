package com.example.japanesealphabetquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;
import java.util.Random;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView letterTextView;
    Map<String, String> hiraganaLetters;
    Random randGen;
    Object[] values;
    Object randomLetterObject;
    String letter;

    public void submit(View view){

        EditText editText = findViewById(R.id.guessEditText);

        Log.i("event", "button pressed");
        Log.i("hiraganaLetter", letter);
        Log.i("user's guess", editText.getText().toString());

        try{
            if(hiraganaLetters.get(editText.getText().toString()).equals(letter)){
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                letter = (String) values[randGen.nextInt(hiraganaLetters.size())];
                letterTextView.setText(letter);
                editText.setText(null);
            }
            else{
                Toast.makeText(this, "Sorry, try again", Toast.LENGTH_SHORT).show();
            }
        }
        catch (RuntimeException re){
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.guessEditText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    submit(findViewById(R.id.guessEditText));
                    handled = true;
                }
                return handled;
            }
        });

        hiraganaLetters = new HashMap<>();
        randGen = new Random();

        //hiraganaLetters = Map.of("a", "", "i", "", "u", "e", "", "o", "");
        hiraganaLetters.put("a", "あ");
        hiraganaLetters.put("i", "い");
        hiraganaLetters.put("u", "う");
        hiraganaLetters.put("e", "え");
        hiraganaLetters.put("o", "お");
        hiraganaLetters.put("ka", "か");
        hiraganaLetters.put("ki", "き");
        hiraganaLetters.put("ku", "く");
        hiraganaLetters.put("ke", "け");
        hiraganaLetters.put("ko", "こ");
        hiraganaLetters.put("sa", "さ");
        hiraganaLetters.put("shi", "し");
        hiraganaLetters.put("su", "す");
        hiraganaLetters.put("se", "せ");
        hiraganaLetters.put("so", "そ");
        hiraganaLetters.put("ta", "た");
        hiraganaLetters.put("chi", "ち");
        hiraganaLetters.put("tsu", "つ");
        hiraganaLetters.put("te", "て");
        hiraganaLetters.put("to", "と");
        hiraganaLetters.put("na", "な");
        hiraganaLetters.put("ni", "に");
        hiraganaLetters.put("nu", "ぬ");
        hiraganaLetters.put("ne", "ね");
        hiraganaLetters.put("no", "の");
        hiraganaLetters.put("ha", "は");
        hiraganaLetters.put("hi", "ひ");
        hiraganaLetters.put("fue", "ふ");
        hiraganaLetters.put("he", "へ");
        hiraganaLetters.put("ho", "ほ");
        hiraganaLetters.put("ma", "ま");
        hiraganaLetters.put("mi", "み");
        hiraganaLetters.put("mu", "む");
        hiraganaLetters.put("me", "め");
        hiraganaLetters.put("mo", "も");
        hiraganaLetters.put("ya", "や");
        hiraganaLetters.put("yu", "ゆ");
        hiraganaLetters.put("yo", "よ");

        values = hiraganaLetters.values().toArray();
        randomLetterObject = values[randGen.nextInt(hiraganaLetters.size())];
        letter = (String) randomLetterObject;
        letterTextView = findViewById(R.id.letterTextView);
        letterTextView.setText(letter);
    }
}