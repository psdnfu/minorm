package org.original.minorm.core.where;

import org.original.minorm.core.ParticleException;

import java.util.Map;

/**
 * Created by ningcz on 15-5-11.
 */
public interface Particle{

    public final static String CONDITION = "^AND|OR|LIKE|MATCH|GROUP|ORDER|HAVING|LIMIT$";
    public final static String COLUMN = "(#?)([\\w\\.]+)";

    public final static String LIKE = "\\[(\\!|\\%).?\\]";
    public final static String EXP = "(\\[(\\>|\\>\\=|\\<|\\<\\=|\\!|\\<\\>|\\>\\<|\\!?~)\\])$";
    public final static String SORT = "(^[a-zA-Z0-9_\\-\\.]*)(\\s*(DESC|ASC))?";

    /**
     *
     * @param value
     * @return
     * @throws org.original.minorm.core.ParticleException
     */
    public Object build(Map<String,Object> value) throws ParticleException;
}
