package io.trabe.blog.filtersandresolvers.controller.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import io.trabe.blog.filtersandresolvers.controller.util.RequestUtils;
import io.trabe.blog.filtersandresolvers.model.pojo.ContextInformation;

@Component
public class ContextInformationResolverV3 implements HandlerMethodArgumentResolver {

    private final RequestUtils requestUtils;

    public ContextInformationResolverV3(RequestUtils requestUtils) {
        this.requestUtils = requestUtils;
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(ContextInformation.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        return requestUtils.getContextInformation(nativeWebRequest);
    }
}
