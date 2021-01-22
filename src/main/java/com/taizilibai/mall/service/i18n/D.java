package com.taizilibai.mall.service.i18n;

import java.lang.reflect.Field;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2021/1/14 14:47
 */
public class D<E> implements C<E> {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int add(E o) {
        return 0;
    }

    public static void main(String[] args) {
        D<Integer> integerD = new D<>();
        Field[] declaredFields = integerD.getClass().getDeclaredFields();
        System.out.println(declaredFields);
        for(Field temp : declaredFields) {


        }
    }
}
