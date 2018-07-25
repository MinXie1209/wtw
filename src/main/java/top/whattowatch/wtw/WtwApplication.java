package top.whattowatch.wtw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("top.whattowatch.wtw.mapper")
@ServletComponentScan
public class WtwApplication {

    public static void main(String[] args) {
        SpringApplication.run(WtwApplication.class, args);
    }
}
