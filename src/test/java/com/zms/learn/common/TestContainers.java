package com.zms.learn.common;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.utility.DockerImageName;

public abstract class TestContainers {
    static final MariaDBContainer DATA_BASE;
    static final GenericContainer REDIS;


    static {
        DATA_BASE = (MariaDBContainer) new MariaDBContainer(DockerImageName.parse("mariadb:10.6.2")
                .asCompatibleSubstituteFor("mariadb"))
                .withUrlParam("createDatabaseIfNotExist", "true")
                .withUrlParam("autoReconnect", "true")
                .withUrlParam("characterEncoding", "true")
                .withUrlParam("useSSL", "false")
                .withUrlParam("serverTimezone", "Asia/Shanghai")
                .withReuse(false);
        DATA_BASE.start();


        REDIS = new GenericContainer(DockerImageName.parse("redis:5.0.3-alpine"))
                .withExposedPorts(6379);
        REDIS.start();
    }
}
