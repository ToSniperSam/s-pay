package org.example.config;


import lombok.extern.slf4j.Slf4j;
import org.example.service.weixin.IWeixinApiService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
@Slf4j
public class Retrofit2Config {

    private static final String BASE_URL = "https://api.weixin.qq.com/";

    @Bean
    public Retrofit retrofit(){
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(JacksonConverterFactory.create()).build();

    }

    @Bean
    public IWeixinApiService weixinApiService(Retrofit retrofit){
        return retrofit.create(IWeixinApiService.class);
    }

}
