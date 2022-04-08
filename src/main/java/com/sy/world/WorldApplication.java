package com.sy.world;

import com.sy.world.entity.Staff;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Scanner;

@SpringBootApplication
@EnableConfigurationProperties({Staff.class})
@PropertySource("application.yml")
public class WorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorldApplication.class, args);
    }

}


