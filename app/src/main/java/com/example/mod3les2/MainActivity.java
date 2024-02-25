package com.example.mod3les2;

import static android.widget.Toast.makeText;
import static java.lang.Math.pow;
import static java.lang.StrictMath.sqrt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "активность запущена", Toast.LENGTH_SHORT).show();

        addListenerOnButton();
    }

    private EditText inputX1, inputX2;
    private TextView outputRezult, necessary;
    private Button button, button2;

    public void addListenerOnButton(){

        inputX1 = findViewById(R.id.inputX);
        inputX2 = findViewById(R.id.inputY);

        outputRezult = findViewById(R.id.outputEquation);
        necessary = findViewById(R.id.textView3);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.noRoots);


//        int a = (int) (Math.random() * 100) + 1;
//        int b = (int) (Math.random() * 100) + 1;
//        int c = (int) (Math.random() * 200) + 1;

        int a = 2;
        int b = 4;
        int c = 7;

        necessary.setText("введите корни уравнения: " + a + "*X^2" + " + " + b + "*Y + " + c + " = 0");

        button.setOnClickListener(
                new View.OnClickListener() {
                    float x, y;
                    @Override
                    public void onClick(View v) {
                        x = Float.parseFloat(String.valueOf(inputX1.getText()));
                        y = Float.parseFloat(String.valueOf(inputX2.getText()));

                        if (returnDiscriminant(a,b,c) >= 0){
                            outputRezult.setText(returnRoots(a,b,c,x,y));
                        }

                    }
                }
        );
        button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (returnDiscriminant(a,b,c) >= 0){
                            outputRezult.setText("не правильно");
                        }else {
                            outputRezult.setText("всё верно");
                        }
                    }
                }
        );

    }
    public int returnDiscriminant(int a, int b, int c){
        return (b*b - 4*a*c);
    }
    public String returnRoots(int a, int b, int c, float x1Oth, float x2Oth){

        float x1, x2;

        x1 = ((float) (-b + sqrt(returnDiscriminant(a,b,c))) / (2 * a));
        x2 = ((float) (-b - sqrt(returnDiscriminant(a,b,c))) / (2 * a));

        if((x1 == x1Oth && x2 == x2Oth) || (x2 == x1Oth && x1 == x2Oth)){
            return "всё верно";
        }else{
            return "не правильно";
        }

    }
}