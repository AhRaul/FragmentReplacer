package com.example.fragmentreplacer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import static com.example.fragmentreplacer.MyFragment1.KEY_MSG_1;
import static com.example.fragmentreplacer.MyFragment2.KEY_MSG_2;
import static com.example.fragmentreplacer.MyFragment3.KEY_MSG_3;

public class MainActivity extends AppCompatActivity {

    FrameLayout container;
    FragmentManager myFragmentManager;
    MyFragment1 myFragment1;
    MyFragment2 myFragment2;
    MyFragment3 myFragment3;
    final static String TAG_1 = "FRAGMENT1_MSG";
    final static String TAG_2 = "FRAGMENT2_MSG";
    final static String TAG_3 = "FRAGMENT3_MSG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (FrameLayout) findViewById(R.id.container);


        Button button1 = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyFragment1 fragment = (MyFragment1) myFragmentManager.findFragmentByTag(TAG_1);
                if(fragment == null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_MSG_1, "Заменили на первый фрагмент");
                    myFragment1.setArguments(bundle);

                    FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container, myFragment1, TAG_1);
                    fragmentTransaction.commit();
                } else {
                    fragment.setMsg("Первый фрагмент уже загружен");
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyFragment2 fragment = (MyFragment2) myFragmentManager.findFragmentByTag(TAG_2);
                if(fragment == null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_MSG_2, "Заменили на второй фрагмент");
                    myFragment2.setArguments(bundle);

                    FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container, myFragment2, TAG_2);
                    fragmentTransaction.commit();
                } else {
                    fragment.setMsg("Второй фрагмент уже загружен");
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyFragment3 fragment = (MyFragment3) myFragmentManager.findFragmentByTag(TAG_3);
                if(fragment == null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_MSG_3, "Заменили на третий фрагмент");
                    myFragment3.setArguments(bundle);

                    FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container, myFragment3, TAG_3);
                    fragmentTransaction.commit();
                } else {
                    fragment.setMsg("Третий фрагмент уже загружен");
                }
            }
        });

        myFragmentManager = getSupportFragmentManager();
        myFragment1 = new MyFragment1();
        myFragment2 = new MyFragment2();
        myFragment3 = new MyFragment3();

        if(savedInstanceState == null) {
            //при первом запуске программы
            FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
            //добавляем в контейнер при помощи метода add()
            fragmentTransaction.add(R.id.container, myFragment1, TAG_1);
            fragmentTransaction.commit();
        }
    }
}
