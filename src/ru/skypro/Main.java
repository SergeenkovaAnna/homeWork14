package ru.skypro;

public class Main {

    public static void main(String[] args) {

            int[] arr;

            arr = new int[100_000];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = ((int) (Math.random() * 200_000));
                System.out.println(arr[i]);
            }

//            sortSelection(arr);
//        System.out.println(arr);


        long start = System.currentTimeMillis();
        sortInsertion(arr);
        System.out.println("times");
        System.out.println(System.currentTimeMillis() - start);

    }

    public static void getRandom() {
        int[] arr;
        arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((int) (Math.random() * 200_000));
            System.out.println(arr[i]);
        }
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void sortBubble(int[] arr) {
        getRandom();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }



}