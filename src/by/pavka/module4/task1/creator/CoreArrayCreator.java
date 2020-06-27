package by.pavka.module4.task1.creator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoreArrayCreator {

  public static int[] coreArrayFromConsole() {
    System.out.println("Fill in the core array by typing integers + 'enter'");
    System.out.println("Finish filling the array by typing anything except integer + 'enter'");
    try (Scanner scanner = new Scanner(System.in)) {
      return fillWithScanner(scanner);
    }
  }

  public static int[] coreArrayFromFile(File file) throws FileNotFoundException {
    try (Scanner scanner = new Scanner(file)) {
      return fillWithScanner(scanner);
    }
  }

  private static int[] fillWithScanner(Scanner scanner) {
    List<Integer> elements = new ArrayList<>();
    while (scanner.hasNextInt()) {
      int element = scanner.nextInt();
      elements.add(element);
    }
    int[] coreArray = elements.stream().mapToInt(i -> i).toArray();
    return coreArray;
  }
}
