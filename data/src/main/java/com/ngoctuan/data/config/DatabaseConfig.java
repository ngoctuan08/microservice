package com.ngoctuan.data.config;

import io.vertx.core.Vertx;
import io.vertx.mysqlclient.MySQLConnectOptions;
import io.vertx.mysqlclient.MySQLPool;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.SqlClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Value("${mysql.host}")
    private String host;

    @Value("${mysql.port}")
    private int port;

    @Value("${mysql.database}")
    private String database;

    @Value("${mysql.username}")
    private String user;

    @Value("${mysql.password}")
    private String password;

    @Bean
    public Vertx vertx() {
        return Vertx.vertx();
    }

    @Bean
    public SqlClient mySqlClient(Vertx vertx) {
        MySQLConnectOptions mySQLConnectOptions = new MySQLConnectOptions().setHost(host)
                .setPort(port)
                .setUser(user)
                .setPassword(password)
                .setDatabase(database);

        PoolOptions poolOptions = new PoolOptions().setMaxSize(10);
        return MySQLPool.pool(vertx, mySQLConnectOptions, poolOptions);
    }
}
