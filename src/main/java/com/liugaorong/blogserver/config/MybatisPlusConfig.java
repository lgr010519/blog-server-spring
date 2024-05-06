package com.liugaorong.blogserver.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {

    /**
     * IPage的分页使用的是拦截器，属于物理分页，好处就是处理大量数据时，查询速度快。
     *
     * @return MybatisPlus拦截器
     */
//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        // 向MybatisPlus拦截器链中添加分页拦截器
//        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
//        return interceptor;
//    }
}
