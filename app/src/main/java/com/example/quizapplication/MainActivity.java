package com.example.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static android.view.View.INVISIBLE;

public class MainActivity extends AppCompatActivity {
    Button buttonNext, buttonSubmit,buttoPrevious;
    TextView tv, timing;
    RadioButton rb1, rb2, rb3, rb4;
    RadioGroup rg;
    int questionNumber, count = 1;
    int correctAnswer = 0;
    String rightAnswer=null ;
    int countDownvalue = 250;
    String[] currentOptions;
    String selectedButton;
     Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonNext = findViewById(R.id.button_next);
        buttonSubmit = findViewById(R.id.button_submit);
        buttoPrevious=findViewById(R.id.previous_button);
        tv = findViewById(R.id.textview_question);
        timing = findViewById(R.id.textview_time);
        rg = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);


        final List<String> questions = new ArrayList<>();//list of questions
        final List<String> answer = new ArrayList<>();//list of answers
        final String[] quest = {"Another name for looping is called?", "Getter and Setter is used for what?",
                "Multiple Inheritance in java is implemented as?", "void __ does not have a return type",
                "System Development life cycle include the following except?", "The following are good examples of OOP languages except",
                "Object of different classes being treated in the same way is called?", "Which of these is a keyword for Inheritance?",
                "The keyword that must follow a do loop is?", "An example of recursion is?", "Which of these is not the good way of declaring an array?",
                "The acronym in java WORA means?", "In other to call a method of the parent class in the child class,_____ keyword is use?",
                "When more than one method has the same name,argument and the return type is called?", "The following are different types of Inheritance except?",
                "The following are the concepts of OOP except?", "A method which is called automatically whenever a new object is created is called?",
                "__ enables us to use a Scanner object in our code", "Which of these method can be use to read a whole line of sentence?",
                "The keyword use in implementing an interface is?", "The following are access modifier except?", "Declaring more than one public class in a file leads to___?",
                "In order to call a constructor, the keyword____ is used follow by the object name?", "Which of these is not a primitive type?",
                "The example, Account account1 indicates that","One of these is a selection control?","The template for creating an object is called",
                "The descriptive properties posses by an object is","The word METHOD can also be referred as","One of these is not a key word"};
        questions.addAll(Arrays.asList(quest));

        final String[] ans = {"(d) Iteration", "(b) Encapsulation", "(b) Interface", "(c) Getter", "(d) Polymorphism", "(d) QBASIC", "(b) Polymorphism", "(b) extends","(c) while", "(d) factorial of a number",
                "(d) for(i=0;i<=a;i++)", "(d) Write once,run anywhere", "(c) super", "(d) Method Overriding", "(a) Association Inheritance", "(d) extends", "(b) Constructor", "(b) import java.util.Scanner",
                "(c) keyboard.nextLine", "(b) implements", "(b) extends", "(c) compilation error", "(b) new", "(c) String", "(a) account1 is a reference to an Account object","(c) if",
                 "(a) Class","(c) Attributes","(c) Behaviour","(b) take"};
        answer.addAll(Arrays.asList(ans));

        final ArrayList<String[]> options = new ArrayList<>();//list of arrays that hold options
        String[] opt1 = {"(a) Algorithm", "(b) Interface", " (c) Deadlock", "(d) Iteration"};
        String[] opt2 = {"(a) Polymorphism", "(b) Encapsulation", "(c) Interface", "(d) Iteration"};
        String[] opt3 = {"(a) Extension", "(b) Interface", "(c) Looping", "(d) Implementation"};
        String[] opt4 = {"(a) Interface", "(b) Inheritance", "(c) Getter", "(d) Setter"};
        String[] opt5 = {"(a) Feasibility study", "(b) Testing", "(c) Algorithm Analysis", "(d) Polymorphism"};
        String[] opt6 = {"(a) C++", "(b) Java", "(c) Python", "(d) QBASIC"};
        String[] opt7 = {"(a) Encapsulation", "(b) Polymorphism", "(c) Inheritance", "(d) Interfaces"};
        String[] opt8 = {"(a) do", "(b) extends", "(c) extract", "(d) repeat"};
        String[] opt9 = {"(a) repeat", "(b) if", "(c) while", "(d) else"};
        String[] opt10 = {"(a) variable", "(b) constant", "(c) identifier", "(d) factorial of a number"};
        String[] opt11 = {"(a) for (i=0;i<a;i++", "(b) for(i=a;i<a.length;i++)", "(c) for (i=0;i<=a.length-1;i++)", "(d) for(i=0;i<=a;i++)"};
        String[] opt12 = {"(a) Write On,Run All", "(b) Write Once,Run All", "(c) Write On,Run Anywhere", "(d) Write Once,Run Anywhere"};
        String[] opt13 = {"(a) read", "(b) invoke", "(c) super", "(d) derived"};
        String[] opt14 = {"(a) Same method", "(b) Similarity", "(c) Method Overloading", "(d) Method Overriding"};
        String[] opt15 = {"(a) Association Inheritance", "(b) Single Inheritance", "(c) Multiple Inheritance", "(d) Hierarchical Inheritance"};
        String[] opt16 = {"(a) Abstraction", "(b) Encapsulation", "(c) Polymorphism", "(d) extends"};
        String[] opt17 = {"(a) Interface", "(b) Constructor", "(c) Invocation", "(d) Method Calling"};
        String[] opt18 = {"(a) import java.util.scanners", "(b) import java.util.Scanner", "(c)import.util.scanner", "(d) import.util.Scanner"};
        String[] opt19 = {"(a) keyboard.next", "(b) keyboard.nextInt", "(c) keyboard.nextLine", "(d) keyboard.getCharAt()"};
        String[] opt20 = {"(a) extract", "(b) implements", "(c) extends", "(d) contains"};
        String[] opt21 = {"(a) public", "(b) extends", "(c) private", "(d) protected"};
        String[] opt22 = {"(a) runtime error", "(b) semantic error", "(c) compilation error", "(d)arrayIndexOutOfBoundsException"};
        String[] opt23 = {"(a) object", "(b) new", "(c) constructor", "(d) extends"};
        String[] opt24 = {"(a) int", "(b) char", "(c) String", "(d) float"};
        String[] opt25 = {"(a) account1 is a reference to an Account object", "(b) account1 is a null pointer", "(c) account1 is a primitive type", "(d) account1 is a class name"};
        String[] opt26={"(a) loop","(b) recursion","(c) if","(d) for"};
        String[] opt27={"(a) Class","(b) Object","(c) Encapsulation","(d) Polymorphism"};
        String[] opt28={"(a) Object","(b) Class","(c) Attributes","(d) Method"};
        String[] opt29={"(a) Properties","(b) Attributes","(c) Behaviour","(d) Overload"};
        String [] opt30={"(a) Try","(b) take","(c) catch","(d) return"};
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);
        options.add(opt5);
        options.add(opt6);
        options.add(opt7);
        options.add(opt8);
        options.add(opt9);
        options.add(opt10);
        options.add(opt11);
        options.add(opt12);
        options.add(opt13);
        options.add(opt14);
        options.add(opt15);
        options.add(opt16);
        options.add(opt17);
        options.add(opt18);
        options.add(opt19);
        options.add(opt20);
        options.add(opt21);
        options.add(opt22);
        options.add(opt23);
        options.add(opt24);
        options.add(opt25);
        options.add(opt26);
        options.add(opt27);
        options.add(opt28);
        options.add(opt29);
        options.add(opt30);

        /*questionNumber =random.nextInt(questions.size()); // generate a random question from the current list
        currentOptions= options.get(questionNumber); // get the options of the question ask based on the index
        tv.setText(count + ". " + questions.get(questionNumber)); //set the textview to question
        rb1.setText(currentOptions[0]); //set the options to the radio buttons
        rb2.setText(currentOptions[1]);
        rb3.setText(currentOptions[2]);
        rb4.setText(currentOptions[3]);
        rightAnswer = answer.get(questionNumber); //hold right answer in this variable
        questions.remove(questionNumber); // remove the question which is asked
        answer.remove(questionNumber); // remove the answer of the question asked
        options.remove(questionNumber); // remove the options of the question being asked
         count++;
        rg.clearCheck();*/

                tv.setText("");
                tv.setText("Another name for the child class is ____?\nYou will need to select on these circles depending on your choice of answer as it is shown in the example when you start the quiz. Click the button next to start your quiz now");
                rb1.setText("(a) super");
                rb2.setText("(b) parent");
                rb3.setText("(c) derived");
                rb4.setText("(d) main");
                rb1.setChecked(false);
                rb2.setChecked(false);
                rb3.setChecked(true);
                rb4.setChecked(false);

                buttonNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {

                            if (questions.size() >0) {//only runs if list contains something

                                   // Toast.makeText(MainActivity.this,selectedButton,Toast.LENGTH_LONG).show();
                                   // Toast.makeText(MainActivity.this,rightAnswer,Toast.LENGTH_SHORT).show();


                                questionNumber =random.nextInt(questions.size()); // generate a random question from the current list
                                currentOptions= options.get(questionNumber); // get the options of the question ask based on the index

                                if(rg.getCheckedRadioButtonId()!=-1){
                                    RadioButton option=findViewById(rg.getCheckedRadioButtonId());
                                    selectedButton=option.getText().toString();
                                    if(selectedButton.equalsIgnoreCase(rightAnswer)){
                                        correctAnswer=correctAnswer+4;
                                    }else {

                                        correctAnswer=correctAnswer+0;
                                    }

                                    tv.setText(count + ". " + questions.get(questionNumber)); //set the textview to question
                                rb1.setText(currentOptions[0]); //set the options to the radio buttons
                                rb2.setText(currentOptions[1]);
                                rb3.setText(currentOptions[2]);
                                rb4.setText(currentOptions[3]);


                                rightAnswer = answer.get(questionNumber); //hold right answer in this variable
                                questions.remove(questionNumber); // remove the question which is asked
                                answer.remove(questionNumber); // remove the answer of the question asked
                                options.remove(questionNumber); // remove the options of the question being asked

                                }}

                            // else{
                            if(count>25){
                            tv.setText("You are through with your test, I wish you the best of it"); // set the question textView to no question remaining after finish answering the number of question that was assigned for a particular student
                            rb1.setVisibility(View.GONE);
                            rb2.setVisibility(View.GONE); // make the radio buttons invisible
                            rb3.setVisibility(View.GONE);
                            rb4.setVisibility(View.GONE);
                              }

                                {
                                    rg.clearCheck();

                                    count++;
                                }




                                final Timer timer = new Timer();
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                countDownvalue--;
                                                timing.setText("Your time remains " + countDownvalue);
                                                if (countDownvalue <= 0) {
                                                    timer.cancel();

                                                    timing.setText("Your time has finished, click on submit button to submit your quiz");

                                                    buttonNext.setEnabled(false);

                                                }
                                            }
                                        });

                                    }
                                }, 0, 1000);

                        } catch (Exception e) {
                           Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

                buttonSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        intent.putExtra("Score", correctAnswer);
                        startActivity(intent);
                    }
                });
            }

        }
