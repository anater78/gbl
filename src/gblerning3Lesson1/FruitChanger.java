package gblerning3Lesson1;

public class FruitChanger {

    public static void main(String[] args) {
        System.out.println("FruitChanger run!");

        Box<Apple> ba = new Box<>();
        ba.addFruit(new Apple());
        ba.addFruit(new Apple());
        ba.addFruit(new Apple());

        Box<Orange> bo = new Box<>();
        bo.addFruit(new Orange());
        bo.addFruit(new Orange());

        System.out.println("Общий вес первой коробки" + ba.getWeight());
        System.out.println("Общий вес второй коробки" + bo.getWeight());

        System.out.println("Коробки по весу равны = " + ba.Compare(bo));


        Box<Orange> bo2 = new Box(); //instanceof проверки нет. Если поставить Fruit то ошибка RunTime!

        //bo2.addFruit(new Apple()); ERROR Compile!
        bo2.addFruit(new Orange());
        bo2.addContent(bo.pickUpContent());

        System.out.println("Общий вес первой коробки" + ba.getWeight());
        System.out.println("Общий вес второй коробки" + bo.getWeight());

        System.out.println("Общий вес третьей коробки " + bo2.getWeight());

    }


}

//    Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
//    Написать метод, который преобразует массив в ArrayList;
//Задача:
//        Даны классы Fruit -> Apple, Orange;
//        Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//        Для хранения фруктов внутри коробки можно использовать ArrayList;
//        Сделать метод getWeight(), который высчитывает вес коробки. Задать вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
//        Внутри класса Box сделать метод Compare, который позволяет сравнить текущую коробку с той, которую подадут в Compare в качестве параметра. True – если их массы равны, False в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
//        Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
//        Не забываем про метод добавления фрукта в коробку.
