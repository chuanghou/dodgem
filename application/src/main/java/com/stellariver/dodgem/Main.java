package com.stellariver.dodgem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Class<?> studentClass = JavaClassParser.compile("Student",
                "package com.stellariver.dodgem;\n" +
                        "\n" +
                        "public class Student {\n" +
                        "    \n" +
                        "    private String name;\n" +
                        "    \n" +
                        "    public Student() {\n" +
                        "        this.name = \"work\";\n" +
                        "    } \n" +
                        "    \n" +
                        "    public void testPrint() {\n" +
                        "        System.out.println(name);\n" +
                        "    }\n" +
                        "    \n" +
                        "}\n");
        assert studentClass != null;
        Object o = studentClass.newInstance();
        Method testPrint = o.getClass().getMethod("testPrint");
        Object invoke = testPrint.invoke(o);

    }
}