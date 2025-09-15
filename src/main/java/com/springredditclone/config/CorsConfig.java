package com.springredditclone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // 🔑 Dominios permitidos: producción, previews de Vercel y entorno local
        configuration.setAllowedOrigins(Arrays.asList(
                "https://frontend-reddit-clone-o23t.vercel.app",
                "https://frontend-reddit-clone-o23t-git-main-diego-bravos-projects.vercel.app",
                "https://frontend-reddit-clone-o23t-qynmwru0v-diego-bravos-projects.vercel.app",
                "http://localhost:4200"
        ));

        // Métodos permitidos
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Headers permitidos
        configuration.setAllowedHeaders(List.of("*"));

        // Necesario si usas cookies o Authorization headers
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}