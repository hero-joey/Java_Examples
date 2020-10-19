package com.hero.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
																		/* ÷∏∂®≈‰÷√¿‡ */
@ComponentScan(basePackages = "com.hero.Bean", excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {DogConfig.class, UserController.class}))
@Configuration
public class AnnotationScan {
}
