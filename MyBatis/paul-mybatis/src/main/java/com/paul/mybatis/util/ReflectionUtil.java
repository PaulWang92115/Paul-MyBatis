package com.paul.mybatis.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReflectionUtil{

    /**
     *
     * 为指定的 bean 的 propName 属性的设为 value
     * @param bean 目标对象
     * @param propName 属性
     * @param value 值
     */
    public static  void  setPropToBean(Object bean,String propName,Object value){
        Field f;

        try {
            f = bean.getClass().getDeclaredField(propName);
            f.setAccessible(true);
            f.set(bean,value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


    public static void setPropToBeanFromResultSet(Object entity, ResultSet resultSet) throws SQLException{
        //通过反射方法获取对象的所有字段
        Field[] declaredFields = entity.getClass().getDeclaredFields();

        for(int i = 0;i<declaredFields.length;i++){
            if(declaredFields[i].getType().getSimpleName().equals("String")){
                setPropToBean(entity,declaredFields[i].getName(),resultSet.getString(declaredFields[i].getName()));
            }else if(declaredFields[i].getType().getSimpleName().equals("Integer")){
                setPropToBean(entity,declaredFields[i].getName(),resultSet.getInt(declaredFields[i].getName()));
            }else if(declaredFields[i].getType().getSimpleName().equals("Long")){
                setPropToBean(entity,declaredFields[i].getName(),resultSet.getLong(declaredFields[i].getName()));
            }
        }

    }



























}