package ru.lk.task20.apigateway.config;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

@Component
public class RouteValidator {
    public static final Set<String> openEndpoints = new HashSet<>();
    public static final Set<String> tokenRequiredEndpoints = new HashSet<>();

    static {
        openEndpoints.add("/api/auth/");
        openEndpoints.add("/eureka");
        openEndpoints.add("/api/news");
        openEndpoints.add("/api/school");
        openEndpoints.add("/api/art-direction");

        tokenRequiredEndpoints.add("/api/school/*/reviews");
    }

    public Predicate<ServerHttpRequest> isSecured = serverHttpRequest -> {
        String requestPath = serverHttpRequest.getURI().getPath();

        if (openEndpoints.stream().anyMatch(requestPath::contains)) {
            return tokenRequiredEndpoints.stream().anyMatch(pattern -> matchPattern(pattern, requestPath));
        }

        return true;
    };

    private boolean matchPattern(String pattern, String path) {
        String[] patternSegments = pattern.split("/");
        String[] pathSegments = path.split("/");

        if (patternSegments.length != pathSegments.length) {
            return false;
        }

        for (int i = 0; i < patternSegments.length; i++) {
            if (!patternSegments[i].equals("*") && !patternSegments[i].equals(pathSegments[i])) {
                return false;
            }
        }

        return true;
    }
}
