package org.original.minorm;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;

import java.util.List;
import java.util.Map;

/**
 *
 * 数据处理工具
 *
 * Created by ningcz on 15-5-11.
 */
public class DatabaseHelper {

    private JdbcTemplate jdbcTemplate;

    /**
     *
     * @param sql
     * @throws DataAccessException
     */
    public void execute(String sql) throws DataAccessException{
        jdbcTemplate.execute(sql);
    }

    /**
     *
     * @param action
     * @param <T>
     * @return
     * @throws DataAccessException
     */
    public <T> T execute(StatementCallback<T> action) throws DataAccessException {
        return jdbcTemplate.execute(action);
    }

    /**
     *
     * @param action
     * @param <T>
     * @return
     * @throws DataAccessException
     */
    public <T> T execute(ConnectionCallback<T> action) throws DataAccessException {
        return jdbcTemplate.execute(action);
    }

    /**
     *
     * @param table
     * @param join
     * @param columns
     * @param where
     * @return
     */
    public List select(String table,Map<String,Object> join,List<Object> columns, Map<String,Object> where){
        return null;
    }

    public long insert(){return 0;}
    public long delete(){return 0;}
    public long replace(){return 0;}
    public Object get(){return null;}

    public boolean has(){return true;}

    public long count(){return 0;}

    public long max(){return 0;}
    public long min(){return 0;}
    public double arg(){return 0;}
    public long sum(){return 0;}

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
