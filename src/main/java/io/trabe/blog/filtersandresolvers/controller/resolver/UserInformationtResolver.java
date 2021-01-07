package io.trabe.blog.filtersandresolvers.controller.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import io.trabe.blog.filtersandresolvers.model.pojo.ContextInformation;
import io.trabe.blog.filtersandresolvers.model.pojo.UserInformation;
import io.trabe.blog.filtersandresolvers.model.service.UserService;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class UserInformationtResolver implements HandlerMethodArgumentResolver {

    private final ObjectMapper objectMapper;
    private final UserService userService;

    public UserInformationtResolver(ObjectMapper objectMapper,
            UserService userService) {
        this.objectMapper = objectMapper;
        this.userService = userService;
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(UserInformation.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String jsonContext = nativeWebRequest.getHeader("X-App-Context");
        ContextInformation contextInformation = objectMapper.readValue(jsonContext, ContextInformation.class);
        return userService.getUserInformation(contextInformation.getUserId());
    }
}
