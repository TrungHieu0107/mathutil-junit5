/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.hieunt.mathutil.core;

import static com.hieunt.mathutil.core.MathUtil.*;
//import static là dành riêng cho những hàm static 
//gọi hàm mà bỏ qua tên class
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author ntrun
 */
public class MathUtilTest {

    
    //chơi DDT, tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này vào trong câu lệnh kiểm thử
    //chuẩn bị 1 bộ data
    
    public static Object[][] initData() {
        return new Integer[][]{
                {1,1},
                {2,2},
                {5,120},
                {6,720}
        };
    }
    @ParameterizedTest
    @MethodSource(value = "initData") //tên hàm cung cấp data, ngầm định thứ tự của mảng
                                      //map vào tham số hàm
    public void testGetFactorailGivenRightArgumentReturnWell_DDT(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }
    
    
    @Test
    public void testGetFactorailGivenRightArgumentReturnWell() {
        assertEquals(720, MathUtil.getFactorial(6));
    }
    //Bắt ngoại lệ khi đưa data cà chớn 
//   @Test(expected = tên ngoại lệ.class) Junit4 thôi

    @Test
    public void testGetFactorailGivenWrongArgumentThrowExceptions() {
       //xải biều thức lambda
       //hàm nhận tham số thứ 2 là 1 object cớ code implement cài fucntional interface tên là excutable - có 1 hàm
       //duy nhất tên là excute(_)
       //chơi chậm 
        Executable exObejct = new Executable() {
            @Override
            public void execute() throws Throwable {
                getFactorial(-5);
            }
        };
        assertThrows(IllegalArgumentException.class, exObejct);
        
        Executable ex = () -> 
            getFactorial(-3);
        
        assertThrows(IllegalArgumentException.class, ex);
        
        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
   }

}
