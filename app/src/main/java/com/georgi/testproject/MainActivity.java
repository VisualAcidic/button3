package com.georgi.testproject;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.DisplayMetrics;
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
    private boolean direction = true;
    private int distance;
    private int width;


    private boolean question0020;// Do you have friends
    private boolean question0030;
    private boolean question0040;
    private boolean question0050;


    private TextView textView;
    private ConstraintLayout yesnolayout;
    private Button buttonyes;
    private Button buttonno;
    private Button button3;
    private Button buttonhidden1;
    private TextView button3overlay;
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
        buttonhidden1 = (Button) findViewById(R.id.buttonhidden1);
        button3overlay = (TextView) findViewById(R.id.button3overlay);
        annoyed = (ProgressBar) findViewById(R.id.annoyed);
        annoyedText = (TextView) findViewById(R.id.annoyedText);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;
        distance = button3.getWidth();

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

    private void annoy(int annoyance) {
        annoyed.setVisibility(View.VISIBLE);
        annoyedText.setVisibility(View.VISIBLE);
        annoyed.setProgress(annoyed.getProgress() + annoyance);
        annoyedText.setText(annoyed.getProgress() + "% Annoyed");
        float percent = 1.f - annoyed.getProgress() / 100f;
        annoyed.getProgressDrawable().setColorFilter(
                Color.HSVToColor(new float[]{256f / 3f * percent, 1f, 0.7f}), android.graphics.PorterDuff.Mode.SRC_IN);
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

                        "I actually won't. No idea what I'm doing here.",
                        "What are you talking about? I can be friends with a robot.",

                        "Then go. I'm not stopping you. I could, though...",
                        "<b>I am not a mere <i>robot</i>! I am a deity far above any human cognition!</b>",

                        5,
                        20
                );
            }
        } else if (clickCount == 40) {
            question0030 = lastAnswered;

            if (question0020 == false && question0030 == false) {
                question(
                        "You called me a robot. I now officially hate you.",

                        "Feeling's mutual, mate.",
                        "I'm sorry! I should have never angered the mighty button3!",

                        "You're not allowed to hate a <b>god</b>. Who do you think you are?",
                        "That's what I like to hear.",

                        10,
                        -5
                );
            }
            if (question0020 == false && question0030 == true) {
                question(
                        "So why haven't you gone yet? I have slaves to tend to. Unless you want to become one of them.",

                        "Why would such a powerful deity like yourself have the need for slaves?",
                        "I find it amusing watching you rant like a mere human.",

                        "Amusement.",
                        "I don't rant, I contemplate. And I'll pretend I didn't hear that. 'Mere humans' would have been blasted for such blasphemy. You're lucky I like you.",

                        0,
                        15
                );
            }
            if (question0020 == true && question0030 == true) {
                question(
                        "If you like me so much, how would you like becoming one of my personal slaves?",

                        "Why would such a powerful deity like yourself have the need for slaves?",
                        "Meh. I'll pass",

                        "Amusement.",
                        "Well then. If you say so.",

                        0,
                        5
                );
            }
            if (question0020 == true && question0030 == false) {
                question(
                        "If you're saying stuff like that, I might as well make you one of my slaves",

                        "Why would such a powerful deity like yourself have the need for slaves?",
                        "Meh. I'll pass",

                        "Amusement.",
                        "Okay. I'll just get you in your sleep.",

                        0,
                        10
                );
            }
        } else if (clickCount == 50) {
            question(
                    "Annoy me any more, and I'll make myself invisible for your inferior mind.",

                    "I think you're the inferior mind here.",
                    "Please don't leave me, button-senpai!",

                    "And like that, button3 vanished into the void of darkness, never to be perceived again by mortal eyes.",
                    "And like that, button3 vanished into the void of darkness, never to be perceived again by mortal eyes.",

                    12,
                    -3
            );
        } else if (clickCount == 51) {
            annoy(10);
            question(
                    "THAT WAS NOT SUPPOSED TO HAPPEN. MORTALS CANNOT PERCEIVE MY UNSEEN HAND.",

                    "Are you getting annoyed? (▀̿Ĺ̯▀̿ ̿)",
                    "*taunt*",

                    "Yes, I am. Sustain that behaviour, and you're sure to experience an incredibly painful death.",
                    "What did you say about my mother?! I'll have you blasted for that.",

                    12,
                    15
            );
        } else if (clickCount == 60) {
            button3.setText("Catch me!");

            buttonMove();
        } else if (clickCount == 61) {
            question(
                    "THAT WAS NOT SUPPOSED TO HAPPEN. MORTALS CANNOT PERCEIVE MY UNSEEN HAND.",

                    "Are you getting annoyed? (▀̿Ĺ̯▀̿ ̿)",
                    "*taunt*",

                    "Yes, I am. Sustain that behaviour, and you're sure to experience an incredibly painful death.",
                    "What did you say about my mother?! I'll have you blasted for that.",

                    12,
                    15
            );
        }

    }

    private void buttonMove() {
        Handler h = new Handler();
        h.postDelayed(new Runnable() {


            public void run() {
//change your text here
                annoyedText.setText(width + " " + button3.getX() + " " + Boolean.toString(direction) + " " + distance);
                distance = button3.getWidth();
                if (button3.getX() <= 0f) {
                    direction = false;
                }
                if (button3.getX() >= (float) width - distance) {
                    direction = true;
                }
                if (direction == true) {
                    button3.setX(button3.getX() - 20);
                }
                if (direction == false) {
                    button3.setX(button3.getX() + 20);
                }

                if (clickCount == 60) {
                    buttonMove();
                }
            }
        }, 30);
    }

    public void buttonyespressed(View view) {
        lastAnswered = true;
        button3.setText(Html.fromHtml(_responseIfYes));
        annoy(_annoyedIfYes);
        buttonYesNoPress();
    }

    public void buttonnopressed(View view) {
        lastAnswered = false;
        button3.setText(Html.fromHtml(_responseIfNo));
        annoy(_annoyedIfNo);
        buttonYesNoPress();
    }

    private void buttonYesNoPress() {
        button3.setEnabled(true);
        yesnolayout.setVisibility(View.INVISIBLE);
        if (clickCount == 50) {
            button3.setVisibility(View.INVISIBLE);
            button3overlay.setVisibility(View.VISIBLE);
            buttonhidden1.setVisibility(View.VISIBLE);
            button3overlay.setText("And like that, button3 vanished into the void of darkness, never to be perceived again by mortal eyes.");
        }
    }

    public void buttonhiddenpressed(View view) {
        button3.setVisibility(View.VISIBLE);
        buttonhidden1.setVisibility(View.INVISIBLE);
        button3overlay.setVisibility(View.INVISIBLE);
        sendmessage(view);
    }
}

