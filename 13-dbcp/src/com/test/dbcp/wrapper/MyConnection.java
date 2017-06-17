package com.test.dbcp.wrapper;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/6/17.
 * email: wangsongyan921@163.com
 */
public class MyConnection extends ConnectionWrapper {

    public MyConnection(Connection connection) {
        super(connection);
    }

    @Override
    public void close() throws SQLException {
        System.out.println("wrapper");
        super.close();
    }
}
