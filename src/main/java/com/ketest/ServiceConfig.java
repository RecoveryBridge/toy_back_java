package com.ketest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//----------------------------------------------------------------------
// ■Service Bean 설정 ■ymjo ■2018-11-19
//----------------------------------------------------------------------
@Configuration
public class ServiceConfig implements WebMvcConfigurer {

    /** [kgchoi] 2024.07
     *  원래는 TokenCheckInterceptor를 통해 헤더에서 access token 값 가져와서 모든 요청에 필터를 걸려고 했으나
     *  CORS 정책으로 인해 임의로 지정한 Authorization 헤더가 사라지는 현상이 발생함
     *  이를 막기위해 CORS 정책 허용을 ServiceConfig.java 에서 addCorsMappings 메소드로 하려 했으나
     *  처음 진입페이지 (주문상세)가 결제모듈이 아닌 메타데미 프론트소스(vue)에서 시작되어서
     *  결제모듈에 설정한 CORS 정책(임의로 설정한 Authorization 헤더 허용)이 적용되지 않아서
     *  부득이하게 매 controller 요청마다 헤더에서 토큰을 가져와 비교하는걸로 일단은 가기로 하였음
     *  */

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로에 대해 CORS 설정
                .allowedOrigins("http://localhost:3000") // 허용할 출처
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP 메서드
                .allowedHeaders("Authorization", "Content-Type") // 허용할 요청 헤더
                .exposedHeaders("Authorization", "Content-Type") // 클라이언트에서 접근 가능한 응답 헤더
                .allowCredentials(true); // 인증 정보(쿠키, 인증 헤더 등) 허용
    }

}