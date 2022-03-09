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


    @Override
    public int add(int item) {
        checkForZero(item);
        grow();
        array[sizeArray++] = item;
        return item;
    }

    @Override
    public int add(int index, int item) {
        checkForZero(item);
        grow();
        int newArray[] = new int[sizeArray++];
        for (int i = 0; i < index + 1; i++) {
            if (i < index - 1) {
                newArray[i] = array[i];
            } else if (i == index - 1) {
                newArray[i] = item;
            } else {
                newArray[i] = array[i - 1];
            }
        }
        array = newArray;
        return item;
    }

    @Override
    public int set(int index, int item) {
        checkForZero(item);
        array[index] = item;
        return item;
    }

    @Override
    public int remove(int index, int item) {
        checkForZero(item);
        int newArray[] = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
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
    }

    @Override
    public int indexOf(int item) {
        checkForZero(item);
        for (int i = 0; i < sizeArray; i++) {
            if (item == (array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int item) {
        checkForZero(item);
        for (int i = sizeArray - 1; i >= 0; i--) {
            if (item == (array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int index) {
        checkIndex(index);
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
        return sizeArray = 0;
    }

    @Override
    public boolean isEmpty() {
        checkCapacity();
        return false;
    }

    @Override
    public void clear() {
        array = new int[0];
    }

    @Override
    public int[] toArray() {
        return Arrays.copyOf(array, sizeArray);
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

    private void bibbleSortRecursiveMethod(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
               int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
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

    private void grow() {
        checkCapacity();
    }

    private void checkForZero(int item) {
        if (item == 0) {
            throw new IllegalArgumentException("used null value");
        }
    }

    private void checkCapacity() {
        if (sizeArray == array.length) {
            array = Arrays.copyOf(array, sizeArray * 3 / 2);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > array.length) {
            throw new IllegalArgumentException("used invalid value");
        }
        if (index > array.length) {
            throw new IndexOutOfBoundsException("used invalid value");
        }
    }
}
