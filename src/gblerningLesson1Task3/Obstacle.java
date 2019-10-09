package gblerningLesson1Task3;

public enum Obstacle {

    //Препятствие

    WALL(2), MOAT(2);

    private int meters=0;

    public int getMeters() {
        return meters;
    }

    Obstacle(int meters){
        this.meters = meters;
    }

}
