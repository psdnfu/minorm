package org.original.minorm.core;

import org.original.minorm.core.where.LikeParticle;
import org.original.minorm.core.where.Particle;

import java.util.Map;

/**
 * ? 提取或者替换的数据
 * # 关键子
 * : 表达式分割
 * @ 要替换或者提取字段的位置
 *
 * Created by ningcz on 15-5-11.
 */
public class ParticleWhere{

    private Particle like = new LikeParticle();

    /**
     *
     * @param value
     * @return
     * @throws ParticleException
     */
    public String build(Object value) throws ParticleException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(like.build(this.getLike((Map<String, Object>) value)));
        return stringBuilder.toString();
    }

    public void setLike(Particle like) {
        this.like = like;
    }

    /**
     *
     * @param value
     * @return
     */
    protected Map<String,Object> getLike(Map<String, Object> value){
        return (Map<String, Object>) value.get("LIKE");
    }

    /**
     *
     * @param value
     * @return
     */
    protected Map<String,Object> getAnd(Map<String, Object> value){
        return (Map<String, Object>) value.get("AND");
    }

    /**
     *
     * @param value
     * @return
     */
    protected Map<String,Object> getOR(Map<String, Object> value){
        return (Map<String, Object>)value.get("OR");
    }

    /**
     *
     * @param value
     * @return
     */
    protected Object getMatch(Map<String, Object> value){
        return value.get("MATCH");
    }

    /**
     *
     * @param value
     * @return
     */
    protected Object getGroup(Map<String, Object> value){
        return value.get("GROUP");
    }

    /**
     *
     * @param value
     * @return
     */
    protected Object getOrder(Map<String, Object> value){
        return value.get("ORDER");
    }

    /**
     *
     * @param value
     * @return
     */
    protected Object getHaving(Map<String, Object> value){
        return value.get("HAVING");
    }

    /**
     *
     * @param value
     * @return
     */
    protected Object getLimit(Map<String, Object> value){
        return value.get("LIMIT");
    }
}