package ru.a365apps.pritci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PritcaExpert mExpert = new PritcaExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //вызывается при щелчке на кнопке
    public void onClickFindBeer(View view){
        TextView vivod = (TextView) findViewById(R.id.vivod_pritc);//получить ссылку на тексвью
        Spinner vibor = (Spinner) findViewById(R.id.vibor_pritc);//получить ссылку на спиннер

        String TipPritci = String.valueOf(vibor.getSelectedItem());//получить вариант выбранный в спиннер
        List<String> brandList = mExpert.getPritci(TipPritci);//получить контейнер Лист с видами притч
        StringBuilder brandsFormatted = new StringBuilder();//постоить стринг по данным из Лист
        for (String brand : brandList){
            brandsFormatted.append(brand).append('\n');//Каждую притцу выводить с новой строки
        }

        vivod.setText(brandsFormatted);//вывести результаты в надписи
    }
}
