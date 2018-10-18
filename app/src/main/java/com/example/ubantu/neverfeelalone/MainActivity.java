package com.example.ubantu.neverfeelalone;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button answer1 , answer2 , answer3 , answer4;
    TextView score , question;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef=database.getReference();


    int question_no;
    int ii;
    private Questions mQuestions = new Questions();

    private int mQuestionsLength = mQuestions.mQuestions.length;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Random r = new Random();
        final String id = myRef.push().getKey();

        answer1 = (Button)findViewById(R.id.answer1);
        answer2 = (Button)findViewById(R.id.answer2);
        answer3 = (Button)findViewById(R.id.answer3);
        answer4 = (Button)findViewById(R.id.answer4);


        score = (TextView)findViewById(R.id.score);
        question = (TextView)findViewById(R.id.question);

        question_no = 0;
        ii = 1;

        updateQuestion();

        score.setText("Question : " + ii);
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                myRef.child(id).child(""+ii).setValue("1");
                ii++;
                score.setText("Question : " + ii);
                question_no++;
                if(ii > 10)
                    missionComplete();
                updateQuestion();

            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                myRef.child(id).child(""+ ii).setValue("2");
                ii++;
                score.setText("Question : " + ii);
                question_no++;
                if(ii > 10)
                    missionComplete();
                updateQuestion();

            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                myRef.child(id).child(""+ ii).setValue("3");
                ii++;
                score.setText("Question : " + ii);
                question_no++;
                if(ii > 10)
                    missionComplete();
                updateQuestion();

            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myRef.child(id).child(""+ ii).setValue("4");
                ii++;
                score.setText("Question : " + ii);
                question_no++;
                if(ii > 10)
                    missionComplete();

                updateQuestion();


            }
        });
    }

    private void updateQuestion(){
        question.setText(mQuestions.getQuestion(question_no));
        answer1.setText(mQuestions.getChoice1(question_no));
        answer2.setText(mQuestions.getChoice2(question_no));
        answer3.setText(mQuestions.getChoice3(question_no));
        answer4.setText(mQuestions.getChoice4(question_no));
    }

    private  void missionComplete(){
        score.setText("");
        AlertDialog.Builder alertDiagougeBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDiagougeBuilder
                .setTitle("RESULTS WILL BE DISPLAYED AT 9 PM TONIGHT")
                .setCancelable(false)
                .setPositiveButton("New Test",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                question_no = 0;
                                finish();
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));//oncreate
                            }
                        })
                .setNegativeButton("Thanks for Giving your valuable time.",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();   // end ya kill
                       // android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(0);
                    }
                });
        AlertDialog dialog = alertDiagougeBuilder.create();
        dialog.show();
    }



}
