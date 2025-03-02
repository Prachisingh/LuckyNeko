package slotmachine.test;

import slotmachine.config.GameConfiguration;

import java.util.ArrayList;
import java.util.List;

public class TestCode {

    public static void main(String[] args) {
        List<String[]> slotFace = new ArrayList<>();
        String[] col1 = new String[]{"1", "2", "3", "4", "14", "15"};
        String[] col2 = new String[]{"5", "6", "7"}; // get size of it
        String[] col3 = new String[]{"8", "9", "10", "11"};
        slotFace.add(col1);
        slotFace.add(col2);
        slotFace.add(col3);

        printSlotFace(slotFace);

    }


    public static void printSlotFace(List<String[]> slotFace) {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 3; col++) {
                if (slotFace.get(col).length <= row) {
                    System.out.print("  ");
                    continue;
                }
                System.out.print(" " + slotFace.get(col)[row]);
            }
            System.out.println();
        }
    }
}
