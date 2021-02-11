package org.example.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
    public static <E> List<E> differenceSet(List<E> list1,List<E> list2){
        List<E> res = new ArrayList<>();
        for (E item : list1){//E类型必须正确支持equals方法
            if (!list2.contains(item)){
                res.add(item);
            }
        }
        return res;
    }
}
