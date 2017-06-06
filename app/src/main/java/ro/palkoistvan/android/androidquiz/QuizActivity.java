package ro.palkoistvan.android.androidquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuizActivity extends AppCompatActivity {

    // Bind Views with Butter Knife
    @BindView(R.id.q2answer1)
    CheckBox question2option1;
    @BindView(R.id.q2answer2)
    CheckBox question2option2;
    @BindView(R.id.q2answer3)
    CheckBox question2option3;
    @BindView(R.id.q1_radiobuttongroup)
    RadioGroup question1RadioGroup;
    @BindView(R.id.q3answer1)
    EditText question3Text;
    @BindView(R.id.q4_radiobuttongroup)
    RadioGroup question4RadioGroup;
    @BindView(R.id.q5answer1)
    CheckBox question5option1;
    @BindView(R.id.q5answer2)
    CheckBox question5option2;
    @BindView(R.id.q5answer3)
    CheckBox question5option3;
    @BindView(R.id.q5answer4)
    CheckBox question5option4;
    @BindView(R.id.q6_radiobuttongroup)
    RadioGroup question6RadioGroup;
    @BindView(R.id.submitQuiz)
    Button submitQuizBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // ButterKnife is instructed to bind the annotated views
        ButterKnife.bind(this);
    }

    /**
     * Calculates the total point by evaluating each question.
     * It displays a toast message at the end.
     */
    public void submitQuiz(View view) {

        int points = 0;
        boolean setAllOptions = true;

        // Process question no. 1
        if (question1RadioGroup.getCheckedRadioButtonId() == R.id.q1answer4) {
            points = points + 1;
        }

        // Process question no. 2
        setAllOptions = true;
        if (!question2option1.isChecked()) {
            setAllOptions = false;
        } else if (question2option2.isChecked()) {
            setAllOptions = false;
        } else if (!question2option3.isChecked()) {
            setAllOptions = false;
        } else if (setAllOptions) {
            points = points + 1;
        }

        // Process question 3
        String question3Answer = question3Text.getText().toString().trim().toLowerCase();
        if (question3Answer.equals("java")) {
            points = points + 1;
        }

        // Process question no. 4
        if (question4RadioGroup.getCheckedRadioButtonId() == R.id.q4answer2) {
            points = points + 1;
        }

        // Process question no. 5

        setAllOptions = question5option1.isChecked();
        if (question5option2.isChecked()) {
            setAllOptions = false;
        }
        if (!question5option3.isChecked()) {
            setAllOptions = false;
        }
        if (!question5option4.isChecked()) {
            setAllOptions = false;
        }
        if (setAllOptions) {
            points = points + 1;
        }

        // Process question no. 6
        if (question6RadioGroup.getCheckedRadioButtonId() == R.id.q6answer1) {
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

    // Set the correct answers for the quiz
    public void showCorrectAnswers(View view) {
        // Disable Submit Quiz button
        submitQuizBtn.setEnabled(false);

        //Question 1:
        question1RadioGroup.check(R.id.q1answer4);

        //Question 2:
        question2option1.setChecked(true);
        question2option2.setChecked(false);
        question2option3.setChecked(true);

        //Question 3:
        question3Text.setText("Java");

        //Question 4:
        question4RadioGroup.check(R.id.q4answer2);

        //Question 5:
        question5option1.setChecked(true);
        question5option2.setChecked(false);
        question5option3.setChecked(true);
        question5option4.setChecked(true);

        //Question 6:
        question6RadioGroup.check(R.id.q6answer1);
    }
}

