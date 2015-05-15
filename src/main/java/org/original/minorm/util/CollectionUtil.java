package org.original.minorm.util;

import java.util.Collection;
import java.util.Map;

/**
 * Created by ningcz on 15-5-11.
 */
public class CollectionUtil {

    /**
     *
     * @param map
     * @return
     */
    public static boolean isEmpty(Map map){
        if(null == map){
            return true;
        }else if(map.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     *
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection collection){
        if(null == collection){
            return true;
        }else if(collection.isEmpty()){
            return true;
        }
        return false;
    }
}
