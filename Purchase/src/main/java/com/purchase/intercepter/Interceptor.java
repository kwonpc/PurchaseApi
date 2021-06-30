package com.purchase.intercepter;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@RequiredArgsConstructor
@Component
public class Interceptor extends HandlerInterceptorAdapter {
	
	private final ObjectMapper objectMapper;
		
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    	final ContentCachingRequestWrapper cachingRequest = (ContentCachingRequestWrapper) request;
		if (cachingRequest.getContentType() != null && cachingRequest.getContentType().contains("application/json")) {
			if (cachingRequest.getContentAsByteArray() != null && cachingRequest.getContentAsByteArray().length != 0) {
				log.info(request.getRequestURI() + "   Request Body : {}", objectMapper.readTree(cachingRequest.getContentAsByteArray()));
			}
		}
		
		final ContentCachingResponseWrapper cachingResponse = (ContentCachingResponseWrapper) response;
		if (cachingResponse.getContentType() != null && cachingResponse.getContentType().contains("application/json")) {
			if (cachingResponse.getContentAsByteArray() != null
					&& cachingResponse.getContentAsByteArray().length != 0) {
				log.info(request.getRequestURI() + "  " + response.getStatus() + "   Response Body : {}", objectMapper.readTree(cachingResponse.getContentAsByteArray()));
			}
		}
        
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}