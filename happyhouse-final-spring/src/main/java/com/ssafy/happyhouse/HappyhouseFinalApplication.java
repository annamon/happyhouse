package com.ssafy.happyhouse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class HappyhouseFinalApplication {
	// 이것을 실행시키면 레스트풀 메인 시작
	public static void main(String[] args) {
		SpringApplication.run(HappyhouseFinalApplication.class, args);
	}
}
//http://localhost:8080/happyhouse_final/swagger-ui.html
