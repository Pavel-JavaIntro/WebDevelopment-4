package by.pavka.module4.task1.service;

import by.pavka.module4.task1.entity.ArrayWrapper;
import by.pavka.module4.task1.exception.ArrayWrapperException;

public class ArraySorter {
  public void sortByBubble(ArrayWrapper arrayWrapper, boolean descend) {
    boolean sorted = false;
    int length = arrayWrapper.getLength();
    while (!sorted) {
      sorted = true;
      for (int i = 0; i < length - 1; i++) {
        int first = 0;
        try {
          first = arrayWrapper.getElement(i);
          int second = arrayWrapper.getElement(i + 1);
          if (first > second) {
            sorted = false;
            arrayWrapper.setElement(i, second);
            arrayWrapper.setElement(i + 1, first);
          }
        } catch (ArrayWrapperException e) {
          e.printStackTrace();
        }
      }
    }
    if (descend) {
      revert(arrayWrapper);
    }
  }

  public void sortBySelection(ArrayWrapper arrayWrapper, boolean descend) {
    int length = arrayWrapper.getLength();
    for (int i = 0; i < length - 1; i++) {
      try {
        int min = arrayWrapper.getElement(i);
        int index = i;
        for (int j = i + 1; j < length; j++) {
          int element = arrayWrapper.getElement(j);
          if (element < min) {
            min = element;
            index = j;
          }
        }
        arrayWrapper.setElement(index, arrayWrapper.getElement(i));
        arrayWrapper.setElement(i, min);
      } catch (ArrayWrapperException e) {
        e.printStackTrace();
      }
    }
    if (descend) {
      revert(arrayWrapper);
    }
  }

  public void sortByShell(ArrayWrapper arrayWrapper, boolean descend) {
    int index = 0;
    int length = arrayWrapper.getLength();
    while (index < length - 1) {
      try {
        if (arrayWrapper.getElement(index) <= arrayWrapper.getElement(index + 1)) {
          index++;
        } else {
          int temp = arrayWrapper.getElement(index + 1);
          arrayWrapper.setElement(index + 1, arrayWrapper.getElement(index));
          arrayWrapper.setElement(index, temp);
          if (index > 0) index--;
        }
      } catch (ArrayWrapperException e) {
        e.printStackTrace();
      }
    }
    if (descend) {
      revert(arrayWrapper);
    }
  }

  private void revert(ArrayWrapper arrayWrapper) {
    int length = arrayWrapper.getLength();
    for (int i = 0; i < length / 2; i++) {
      try {
        int temp = arrayWrapper.getElement(i);
        int tail = arrayWrapper.getElement(length - 1 - i);
        arrayWrapper.setElement(i, tail);
        arrayWrapper.setElement(length - 1 - i, temp);
      } catch (ArrayWrapperException e) {
        e.printStackTrace();
      }
    }
  }
}
