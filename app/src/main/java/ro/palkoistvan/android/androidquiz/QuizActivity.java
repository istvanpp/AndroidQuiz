package ro.palkoistvan.android.androidquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    /**
     * Calculates the total point by evaluating each question.
     * It displays a toast message at the end.
     */
    public void submitQuiz(View view) {

        int points = 0;
        boolean setAllOptions = true;

        // Process question no. 1
        RadioGroup question1RadioGroup = (RadioGroup) findViewById(R.id.q1_radiobuttongroup);
        if (question1RadioGroup.getCheckedRadioButtonId() == R.id.q1answer4) {
            points = points + 1;
        }

        // Process question no. 2
        setAllOptions = true;
        CheckBox question2option1 = (CheckBox) findViewById(R.id.q2answer1);
        if (!question2option1.isChecked()) {
            setAllOptions = false;
        }
        CheckBox question2option2 = (CheckBox) findViewById(R.id.q2answer2);
        if (question2option2.isChecked()) {
            setAllOptions = false;
        }
        CheckBox question2option3 = (CheckBox) findViewById(R.id.q2answer3);
        if (!question2option3.isChecked()) {
            setAllOptions = false;
        }
        if (setAllOptions) {
            points = points + 1;
        }

        // Evaluate question 3
        EditText question3Text = (EditText) findViewById(R.id.q3answer1);
        String question3Answer = question3Text.getText().toString().trim().toLowerCase();
        if (question3Answer.equals("java")) {
            points = points + 1;
        }

        // Process question no. 4
        RadioGroup question4RadioGroup = (RadioGroup) findViewById(R.id.q4_radiobuttongroup);
        if (question4RadioGroup.getCheckedRadioButtonId() == R.id.q4answer2) {
            points = points + 1;
        }

        // Process question no. 5
        setAllOptions = true;
        CheckBox question6option1 = (CheckBox) findViewById(R.id.q5answer1);
        if (!question6option1.isChecked()) {
            setAllOptions = false;
        }
        CheckBox question6option2 = (CheckBox) findViewById(R.id.q5answer2);
        if (question6option2.isChecked()) {
            setAllOptions = false;
        }
        CheckBox question6option3 = (CheckBox) findViewById(R.id.q5answer3);
        if (!question6option3.isChecked()) {
            setAllOptions = false;
        }
        CheckBox question6option4 = (CheckBox) findViewById(R.id.q5answer4);
        if (!question6option4.isChecked()) {
            setAllOptions = false;
        }
        if (setAllOptions) {
            points = points + 1;
        }

        // Process question no. 6
        RadioGroup question5RadioGroup = (RadioGroup) findViewById(R.id.q6_radiobuttongroup);
        if (question5RadioGroup.getCheckedRadioButtonId() == R.id.q6answer1) {
            points = points + 1;
        }

        //Prepare the text for the Toast message get the Name from Intent

        Intent intent = getIntent();
        String nickName = intent.getStringExtra("player_name");

        if (!nickName.equals("")) {
            nickName = ", " + nickName + "!";
        } else {
            nickName = "!";
        }
        // Messages for achieved score.
        String scoreMessage = "";
        if (points == 6) {
            scoreMessage = getString(R.string.sixCorrect, nickName);
        } else {
            if (points >= 4) {
                scoreMessage = getString(R.string.fourCorrect, nickName, points);
            } else {
                if (points >= 2) {
                    scoreMessage = getString(R.string.twoCorrect, nickName, points);
                } else {
                    if (points == 1) {
                        scoreMessage = getString(R.string.oneCorrect, nickName);
                    } else {
                        scoreMessage = getString(R.string.noCorrect, nickName);
                        scoreMessage = getString(R.string.noCorrect, nickName);
                    }
                }
            }
        }

        Toast.makeText(this, scoreMessage, Toast.LENGTH_LONG).show();
    }

    public void showCorrectAnswers(View view) {

        RadioGroup question1RadioGroup = (RadioGroup) findViewById(R.id.q1_radiobuttongroup);
        question1RadioGroup.check(R.id.q1answer4);

        CheckBox question2option1 = (CheckBox) findViewById(R.id.q2answer1);
        question2option1.setChecked(true);
        CheckBox question2option2 = (CheckBox) findViewById(R.id.q2answer2);
        question2option2.setChecked(false);
        CheckBox question2option3 = (CheckBox) findViewById(R.id.q2answer3);
        question2option3.setChecked(true);

        EditText question3Text = (EditText) findViewById(R.id.q3answer1);
        question3Text.setText("Java");

        RadioGroup question4RadioGroup = (RadioGroup) findViewById(R.id.q4_radiobuttongroup);
        question4RadioGroup.check(R.id.q4answer2);

        CheckBox question5option1 = (CheckBox) findViewById(R.id.q5answer1);
        question5option1.setChecked(true);
        CheckBox question5option2 = (CheckBox) findViewById(R.id.q5answer2);
        question5option2.setChecked(false);
        CheckBox question5option3 = (CheckBox) findViewById(R.id.q5answer3);
        question5option3.setChecked(true);
        CheckBox question5option4 = (CheckBox) findViewById(R.id.q5answer4);
        question5option4.setChecked(true);

        RadioGroup question6RadioGroup = (RadioGroup) findViewById(R.id.q6_radiobuttongroup);
        question6RadioGroup.check(R.id.q6answer1);

    }
}