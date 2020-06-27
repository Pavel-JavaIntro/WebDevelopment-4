package test.pavka.module4.task1.entity;

import by.pavka.module4.task1.entity.ArrayWrapper;
import by.pavka.module4.task1.exception.ArrayWrapperException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ArrayWrapperTest {
  @Test(
      expectedExceptions = ArrayWrapperException.class,
      expectedExceptionsMessageRegExp = "Original ArrayWrapper is null")
  public void constructorTest1() throws ArrayWrapperException {
    ArrayWrapper origin = null;
    ArrayWrapper copy = new ArrayWrapper(origin);
  }

  @Test(
      expectedExceptions = ArrayWrapperException.class,
      expectedExceptionsMessageRegExp = "Core array is null")
  public void constructorTest2() throws ArrayWrapperException {
    int[] array = null;
    ArrayWrapper copy = new ArrayWrapper(array);
  }

  @Test
  public void constructorTest3() {
    int[] array = {2, 2, 2};
    try {
      ArrayWrapper arrayWrapper1 = new ArrayWrapper(array);
      ArrayWrapper arrayWrapper2 = new ArrayWrapper(3, 2);
      assertEquals(arrayWrapper1, arrayWrapper2);
    } catch (ArrayWrapperException e) {
      fail();
    }
  }

  @Test
  public void setterGetterTest1() {
    try {
      ArrayWrapper arrayWrapper = new ArrayWrapper(new int[]{1, 2, 3, 4});
      int expected = 2;
      int actual = arrayWrapper.getElement(1);
      assertEquals(actual, expected);
    } catch (ArrayWrapperException e) {
      fail();
    }
  }

  @Test
  public void setterGetterTest2() {
    try {
      ArrayWrapper arrayWrapper = new ArrayWrapper(new int[]{1, 2, 3, 4});
      arrayWrapper.setElement(1, 5);
      int expected = 5;
      int actual = arrayWrapper.getElement(1);
      assertEquals(actual, expected);
    } catch (ArrayWrapperException e) {
      fail();
    }
  }

  @Test(expectedExceptions = ArrayWrapperException.class,
          expectedExceptionsMessageRegExp = "Index out of Bounds")
  public void setterGetterTest3() throws ArrayWrapperException {
    ArrayWrapper arrayWrapper = new ArrayWrapper(new int[] {7, 4, -2});
    arrayWrapper.setElement(3, 0);
  }
}
