package com.jk.game.hearthstone.core.util;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * @author jk
 * @date 2020/10/11 23:09
 */
public class DeepCloneUtil {

    public static Object deepClone(Object object) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(object);
        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(is);
        return ois.readObject();
    }

    public static Object deepClone2(Object object) throws InstantiationException, IllegalAccessException {
        Map<Object,Object> cloneCache = new HashMap<>(64);
        return deepClone1(object,cloneCache);
    }

    private static Object deepClone1(Object object,Map<Object,Object> cloneCache) throws IllegalAccessException, InstantiationException {
        if(object instanceof Collection){
            return deepCloneForCollection((Collection<?>) object,cloneCache);
        }
        else if (object instanceof Map){
            return deepCloneForMap((Map<?, ?>) object,cloneCache);
        }
        else if(object.getClass().isEnum()){
            return object;
        }
        Object duplicate = cloneCache.get(object);
        if(duplicate == null){
            duplicate = object.getClass().newInstance();
            cloneCache.put(object,duplicate);
            Field[] fields = getAllFields(object.getClass());
            for (Field field : fields) {
                if(Modifier.isFinal(field.getModifiers())){
                    continue;
                }
                field.setAccessible(true);
                if(Collection.class.isAssignableFrom(field.getType())){
                    Collection<Object> cloneCollection  = deepCloneForCollection((Collection<?>) field.get(object),cloneCache);
                    field.set(duplicate,cloneCollection);
                }
                else if(Map.class.isAssignableFrom(field.getType())){
                    Map<Object, Object> cloneMap = deepCloneForMap((Map<?, ?>) field.get(object), cloneCache);
                    field.set(duplicate,cloneMap);
                }
                else {
                    if(field.getType().isPrimitive() || isWrapper(field.getType())){
                        field.set(duplicate,field.get(object));
                    }
                    else if (field.get(object) != null && field.getType() != object.getClass()){
                        Object clone = deepClone1(field.get(object),cloneCache);
                        field.set(duplicate,clone);
                    }
                }
            }
        }
        return duplicate;
    }

    private static Collection<Object> deepCloneForCollection(Collection<?> collection,Map<Object,Object> cloneCache) throws InstantiationException, IllegalAccessException {
        Collection<Object> cloneCollection;
        if(collection instanceof List){
            cloneCollection = new ArrayList<>();
        }else {
            cloneCollection = new HashSet<>();
        }
        for (Object o : collection) {
            cloneCollection.add(deepClone1(o,cloneCache));
        }
        return cloneCollection;
    }

    private static Map<Object,Object> deepCloneForMap(Map<?,?> map,Map<Object,Object> cloneCache) throws InstantiationException, IllegalAccessException {
        Map<Object,Object> cloneMap = new HashMap<>(map.size());
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object cloneKey = deepClone1(entry.getKey(),cloneCache);
            Object cloneValue = deepClone1(entry.getValue(),cloneCache);
            cloneMap.put(cloneKey,cloneValue);
        }
        return cloneMap;
    }

    private static Field[] getAllFields(Class<?> c){
        List<Field> fieldList = new ArrayList<>();
        while (c!=null){
            fieldList.addAll(new ArrayList<>(Arrays.asList(c.getDeclaredFields())));
            c = c.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }
    
    /**
     * 判断一个类是否为包装类 String被认为是特殊的包装类
     * @param clazz
     * @return
     */
    private static boolean isWrapper(Class<?> clazz){
        return clazz == Integer.class || clazz == Short.class || clazz == Long.class
                || clazz == Byte.class || clazz == Float.class || clazz == Double.class
                || clazz == Character.class || clazz == Boolean.class || clazz == String.class;
    }
}
