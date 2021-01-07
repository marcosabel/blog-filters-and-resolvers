package io.trabe.blog.filtersandresolvers.controller.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import io.trabe.blog.filtersandresolvers.model.pojo.ContextInformation;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ContextInformationResolver implements HandlerMethodArgumentResolver {

    private final ObjectMapper objectMapper;

    public ContextInformationResolver(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(ContextInformation.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String jsonContext = nativeWebRequest.getHeader("X-App-Context");
        return objectMapper.readValue(jsonContext, ContextInformation.class);
    }
}
