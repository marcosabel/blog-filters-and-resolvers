package io.trabe.blog.filtersandresolvers.controller.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import io.trabe.blog.filtersandresolvers.controller.util.RequestUtils;
import io.trabe.blog.filtersandresolvers.model.pojo.UserInformation;
import io.trabe.blog.filtersandresolvers.model.service.UserService;

@Component
public class UserInformationtResolverV3 implements HandlerMethodArgumentResolver {

    private final UserService userService;
    private final RequestUtils requestUtils;

    public UserInformationtResolverV3(UserService userService,
            RequestUtils requestUtils) {
        this.userService = userService;
        this.requestUtils = requestUtils;
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(UserInformation.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        return userService.getUserInformation(requestUtils.getContextInformation(nativeWebRequest).getUserId());
    }
}
