package com.github.liquidjoo.placesearch.local.place.interceptor;

import com.github.liquidjoo.placesearch.config.KeywordCache;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.Arrays;

public class KeywordInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {

        try {
            final String[] split = request.getQueryString().split("&");
            final String query = Arrays.stream(split)
                    .filter(keyword -> keyword.contains("query"))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException("잘 못 요청된 쿼리 입니다."));

            final String[] splitQuery = query.split("=");
            final String value = splitQuery[1];

            if (Strings.isBlank(value)) {
                return false;
            }

            KeywordCache.add(URLDecoder.decode(value, "UTF-8"));
        } catch (Exception e) {
            return false;
        }

        return super.preHandle(request, response, handler);
    }
}
