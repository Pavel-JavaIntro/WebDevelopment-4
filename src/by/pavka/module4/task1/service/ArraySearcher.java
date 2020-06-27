package by.pavka.module4.task1.service;

import by.pavka.module4.task1.entity.ArrayWrapper;
import by.pavka.module4.task1.entity.SearchCriteria;
import by.pavka.module4.task1.exception.ArrayWrapperException;

import java.util.ArrayList;
import java.util.List;

public class ArraySearcher {
  // Binary search
  public int searchInSortedArray(ArrayWrapper arrayWrapper, int value) {
    int resultIndex = -1;
    if (arrayWrapper != null && arrayWrapper.getLength() > 0) {
      int startIndex = 0;
      int endIndex = arrayWrapper.getLength() - 1;
      try {
        if (value >= arrayWrapper.getElement(startIndex)
            && value <= arrayWrapper.getElement(endIndex)) {
          resultIndex = searchInsideArray(arrayWrapper, startIndex, endIndex, value);
        }
      } catch (ArrayWrapperException e) {
        e.printStackTrace();
      }
    }
    return resultIndex;
  }

  private int searchInsideArray(
      ArrayWrapper arrayWrapper, int startIndex, int endIndex, int value) {

    int resultIndex = -1;

    if (endIndex - startIndex < 2) {
      try {
        if (arrayWrapper.getElement(startIndex) == value) {
          resultIndex = startIndex;
        } else if (arrayWrapper.getElement(endIndex) == value) {
          resultIndex = endIndex;
        }
      } catch (ArrayWrapperException e) {
        e.printStackTrace();
      }
      return resultIndex;
    }

    int mid = startIndex + (endIndex - startIndex) / 2;
    int start;
    int end;
    int midValue = 0;
    try {
      midValue = arrayWrapper.getElement(mid);
    } catch (ArrayWrapperException e) {
      e.printStackTrace();
    }
    if (value > midValue) {
      start = mid;
      end = endIndex;
    } else {
      start = startIndex;
      end = mid;
    }
    return searchInsideArray(arrayWrapper, start, end, value);
  }

  public int searchMin(ArrayWrapper arrayWrapper) throws ArrayWrapperException {
    ArrayWrapper copy = new ArrayWrapper(arrayWrapper);
    new ArraySorter().sortByBubble(copy, false);
    return copy.getElement(0);
  }

  public int searchMax(ArrayWrapper arrayWrapper) throws ArrayWrapperException {
    ArrayWrapper copy = new ArrayWrapper(arrayWrapper);
    new ArraySorter().sortByBubble(copy, true);
    return copy.getElement(0);
  }

  public List<Integer> findElementsByCriteria(
      ArrayWrapper arrayWrapper, SearchCriteria searchCriteria) {
    List<Integer> result = new ArrayList<>();
    if (arrayWrapper != null) {
      for (int i = 0; i < arrayWrapper.getLength(); i++) {
        int value = 0;
        try {
          value = arrayWrapper.getElement(i);
        } catch (ArrayWrapperException e) {
          e.printStackTrace();
        }
        switch (searchCriteria) {
          case PRIME:
            if (isPrime(value)) {
              result.add(value);
            }
            break;
          case FIBONACCI:
            if (isFibonacci(value)) {
              result.add(value);
            }
            break;
          case THREE_DIGIT:
            if (isThreeDigit(value)) {
              result.add(value);
            }
            break;
          default:
            break;
        }
      }
    }
    return result;
  }

  private boolean isPrime(int value) {
    if (value < 2) {
      return false;
    }
    for (int i = 2; i <= value / 2; i++) {
      if (value % i == 0) {
        return false;
      }
    }
    return true;
  }

  private boolean isFibonacci(int value) {
    int first = 1;
    int second = 1;
    while (second <= value) {
      if (second == value) {
        return true;
      }
      int temp = first;
      first = second;
      second = first + temp;
    }
    return false;
  }

  private boolean isThreeDigit(int value) {
    value = Math.abs(value);
    if (value < 100 || value > 999) {
      return false;
    }
    int cent = value / 100;
    int dec = value % 100 / 10;
    int unit = value % 10;
    if (cent == dec || cent == unit || dec == unit) {
      return false;
    }
    return true;
  }
}
