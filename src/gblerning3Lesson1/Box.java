package gblerning3Lesson1;

import java.util.ArrayList;
import java.util.Iterator;

public class Box<F extends Fruit> {

private int fruit;
private ArrayList<F> alf = new ArrayList<>();

public void addFruit(F fr){
    System.out.println("addFruit " + fr.getClass().getName());

    alf.add(fr);
}

    public Float getWeight(){
    Float fullMass = 0.0f;

    for(F f: alf){
//        System.out.println( "Вес " + f.getWeight());
            fullMass+=f.getWeight();
    }
    return fullMass;
    }

    public boolean Compare (Box b){

        return Math.abs(this.getWeight() - b.getWeight()) < 0.0001;

    }

    public ArrayList pickUpContent(){

     ArrayList al = (ArrayList) alf.clone();

     alf.clear();

    return al;

    }

    public void addContent(ArrayList<F> ac){

    alf.addAll(ac);

    }

}
