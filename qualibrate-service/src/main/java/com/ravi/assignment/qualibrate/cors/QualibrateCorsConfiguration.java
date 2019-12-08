package com.ravi.assignment.qualibrate.cors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.cors.CorsConfiguration;

public class QualibrateCorsConfiguration extends CorsConfiguration {

    @Nullable
    public String checkOrigin(@Nullable String requestOrigin) {

        if (!StringUtils.hasText(requestOrigin)) {
            return null;
        }
        if (ObjectUtils.isEmpty(getAllowedOrigins())) {
            return null;
        }

        if (getAllowedOrigins().contains(ALL)) {
            if (getAllowCredentials() != Boolean.TRUE) {
                return ALL;
            } else {
                return requestOrigin;
            }
        }
        for (String allowedOrigin : getAllowedOrigins()) {
            if (requestOrigin.equalsIgnoreCase(allowedOrigin)) {
                return requestOrigin;
            }
            if (allowedOrigin.contains("*")) {
                // only quick, if the allowed origin includes pattern
                Pattern pattern = Pattern.compile(allowedOrigin);
                Matcher matcher = pattern.matcher(requestOrigin);
                if (matcher.matches()) {
                    return allowedOrigin;
                }
            }
        }

        return null;
    }
}
