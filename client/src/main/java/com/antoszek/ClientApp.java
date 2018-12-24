package com.antoszek;

        import org.modelmapper.ModelMapper;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class ClientApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(ClientApp.class,args);
        System.out.println( "Hello Modul Client" );
    }
//    @Bean
//    public ModelMapper modelMapper() {
//        return new ModelMapper();
//    }
}
