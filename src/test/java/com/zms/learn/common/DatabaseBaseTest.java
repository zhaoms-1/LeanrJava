package com.zms.learn.common;


import com.github.database.rider.core.api.configuration.DBUnit;
import org.springframework.test.annotation.DirtiesContext;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.utility.DockerImageName;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_CLASS;

@DirtiesContext(classMode = AFTER_CLASS) //一个测试类复用一个Spring Context，测试完则清理掉
@DBUnit(cacheConnection = false, //不缓存连接，会有链接失效的问题
        allowEmptyFields = true,
        caseSensitiveTableNames = true)
public abstract class DatabaseBaseTest {
    static final MariaDBContainer<?> DATABASE;

    static {
        DATABASE = new MariaDBContainer<>(DockerImageName.parse("mariadb:10.6.2")
                .asCompatibleSubstituteFor("mariadb"))
                .withUrlParam("createDatabaseIfNotExist", "true")
                .withUrlParam("autoReconnect", "true")
                .withUrlParam("characterEncoding", "true")
                .withUrlParam("useSSL", "false")
                .withUrlParam("serverTimezone", "Asia/Shanghai")
                .withReuse(false);
        DATABASE.start();
    }
}

