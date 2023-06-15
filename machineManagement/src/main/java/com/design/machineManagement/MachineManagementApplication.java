package com.design.machineManagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.design.machineManagement.mapper")
@ComponentScan(value="com.design")
public class MachineManagementApplication {

		public static void main(String[] args) {

			try {
				SpringApplication.run(MachineManagementApplication.class, args);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
