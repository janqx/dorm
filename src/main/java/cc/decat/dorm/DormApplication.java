package cc.decat.dorm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cc.decat.dorm.mapper")
public class DormApplication {

    public static void main(String[] args) {
        System.out.println("start...");
        SpringApplication.run(DormApplication.class, args);

    }

}
