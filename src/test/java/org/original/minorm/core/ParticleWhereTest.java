package org.original.minorm.core;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ningcz on 15-5-11.
 */
public class ParticleWhereTest {

    private ParticleWhere particleWhere;

    @Before
    public void before(){
        particleWhere = new ParticleWhere();
    }

    /*@Test
    public void whereItem(){
        System.out.println(particleWhere.whereItem("aa[!]","123",true));
        System.out.println(particleWhere.whereItem("[!]aa","123",true));//同上
        System.out.println(particleWhere.whereItem("[!%]aa","1235",true));
        System.out.println(particleWhere.whereItem("[!]aa[%]","12357",true)); //不可用
        System.out.println(particleWhere.whereItem("aa[%]","123",true));
        System.out.println(particleWhere.whereItem("aa[%!]","123",true));

        System.out.println(particleWhere.whereItem("aa[>]","123",false));
        System.out.println(particleWhere.whereItem("aa",new String[]{"123","123","123"},false));
        System.out.println(particleWhere.whereItem("aa[>]",123,false));
        System.out.println(particleWhere.whereItem("aa[>]",new Date(),false));
        System.out.println(particleWhere.whereItem("aa[<>]",new Integer[]{1,2},false));
        System.out.println(particleWhere.whereItem("aa[!]","123",false));
    }*/

    @Test
    public void where() throws ParticleException {

        String v = ArrayUtils.toString(new String[]{"123", "123"});
        System.out.println(v.substring(1, v.length() - 1));

        Map<String,Object> map = new HashMap();

        Map<String,Object> like = new HashMap();
        like.put("aa[!]","123");
        like.put("[!]aa","123");
        like.put("[!%]aa","1235");
        like.put("aa[%]","123");
        like.put("aa[%!]","123");
        map.put("LIKE",like);

        System.out.println(particleWhere.build(map));
    }
}
