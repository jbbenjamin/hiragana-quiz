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
        hiraganaLetters.put("a", "???");
        hiraganaLetters.put("i", "???");
        hiraganaLetters.put("u", "???");
        hiraganaLetters.put("e", "???");
        hiraganaLetters.put("o", "???");
        hiraganaLetters.put("ka", "???");
        hiraganaLetters.put("ki", "???");
        hiraganaLetters.put("ku", "???");
        hiraganaLetters.put("ke", "???");
        hiraganaLetters.put("ko", "???");
        hiraganaLetters.put("sa", "???");
        hiraganaLetters.put("shi", "???");
        hiraganaLetters.put("su", "???");
        hiraganaLetters.put("se", "???");
        hiraganaLetters.put("so", "???");
        hiraganaLetters.put("ta", "???");
        hiraganaLetters.put("chi", "???");
        hiraganaLetters.put("tsu", "???");
        hiraganaLetters.put("te", "???");
        hiraganaLetters.put("to", "???");
        hiraganaLetters.put("na", "???");
        hiraganaLetters.put("ni", "???");
        hiraganaLetters.put("nu", "???");
        hiraganaLetters.put("ne", "???");
        hiraganaLetters.put("no", "???");
        hiraganaLetters.put("ha", "???");
        hiraganaLetters.put("hi", "???");
        hiraganaLetters.put("fue", "???");
        hiraganaLetters.put("he", "???");
        hiraganaLetters.put("ho", "???");
        hiraganaLetters.put("ma", "???");
        hiraganaLetters.put("mi", "???");
        hiraganaLetters.put("mu", "???");
        hiraganaLetters.put("me", "???");
        hiraganaLetters.put("mo", "???");
        hiraganaLetters.put("ya", "???");
        hiraganaLetters.put("yu", "???");
        hiraganaLetters.put("yo", "???");

        values = hiraganaLetters.values().toArray();
        randomLetterObject = values[randGen.nextInt(hiraganaLetters.size())];
        letter = (String) randomLetterObject;
        letterTextView = findViewById(R.id.letterTextView);
        letterTextView.setText(letter);
    }
}