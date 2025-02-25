package com.tavant.spring.core.SpringOnlineBookStore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tavant.spring.core.SpringOnlineBookStore.impl.InMemoryBookRepository;
import com.tavant.spring.core.SpringOnlineBookStore.impl.InMemoryCartRepository;
import com.tavant.spring.core.SpringOnlineBookStore.impl.InMemoryOrderRepository;
import com.tavant.spring.core.SpringOnlineBookStore.impl.InMemoryUserRepository;
import com.tavant.spring.core.SpringOnlineBookStore.repo.BookRepository;
import com.tavant.spring.core.SpringOnlineBookStore.repo.CartRepository;
import com.tavant.spring.core.SpringOnlineBookStore.repo.OrderRepository;
import com.tavant.spring.core.SpringOnlineBookStore.repo.UserRepository;

@Configuration
@ComponentScan(basePackages = "com.tavant.spring.core.SpringOnlineBookStore")
public class AppConfig {

    @Bean
    public BookRepository bookRepository() {
        return new InMemoryBookRepository();
    }

    @Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

    @Bean
    public OrderRepository orderRepository() {
        return new InMemoryOrderRepository();
    }

    @Bean
    public CartRepository cartRepository() {
        return new InMemoryCartRepository();
    }
}
