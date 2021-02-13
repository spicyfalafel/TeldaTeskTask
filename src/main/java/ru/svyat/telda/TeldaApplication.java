package ru.svyat.telda;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.svyat.telda.model.Region;

@MappedTypes(Region.class)
@MapperScan("ru.svyat.telda.batismapper")
@SpringBootApplication
public class TeldaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeldaApplication.class, args);
	}

}
