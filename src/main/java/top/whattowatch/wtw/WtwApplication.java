package top.whattowatch.wtw;


import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("top.whattowatch.wtw.mapper")
@ServletComponentScan
@EnableAdminServer
@EnableScheduling
public class WtwApplication {

    public static void main(String[] args) {
        SpringApplication.run(WtwApplication.class, args);
    }
}
