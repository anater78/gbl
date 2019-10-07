package gblerningLesson1Task1;

public class Main {

    public static void main(String[] args) {
        System.out.println("HW lesson1");

        Men men = new Men();

        Cat cat = new Cat();

        Robot robot = new Robot();

        men.run();
        men.jump();

        cat.run();
        cat.jump();

        robot.run();
        robot.jump();

    }
}
