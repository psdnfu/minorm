package org.original.minorm.core.where;

import org.apache.commons.lang3.ArrayUtils;
import org.original.minorm.core.ParticleException;

/**
 * Created by ningcz on 15-5-11.
 */
public class GroupParticle extends AbstractParticle {

    @Override
    public String buildItem(String key, Object value) throws ParticleException {
        if(value instanceof String){
            return (String)value;
        }else if(value instanceof String[]){
            String v = ArrayUtils.toString(value);
            return v.substring(1,v.length()-1);
        }

        throw new GroupParticleException();
    }
}
