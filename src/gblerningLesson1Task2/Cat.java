package gblerningLesson1Task2;

public class Cat  implements Action {

    int run = 0;
    int jump = 0;

    public Cat(int run, int jump) {
        this.run = run;
        this.jump = jump;
    }

    @Override
    public void run(int longwall) {

        System.out.println("Cat run!");

        if (longwall > run) {
            System.out.println("Not run");
        } else {
            System.out.println(" Run is pass!");
        }
    }

    @Override
    public void jump(int height) {

        System.out.println("Cat jump");

        if (height > jump){
            System.out.println("Not jump!");
        } else {
            System.out.println("Jump is pass!");
        }
    }
}