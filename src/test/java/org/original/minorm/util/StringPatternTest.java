package org.original.minorm.util;

import org.junit.Test;
import org.junit.Assert;

/**
 * Created by ningcz on 15-5-11.
 */
public class StringPatternTest {

    @Test
    public void get() {
        String key = StringPattern.get("limit","^AND|OR|LIKE|MATCH|GROUP|ORDER|HAVING|LIMIT$");
        Assert.assertNotNull(key);

        boolean result = StringPattern.test("limit","^AND|OR|LIKE|MATCH|GROUP|ORDER|HAVING|LIMIT$");
        Assert.assertEquals(result,true);

        String column = StringPattern.get("aa[>]","^(#?)([\\w\\.]+)");
        Assert.assertNotNull(column);

        String exp = StringPattern.get("aa[>]","(\\[(\\>|\\>\\=|\\<|\\<\\=|\\!|\\<\\>|\\>\\<|\\!?~)\\])$");
        Assert.assertNotNull(exp);

        String likeColumn = StringPattern.get("[%]aa","(#?)([\\w\\.]+)");
        Assert.assertNotNull(likeColumn);

        String likeExp = StringPattern.get("[!%]aa","^\\[(\\!|\\%).\\]");
        Assert.assertNotNull(likeExp);
    }
}
