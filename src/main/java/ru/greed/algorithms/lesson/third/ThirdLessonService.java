package ru.greed.algorithms.lesson.third;

public class ThirdLessonService {

    private final IdRegistryList<String> list = new IdRegistryList<>();

    public void printTestList() {
        long id1 = list.addLast("First");
        long id2 = list.addLast("Second");
        long id3 = list.addLast("Third");

        list.printAll();

        long foundId = list.findByValue("Second");

        list.insertAfter(foundId,"Inserted-Between-2-and-3");

        list.printAll();

        list.setValue(id1, "Updated First");

        list.printAll();

        list.addFirst("New First");

        list.printAll();

        list.addLast("Fourth");

        list.printAll();

        list.remove(list.findByValue("Fourth"));

        list.printAll();

        String firstValue = list.getValue(id3);

        System.out.println("Значение для id3: " + firstValue);

        list.remove(id2);

        list.printAll();
    }


}
