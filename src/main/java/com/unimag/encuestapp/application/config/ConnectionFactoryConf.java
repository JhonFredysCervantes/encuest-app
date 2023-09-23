package com.unimag.encuestapp.application.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import io.r2dbc.spi.Option;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.core.DatabaseClient;

import static io.r2dbc.spi.ConnectionFactoryOptions.DATABASE;
import static io.r2dbc.spi.ConnectionFactoryOptions.DRIVER;
import static io.r2dbc.spi.ConnectionFactoryOptions.HOST;
import static io.r2dbc.spi.ConnectionFactoryOptions.PASSWORD;
import static io.r2dbc.spi.ConnectionFactoryOptions.PORT;
import static io.r2dbc.spi.ConnectionFactoryOptions.SSL;
import static io.r2dbc.spi.ConnectionFactoryOptions.USER;

/**
 * Connection factory configuration
 */
@Configuration
@EnableR2dbcRepositories
public class ConnectionFactoryConf {
    private static final String ALLOW_PUBLIC_KEY_RETRIEVAL = "allowPublicKeyRetrieval";

    @Value("${encuestapp.driver}")
    private String driver;
    @Value("${encuestapp.username}")
    private String username;
    @Value("${encuestapp.password}")
    private String password;
    @Value("${encuestapp.host}")
    private String host;
    @Value("${encuestapp.port}")
    private int port;
    @Value("${encuestapp.database}")
    private String database;

    /**
     * Connection factory bean
     * <br>
     *
     * @return The connection factory
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        var connectionFactoryOptions = ConnectionFactoryOptions.builder()
                .option(DRIVER, driver)
                .option(USER, username)
                .option(PASSWORD, password)
                .option(HOST, host)
                .option(PORT, port)
                .option(DATABASE, database)
                .option(SSL, false)
                .option(Option.valueOf(ALLOW_PUBLIC_KEY_RETRIEVAL), true)
                .build();
        return ConnectionFactories.get(connectionFactoryOptions);
    }

    /**
     * Database client bean
     * <br>
     *
     * @param connectionFactory The connection factory
     * @return The database client
     */
    @Bean
    DatabaseClient databaseClient(ConnectionFactory connectionFactory) {
        return DatabaseClient.builder()
                .connectionFactory(connectionFactory)
                .build();
    }

}
