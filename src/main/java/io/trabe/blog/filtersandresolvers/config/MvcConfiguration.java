package io.trabe.blog.filtersandresolvers.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.trabe.blog.filtersandresolvers.controller.resolver.ContextInformationResolverV3;
import io.trabe.blog.filtersandresolvers.controller.resolver.UserInformationtResolverV3;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    private final ContextInformationResolverV3 contextInformationResolver;
    private final UserInformationtResolverV3 userInformationtResolver;

    public MvcConfiguration(
            ContextInformationResolverV3 contextInformationResolver,
            UserInformationtResolverV3 userInformationtResolver) {
        this.contextInformationResolver = contextInformationResolver;
        this.userInformationtResolver = userInformationtResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(contextInformationResolver);
        argumentResolvers.add(userInformationtResolver);
    }

}
