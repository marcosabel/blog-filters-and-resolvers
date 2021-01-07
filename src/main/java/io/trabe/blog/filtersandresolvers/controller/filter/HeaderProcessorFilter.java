package io.trabe.blog.filtersandresolvers.controller.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import io.trabe.blog.filtersandresolvers.model.pojo.ContextInformation;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HeaderProcessorFilter extends OncePerRequestFilter {

    private static final String APP_CONTEXT_HEADER = "X-App-Context";
    private static final String REQUEST_ATTRIBUTE_APP_CONTEXT = "appContext";

    private final ObjectMapper objectMapper;

    public HeaderProcessorFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws
            IOException, ServletException {
        String jsonHeader = request.getHeader(APP_CONTEXT_HEADER);

        if (jsonHeader != null) {
            request.setAttribute(REQUEST_ATTRIBUTE_APP_CONTEXT,
                    objectMapper.readValue(jsonHeader, ContextInformation.class));
        }

        filterChain.doFilter(request, response);

    }
}
