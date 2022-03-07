package ru.skypro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class StringListImpl implements StringList{

    private static final int DEFAULT_CAPACITY = 5;
    private String[] array;
    private int sizeArray;

    public StringListImpl() {
        this(DEFAULT_CAPACITY);
    }

    public StringListImpl(int capacity) {
        this.array = new String[capacity];
    }

    /*Collection<String> array = new ArrayList<String>;*/


    String item;
    int index;
    int i;
    int j;

    @Override
    public String add(String item) {
        checkForNull(item);
        checkCapacity();
        array[sizeArray++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkForNull(item);
        checkCapacity();
        String newArray[] = new String[sizeArray++];
        for (i = 0; i < index + 1; i++) {
            if (i < index - 1) {
                newArray[i] = array[i];
            } else if (i == index - 1) {
                newArray[i] = item;
            } else {
                newArray[i] = array[i - 1];
            }
        }
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkForNull(item);
        array[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        checkForNull(item);
        int index = indexOf(item);
        remove(index);
        return item;
    }

    @Override
    public String remove(int index) {
        checkForNull(item);
        String newArray[] = new String[array.length -1];
        for (i = 0, j = 0; i < array.length; i++) {
            if (i == index) {
                continue;
            }
            newArray[j++] = array[i];
        }
        return newArray[index];
    }

    @Override
    public boolean contains(String item) {
        checkForNull(item);
        return indexOf(item) >= 0;
    }

    @Override
    public int indexOf(String item) {
        checkForNull(item);
        for (int i = 0; i < sizeArray; i++) {
            if (item.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        checkForNull(item);
        for (int i = sizeArray -1; i >= 0; i--) {
            if (item.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            return false;
        }
        if (sizeArray != otherList.size()) {
            return false;
        }
        for (int i = 0; i < sizeArray; i++) {
            if (!get(i).equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return sizeArray;
    }

    @Override
    public boolean isEmpty() {
        return sizeArray == 0;
    }

    @Override
    public void clear() {
        array = new String[DEFAULT_CAPACITY];
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, array.length);
    }

    private void checkForNull(String item) {
        if (item == null) {
            throw new IllegalArgumentException("used null value");
        }
    }

    private void checkCapacity() {
        if (sizeArray == array.length) {
            array = Arrays.copyOf(array, sizeArray * 2);
        }
    }
}
