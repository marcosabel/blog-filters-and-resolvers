package io.trabe.blog.filtersandresolvers.controller.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import io.trabe.blog.filtersandresolvers.model.pojo.ContextInformation;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RequestUtils {

    private final ObjectMapper objectMapper;

    private static final String APP_CONTEXT_HEADER = "X-App-Context";
    private static final String REQUEST_ATTRIBUTE_APP_CONTEXT = "appContext";

    public RequestUtils(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void storeContextInformationAsRequestAttribute(HttpServletRequest request) throws IOException {
        String jsonHeader = request.getHeader(APP_CONTEXT_HEADER);

        if (jsonHeader != null) {
            request.setAttribute(REQUEST_ATTRIBUTE_APP_CONTEXT,
                    objectMapper.readValue(jsonHeader, ContextInformation.class));
        }
    }

    public ContextInformation getContextInformation(NativeWebRequest request) {
        return (ContextInformation) request.getAttribute(REQUEST_ATTRIBUTE_APP_CONTEXT, 0);
    }
}
