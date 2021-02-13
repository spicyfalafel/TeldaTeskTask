package ru.svyat.telda;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import ru.svyat.telda.model.Region;

@MappedTypes(Region.class)
@MapperScan("ru.svyat.telda.batismapper")
@SpringBootApplication
@EnableCaching
public class TeldaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeldaApplication.class, args);
	}

}
