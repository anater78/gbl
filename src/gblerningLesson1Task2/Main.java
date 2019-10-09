package gblerningLesson1Task2;

public class Main {

    public static void main(String[] args) {
        System.out.println("HW lesson2");

        Men men = new Men(90,2);

        Cat cat = new Cat(150,3);

        Robot robot = new Robot(1000,0);

        Wall wall = new Wall(1);

        Racetrack racetrack = new Racetrack(100);

        men.run(racetrack.getLongwall());
        men.jump(wall.getHeight());

        cat.run(racetrack.getLongwall());
        cat.jump(wall.getHeight());

        robot.run(racetrack.getLongwall());
        robot.jump(wall.getHeight());

    }
}
