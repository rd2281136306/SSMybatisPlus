package com.pinyougou.util;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实例辅助类
 * 
 * @author 
 * @since 
 */
public final class InstanceUtil {
    private InstanceUtil() {
    }
    /**
     * Constructs an empty ArrayList.
     */
    public static final <E> ArrayList<E> newArrayList() {
        return new ArrayList<E>();
    }

    /**
     * Constructs an empty ArrayList.
     */
    @SuppressWarnings("unchecked")
    public static final <E> ArrayList<E> newArrayList(E... e) {
        ArrayList<E> list = new ArrayList<E>();
        Collections.addAll(list, e);
        return list;
    }

    /**
     * Constructs an empty HashMap.
     */
    public static final <k, v> HashMap<k, v> newHashMap() {
        return new HashMap<k, v>();
    }

    /**
     * Constructs an empty HashSet.
     */
    public static final <E> HashSet<E> newHashSet() {
        return new HashSet<E>();
    }

    /**
     * Constructs an empty Hashtable.
     */
    public static final <k, v> Hashtable<k, v> newHashtable() {
        return new Hashtable<k, v>();
    }

    /**
     * Constructs an empty LinkedHashMap.
     */
    public static final <k, v> LinkedHashMap<k, v> newLinkedHashMap() {
        return new LinkedHashMap<k, v>();
    }

    /**
     * Constructs an empty LinkedHashSet.
     */
    public static final <E> LinkedHashSet<E> newLinkedHashSet() {
        return new LinkedHashSet<E>();
    }

    /**
     * Constructs an empty LinkedList.
     */
    public static final <E> LinkedList<E> newLinkedList() {
        return new LinkedList<E>();
    }

    /**
     * Constructs an empty TreeMap.
     */
    public static final <k, v> TreeMap<k, v> newTreeMap() {
        return new TreeMap<k, v>();
    }

    /**
     * Constructs an empty TreeSet.
     */
    public static final <E> TreeSet<E> newTreeSet() {
        return new TreeSet<E>();
    }

    /**
     * Constructs an empty Vector.
     */
    public static final <E> Vector<E> newVector() {
        return new Vector<E>();
    }

    /**
     * Constructs an empty WeakHashMap.
     */
    public static final <k, v> WeakHashMap<k, v> newWeakHashMap() {
        return new WeakHashMap<k, v>();
    }

    /**
     * Constructs an empty HashMap.
     */
    public static final <k, v> Map<k, v> newHashMap(k key, v value) {
        Map<k, v> map = newHashMap();
        map.put(key, value);
        return map;
    }

    /**
     * Constructs an empty ConcurrentHashMap.
     */
    public static final <k, v> ConcurrentHashMap<k, v> newConcurrentHashMap() {
        return new ConcurrentHashMap<k, v>();
    }
}
