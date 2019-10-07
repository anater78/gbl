package gblerningLesson1Task3;

public enum Participant {
    //Участник
    ONE(2,2), TWO(2,2), THREE(2,2);

    private int wall=0;
    private int moat=0;

    public int getWall() {
        return wall;
    }

    public int getMoat() {
        return moat;
    }


    Participant(int wall, int moat){
        this.wall = wall;
        this.moat = moat;
    }



}
