package ru.skypro;

import java.util.Arrays;

public class IntListImpl implements IntList {

    private static final int DEFAULT_CAPACITY = 5;
    private int[] array;
    private int sizeArray;

    public IntListImpl() {
        this(DEFAULT_CAPACITY);
    }

    public IntListImpl(int capacity) {
        this.array = new int[capacity];
    }

    int item;
    int index;
    int i;
    int j;

    @Override
    public int add(int item) {
        checkForZero(item);
        checkCapacity();
        array[sizeArray++] = item;
        return item;
    }

    @Override
    public int add(int index, int item) {
        checkForZero(item);
        checkCapacity();
        int newArray[] = new int[sizeArray++];
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
    public int set(int index, int item) {
        checkForZero(item);
        array[index] = item;
        return item;
    }

    @Override
    public int remove(int index) {
        checkForZero(item);
        int newArray[] = new int[array.length -1];
        for (i = 0, j = 0; i < array.length; i++) {
            if (i == index) {
                continue;
            }
            newArray[j++] = array[i];
        }
        return newArray[index];
    }

    @Override
    public boolean contains(int item) {
        checkForZero(item);
        return indexOf(item) >= 0;
        return true;
    }

    @Override
    public int indexOf(int item) {
        checkForZero(item);
        for (int i = 0; i < sizeArray; i++) {
            if (item.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int item) {
        checkForZero(item);
        for (int i = sizeArray -1; i >= 0; i--) {
            if (item.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public boolean equals(IntList otherList) {
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
        return sizeArray == 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {
        array = new int[DEFAULT_CAPACITY];
    }

    @Override
    public int[] toArray() {
       return Arrays.copyOf(array, array.length);
    }

    private void theMostFastSort() {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] >= temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    private boolean binarySearch(int[] array, int item) {
        int min = 0;
        int max = array.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == array[mid]) {
                return true;
            }

            if (item < array[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void checkForZero(int item) {
        if (item == 0) {
            throw new IllegalArgumentException("used null value");
        }
    }

    private void checkCapacity() {
        if (sizeArray == array.length) {
            array = Arrays.copyOf(array, sizeArray * 2);
        }
    }

}
