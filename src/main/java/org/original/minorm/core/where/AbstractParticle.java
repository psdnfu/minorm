package org.original.minorm.core.where;

import org.original.minorm.core.ParticleException;
import org.original.minorm.util.StringPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ningcz on 15-5-11.
 */
public abstract class AbstractParticle implements Particle {

    /**
     *
     * @param value
     * @return
     * @throws ParticleException
     */
    public Map<String,Object> build(Map<String,Object> value) throws ParticleException{
        Map<String,Object> map = new HashMap<String, Object>();
        processBuild(value,map);
        return map;
    }

    /**
     *
     * @param value
     * @param result
     */
    private void processBuild(Map<String,Object> value,Map<String,Object> result) throws ParticleException {
        for(String key: value.keySet()){
            if(this.isColumn(key)){
                Object v = value.get(key);
                result.put(key, buildItem(key,v));
            }else{
                Map<String,Object> map = new HashMap<String, Object>();
                processBuild((Map<String, Object>) value.get(key),map);
                result.put(key,map);
            }
        }
    }

    /**
     *
     * @param key
     * @param value
     * @return
     * @throws ParticleException
     */
    public abstract String buildItem(String key,Object value) throws ParticleException;

    /**
     * 获取字段信息
     *
     * @param key
     * @return
     */
    protected String getColumn(String key){
        return StringPattern.get(key, COLUMN);
    }

    /**
     * 获取表达式
     * @param key
     * @return
     */
    protected String getExpression(String key,boolean like){
        if(like) return StringPattern.get(key,LIKE);
        return StringPattern.get(key,EXP);
    }

    /**
     * 判断是否为字段
     * @param key
     * @return
     */
    protected boolean isColumn(String key){
        return !StringPattern.test(key,CONDITION);
    }
}
