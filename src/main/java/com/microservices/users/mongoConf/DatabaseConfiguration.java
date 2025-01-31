package com.microservices.users.mongoConf;

import com.microservices.shared_utils.threadLocals.MongoConnectionStorage;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import java.util.Objects;

public class DatabaseConfiguration extends SimpleMongoClientDatabaseFactory {

    public DatabaseConfiguration(ConnectionString connectionString) {
        super(connectionString);
    }

    @Override
    protected MongoDatabase doGetMongoDatabase(String dbName) {
        ConnectionString connectionString = new ConnectionString(MongoConnectionStorage.getConnection());
        return super.doGetMongoDatabase(Objects.requireNonNull(connectionString.getDatabase()));
    }
}
