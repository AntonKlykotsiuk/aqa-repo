package com.java.anton_klykotsiuk.java.lection3.task1;

public class FinderInArray {

    private static final byte NUMBER_OF_ELEMENTS = 20;
    private static final byte LOW_RANGE_LIMIT = -10;
    private static final byte HIGH_RANGE_LIMIT = 10;

    public static void main(String[] args) {
        FinderInArray array = new FinderInArray();

        array.runArrayProcessing();
    }

    public boolean isOddIndex(int index) {
        return (index % 2 != 0);
    }

    public void runArrayProcessing() {
        int[] arr = new int[NUMBER_OF_ELEMENTS];

        System.out.print("Source array: ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (HIGH_RANGE_LIMIT - LOW_RANGE_LIMIT + 1)) + LOW_RANGE_LIMIT;
            System.out.print("[" + i + "]=" + arr[i] + "; ");
        }

        System.out.print("\nAfter processing: ");

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {

                if (arr[i] == arr[j] && isOddIndex(i) && isOddIndex(j)) {
                    System.out.print("[" + i + "]=" + arr[i] + "; ");
                    break;
                }
            }
        }
    }
}
