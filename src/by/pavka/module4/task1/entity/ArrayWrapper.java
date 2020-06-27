package by.pavka.module4.task1.entity;

import by.pavka.module4.task1.creator.CoreArrayCreator;
import by.pavka.module4.task1.exception.ArrayWrapperException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class ArrayWrapper {
  private static final String NEGATIVE_LENGTH = "Core array negative length";
  private static final String NULL_ARRAY = "Core array is null";
  private static final String NULL_ORIGIN = "Original ArrayWrapper is null";
  private static final String WRONG_INDEX = "Index out of Bounds";
  private static final String NO_FILE = "File not found";

  private int[] coreArray;

  public ArrayWrapper() {
    coreArray = CoreArrayCreator.coreArrayFromConsole();
  }

  public ArrayWrapper(File file) throws ArrayWrapperException {
    try {
      coreArray = CoreArrayCreator.coreArrayFromFile(file);
    } catch (FileNotFoundException e) {
      throw new ArrayWrapperException(NO_FILE, e);
    }
  }

  public ArrayWrapper(ArrayWrapper origin) throws ArrayWrapperException {
    if (origin == null) {
      throw new ArrayWrapperException(NULL_ORIGIN);
    }
    coreArray = origin.coreArray;
  }

  public ArrayWrapper(int[] coreArray) throws ArrayWrapperException {
    if (coreArray == null) {
      throw new ArrayWrapperException(NULL_ARRAY);
    }
    this.coreArray = coreArray;
  }

  public ArrayWrapper(int length, boolean filledRandom) throws ArrayWrapperException {
    if (length < 0) {
      throw new ArrayWrapperException(NEGATIVE_LENGTH);
    }
    coreArray = new int[length];
    if (filledRandom) {
      fillRandom();
    }
  }

  public ArrayWrapper(int length) throws ArrayWrapperException {
    this(length, false);
  }

  public ArrayWrapper(int length, int value) throws ArrayWrapperException {
    this(length, false);
    fillInt(value);
  }

  private void fillInt(int value) {
    for (int i = 0; i < coreArray.length; i++) {
      coreArray[i] = value;
    }
  }

  private void fillRandom() {
    Random random = new Random();
    for (int i = 0; i < coreArray.length; i++) {
      coreArray[i] = random.nextInt();
    }
  }

  public void setRandom(int length) {
    Random random = new Random();
    coreArray = new int[length];
    for (int i = 0; i < length; i++) {
      coreArray[i] = random.nextInt();
    }
  }

  public int getLength() {
    return coreArray.length;
  }

  public void setElement(int index, int value) throws ArrayWrapperException {
    if (index < 0 || index >= coreArray.length) {
      throw new ArrayWrapperException(WRONG_INDEX);
    }
    coreArray[index] = value;
  }

  public int getElement(int index) throws ArrayWrapperException {
    if (index < 0 || index >= coreArray.length) {
      throw new ArrayWrapperException(WRONG_INDEX);
    }
    return coreArray[index];
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ArrayWrapper)) {
      return false;
    }
    ArrayWrapper that = (ArrayWrapper) o;
    if (that.getLength() != getLength()) {
      return false;
    }
    for (int i = 0; i < getLength(); i++) {
      try {
        if ((that.getElement(i)) != getElement(i)) {
          return false;
        }
      } catch (ArrayWrapperException e) {
        e.printStackTrace();
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 0;
    for (int i = 0; i < coreArray.length; i++) {
      hashCode += coreArray[i] * Math.pow(-1, i);
    }
    return hashCode;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("ArrayWrapper: { ");
    for (int i = 0; i < coreArray.length; i++) {
      result.append(coreArray[i]);
      result.append(" ");
    }
    result.append("}");
    return result.toString();
  }
}
