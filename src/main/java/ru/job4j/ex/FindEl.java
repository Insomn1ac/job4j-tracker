package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                return i;
            }
        }
        throw new ElementNotFoundException("Element not found in array!!!");
    }

    public static void main(String[] args) {
        String[] value = new String[] {"Mother", "Father", "Sister", "Brother", "Uncle", "Aunt"};
        String key = "Grandmother";
        try {
            System.out.println(indexOf(value, key));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
