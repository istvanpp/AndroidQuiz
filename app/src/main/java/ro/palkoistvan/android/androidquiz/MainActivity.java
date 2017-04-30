package ro.palkoistvan.android.androidquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nickName;
    EditText testName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startQuiz(View view) {
        // Intent configuration
        Intent startQuizActivity = new Intent(this, QuizActivity.class);

        nickName = (EditText) findViewById(R.id.nick_name);
        String Name = nickName.getText().toString();
        startQuizActivity.putExtra("player_name", Name);

        // Check if EditText field is filled out and
        if (TextUtils.isEmpty(Name)) {
            Toast.makeText(this, "Please give your nickname.", Toast.LENGTH_LONG).show();
            return;
        } else {
            startActivity(startQuizActivity);
        }
    }
}
