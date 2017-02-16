package com.webdemo.day001;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by X Rebecca on 2016/12/13.
 */
public class AssertCase {
    @Test
    public void testEquals(){
       String a ="asdg";
       String b ="1123";
        Assert.assertEquals(a,b,"a不等于b");
    }
    @Test
    public void testNoEquals(){
        int a =333;
        int b =111;
        Assert.assertNotEquals(a,b,"a等于b");
    }
    @Test
    public void testNotNull(){
        int a =333;
        Assert.assertNotNull(a,"a为空");
    }
    @Test
    public void testNull(){
        String  a =null;
        Assert.assertNull(a,"a不为空");
    }

}
