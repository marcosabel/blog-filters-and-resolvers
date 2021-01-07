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

@Component
public class UserInformationtResolverV2 implements HandlerMethodArgumentResolver {

    private final UserService userService;

    public UserInformationtResolverV2(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(UserInformation.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        ContextInformation contextInformation = (ContextInformation) nativeWebRequest
                .getAttribute("appContext", 0);
        return userService.getUserInformation(contextInformation.getUserId());
    }
}
