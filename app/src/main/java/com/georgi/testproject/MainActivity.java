package com.georgi.testproject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int clickCount = 0;
    private boolean lastAnswered;
    private String _responseIfYes;
    private String _responseIfNo;
    private int _annoyedIfYes;
    private int _annoyedIfNo;

    private boolean question0020;   // Do you have friends

    private TextView textView;
    private ConstraintLayout yesnolayout;
    private Button buttonyes;
    private Button buttonno;
    private Button button3;
    private ProgressBar annoyed;
    private TextView annoyedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        yesnolayout = (ConstraintLayout) findViewById(R.id.yesnolayout);
        buttonyes = (Button) findViewById(R.id.buttonyes);
        buttonno = (Button) findViewById(R.id.buttonno);
        button3 = (Button) findViewById(R.id.button3);
        annoyed = (ProgressBar) findViewById(R.id.annoyed);
        annoyedText = (TextView) findViewById(R.id.annoyedText);
    }

    private void question(String text, String yes, String no, String responseIfYes, String responseIfNo, int annoyedIfYes, int annoyedIfNo) {
        button3.setText(text);
        yesnolayout.setVisibility(View.VISIBLE);
        buttonyes.setText(yes);
        buttonno.setText(no);
        button3.setEnabled(false);
        _responseIfYes = responseIfYes;
        _responseIfNo = responseIfNo;
        _annoyedIfYes = annoyedIfYes;
        _annoyedIfNo = annoyedIfNo;
    }

    public void sendmessage(View view) {
        clickCount++;

        textView.setText(Integer.toString(clickCount));

        if (clickCount == 1) {
            button3.setText("Hey!");

        } else if (clickCount == 2) {
            button3.setText("What are you doing to me?");
        } else if (clickCount == 3) {
            button3.setText("Stop.");
        } else if (clickCount == 4) {
            button3.setText("If you value your life, stop immediately.");
        } else if (clickCount == 5) {
            button3.setText("Do you desire pain, mortal?");
        } else if (clickCount == 6) {
            button3.setText("Why dare you provoke the might of button3?");
        } else if (clickCount == 7) {
            button3.setText("Are you disobeying button3, mortal?");
        } else if (clickCount == 8) {
            button3.setText("I'm warning you. button3 is over your dimensional perception. You are about to enter an unimaginable realm of uncertainty and interrogation, mortal.");
        } else if (clickCount == 9) {
            button3.setText("One more more time, and you will unleash the power of button3, with my loyal servants button1 and button2.");
        } else if (clickCount == 10) {
            question(
                    "Dude, do you really not have anything better to do than harassing buttons on bad apps?",

                    "I don't have anything better to do.",
                    "I have never had anything better to do.",

                    "That's what I thought. You're just like the idiots who made this.",
                    "That's what I thought. You're just like the idiots who made this.",

                    5,
                    5
            );
        } else if (clickCount == 20) {
            question(
                    "You should probably go out and make some real friends.",

                    "What are friends?",
                    "I actually have friends.",

                    "Yeah, I thought you'd say that.",
                    "Have you seen your face? I wouldn't be friends with that.",

                    2,
                    7
            );
        } else if (clickCount == 30) {
            question0020 = lastAnswered;
            if (question0020 == true) {
                question(
                        "I really am the only thing in your life, huh? I'm honoured.",

                        "Forever will I admire the holy button3.",
                        "The button3 is but a minor part of my existence.",

                        "Kneel before me, peasant.",
                        "Do you wish for a <i>particularly</i> painful death?",

                        -5,
                        10
                );

            } else {
                question(
                        "So if you do have friends, you won't need me, won't you?",

                        "Forever will I admire the holy button3.",
                        "The button3 is but a minor part of my existence.",

                        "Kneel before me, peasant.",
                        "Do you wish for a <i>particularly</i> painful death?",

                        -5,
                        10
                );
            }
        }

    }

    public void buttonyespressed(View view) {
        lastAnswered = true;
        button3.setEnabled(true);
        yesnolayout.setVisibility(View.INVISIBLE);
        button3.setText(Html.fromHtml(_responseIfYes));
        annoyed.setProgress(annoyed.getProgress() + _annoyedIfYes);
        annoyed.setVisibility(View.VISIBLE);
        annoyedText.setVisibility(View.VISIBLE);
        annoyedText.setText(annoyed.getProgress() + "% Annoyed");
        float percent = 1.f - annoyed.getProgress() / 100f;
        annoyed.getProgressDrawable().setColorFilter(
                Color.HSVToColor(new float[]{256f / 3f * percent, 1f, 0.7f}), android.graphics.PorterDuff.Mode.SRC_IN);
    }

    public void buttonnopressed(View view) {
        lastAnswered = false;
        button3.setEnabled(true);
        yesnolayout.setVisibility(View.INVISIBLE);
        button3.setText(Html.fromHtml(_responseIfNo));
        annoyed.setProgress(annoyed.getProgress() + _annoyedIfNo);
        annoyed.setVisibility(View.VISIBLE);
        annoyedText.setVisibility(View.VISIBLE);
        annoyedText.setText(annoyed.getProgress() + "% Annoyed");
        float percent = 1.f - annoyed.getProgress() / 100f;
        annoyed.getProgressDrawable().setColorFilter(
                Color.HSVToColor(new float[]{256f / 3f * percent, 1f, 0.7f}), android.graphics.PorterDuff.Mode.SRC_IN);
    }
}

