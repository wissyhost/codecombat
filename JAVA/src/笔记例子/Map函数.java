package 笔记例子;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Map函数 {
	/**
	 * Map:映射类(key,value) 
	 * 	1.一组数据分两个,一个是键(key),一个是内容(value)
	 * 	2.Map常见两个实现类:HashMap,TreeMap 
	 * 	3.Map属于数据层, 
	 * 	4.key属于Set集合类型,特点不重复
	 * 
	 * @return
	 * 
	 */
	public static void hashMap() {
		// 遍历一
		Map hashmap = new HashMap();
		// 放数据过程
		for (int i = 0; i < 26; i++) {
			hashmap.put(i, (char) ('a' + i));// 放数据
		}
		hashmap.remove(2);
		Set keys = hashmap.keySet();// 获取key集合
		Iterator itmap = keys.iterator();// 获取迭代
		while (itmap.hasNext()) {// 判断是否到集合最后
			int key = (Integer) itmap.next();// 取key
			// 显示key和value
			System.out.println("key=" + key + "value" + hashmap.get(key));
		}
		// 遍历方式二
		Collection vs = hashmap.values();// 获取map中value的集合
		Iterator it = vs.iterator();// 获取迭代器
		while (it.hasNext()) {// 判断下一个是否为空
			char j = (Character) it.next();
			System.out.println(j);
		}

	}

	public static void main(String[] args) {
		Map函数.hashMap();

	}

}
