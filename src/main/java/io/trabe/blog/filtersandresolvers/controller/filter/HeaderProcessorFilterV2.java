package io.trabe.blog.filtersandresolvers.controller.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.trabe.blog.filtersandresolvers.controller.util.RequestUtils;

@Component
public class HeaderProcessorFilterV2 extends OncePerRequestFilter {

    private final RequestUtils requestUtils;

    public HeaderProcessorFilterV2(RequestUtils requestUtils) {
        this.requestUtils = requestUtils;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws
            IOException, ServletException {
        requestUtils.storeContextInformationAsRequestAttribute(request);
        filterChain.doFilter(request, response);
    }
}
