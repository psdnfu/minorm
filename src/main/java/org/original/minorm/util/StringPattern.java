package org.original.minorm.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ningcz on 15-5-11.
 */
public class StringPattern {

    /**
     *
     * @param value
     * @param pattern
     * @return
     */
    public static String get(String value,String pattern){
        List list = StringPattern.find(value,pattern);
        if(list.isEmpty()){
            return null;
        }

        return StringPattern.find(value,pattern).get(0);
    }

    /**
     *
     * @param value
     * @param pattern
     * @return
     */
    public static List<String> find(String value,String pattern){
        Pattern p = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(value);
        List<String> result = new ArrayList<String>();
        while(m.find()){
            result.add(m.group());
        }
        return result;
    }

    /**
     *
     * @param value
     * @param pattern
     * @return
     */
    public static boolean test(String value,String pattern){
        Pattern p = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(value);
        return m.find();
    }
}
