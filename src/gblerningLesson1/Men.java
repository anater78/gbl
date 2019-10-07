package gblerningLesson1;

import java.sql.SQLOutput;

public class Men implements Action {

    @Override
    public void run() {
        System.out.println( "Men run!");
    }

    @Override
    public void jump() {

        System.out.println("Men jump!");

    }
}
