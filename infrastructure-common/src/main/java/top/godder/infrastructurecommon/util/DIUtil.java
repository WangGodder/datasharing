package top.godder.infrastructurecommon.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author: godder
 * @date: 2019/4/5
 */
public class DIUtil {
    /**
     * 通过Map将值注入到对象中
     * @param map map（key - value）
     * @param clazz 类型
     * @param <T> 类型
     * @return 注入后的对象
     * @throws IllegalAccessException 没有共有无参构建函数
     * @throws InstantiationException setter方法参数类型不符合
     * @throws InvocationTargetException setter方法执行错误
     */
    public static <T> T  createByMap(Map<String, Object> map, Class<T> clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T instance = null;
        try {
            instance = clazz.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException e) {
            System.err.println("该类型缺少无参构造方法");
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Field field = null;
            try {
                field = clazz.getDeclaredField(entry.getKey());
            } catch (NoSuchFieldException e) {
                continue;
            }
            Method method = null;
            Class type = field.getType();
            try {
                method = clazz.getMethod(getSetMethod(entry.getKey()), field.getType());
            } catch (NoSuchMethodException e) {
                System.err.println(entry.getKey() + " 无setter方法");
            }
            method.invoke(instance, entry.getValue());
        }
        return instance;
    }

    private static String getSetMethod(String valueName) {
        if (valueName == null || valueName.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder("set");
        sb.append(Character.toUpperCase(valueName.charAt(0)));
        sb.append(valueName.substring(1));
        return sb.toString();
    }

}
