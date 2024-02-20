package com.rk.springmavendockerbasecore.configuration;

import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class EnumMappingConfiguration implements WebMvcConfigurer {

    /**
     * ApplicationConversionService registers multiple built-in converters and also StringToEnumIgnoringCaseConverterFactory:
     * that provides us out-of-the-box with handling enums as case-insensitive objects
     *
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        ApplicationConversionService.configure(registry);
    }

}
