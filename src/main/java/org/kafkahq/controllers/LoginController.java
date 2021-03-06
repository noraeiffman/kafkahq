package org.kafkahq.controllers;

import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.StringUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.config.SecurityConfigurationProperties;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.views.View;

import java.util.Optional;

@Secured(SecurityRule.IS_ANONYMOUS)
@Requires(property = SecurityConfigurationProperties.PREFIX + ".enabled", value = StringUtils.TRUE)
@Controller
public class LoginController extends AbstractController {
    @Get("/login{/failed:[a-zA-Z]+}")
    @View("login")
    public HttpResponse login(Optional<String> failed) {
        return HttpResponse
            .ok()
            .body(templateData(Optional.empty(), "failed", failed));
    }
}
