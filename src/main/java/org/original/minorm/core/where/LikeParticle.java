package org.original.minorm.core.where;

import org.apache.commons.lang3.StringUtils;
import org.original.minorm.core.ParticleException;
/**
 * Created by ningcz on 15-5-11.
 */
public class LikeParticle extends AbstractParticle {

    /**
     *
     * @param key
     * @param value
     * @return
     */
    public String buildItem(String key,Object value) throws ParticleException{
        StringBuilder sb = new StringBuilder();
        String column = this.getColumn(key);
        String expression = this.getExpression(key,true);

        if(StringUtils.isEmpty(expression)){
            sb.append(column.toUpperCase()).append(" LIKE ").append("'%").append(value).append("%'");
        }else if(expression.indexOf("!") >0){
            sb.append(column.toUpperCase()).append(" NOT LIKE ");
            if(expression.indexOf("%")>0){
                if(key.startsWith(expression)){
                    sb.append("'%").append(value).append("'");
                }else{
                    sb.append("'").append(value).append("%'");
                }
            }else{
                sb.append("'%").append(value).append("%'");
            }
        }else{
            sb.append(column.toUpperCase()).append(" LIKE ");
            if(key.startsWith(expression)){
                sb.append("'%").append(value).append("'");
            }else{
                sb.append("'").append(value).append("%'");
            }
        }
        return sb.toString();
    }
}
