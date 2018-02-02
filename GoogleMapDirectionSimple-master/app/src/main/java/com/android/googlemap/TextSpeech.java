package com.android.googlemap;


import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;


public class TextSpeech extends Activity implements OnInitListener  {
String txt;
    EditText tDestination = (EditText) findViewById(R.id.etDestination);
    private TextToSpeech tts;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        tts = new TextToSpeech(this, this);
        ((Button) findViewById(R.id.speak)).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
speakOut(tDestination.getText().toString());
            }
        });


    }

public TextSpeech(String text)
{
    this.txt = text;
}


    @Override
    public void onInit(int status) {
        // TODO Auto-generated method stub
        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.ENGLISH);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {

                //speakOut("Ich");
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }

    public void speakOut(String text) {

        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

}