//package com.spring.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by Desiom on 2018/6/5.
// */
//@Component
//public class CorsConfig extends HandlerInterceptorAdapter {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //添加跨域CORS
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type,token");
//        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
//        return true;
//    }
//}
////@Configuration
////public class CorsConfig {
////    private CorsConfiguration buildConfig() {
////        CorsConfiguration corsConfiguration = new CorsConfiguration();
////        corsConfiguration.addAllowedOrigin("*"); // 1允许任何域名使用
////        corsConfiguration.addAllowedHeader("*"); // 2允许任何头
////        corsConfiguration.addAllowedMethod("*"); // 3允许任何方法（post、get等）
////        return corsConfiguration;
////    }
////
////    @Bean
////    public CorsFilter corsFilter() {
////        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////        source.registerCorsConfiguration("/**", buildConfig()); // 4
////        return new CorsFilter(source);
////    }
////}
////public class Application extends WebMvcConfigurerAdapter {
////
////    @Override
////    public void addCorsMappings(CorsRegistry registry) {
////
////        registry.addMapping("/**")
////                .allowCredentials(true)
////                .allowedHeaders("*")
////                .allowedOrigins("*")
////                .allowedMethods("*");
////
////    }
////}
