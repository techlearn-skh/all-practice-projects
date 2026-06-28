package com.skh;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
@Tag(name = "OCPDemoController API", description = "OCPDemoController Operations")
public class OCPDemoController {

    private static final Logger logger = LoggerFactory.getLogger(OCPDemoController.class);

    @Autowired
    private Environment environment;

    @Operation(summary = "Welcome message", description = "Returns a welcome message with host/pod info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response")
    })
    @GetMapping("/")
    public String welcomeMessage() throws Exception {
        logger.info("Hi welcome to OCPDemoController, port: " + environment.getProperty("server.port"));
        logger.debug("Hi welcome to OCPDemoController, port: " + environment.getProperty("server.port"));
        logger.info(printHostIpPort());
        return "Hi welcome to OCPDemoController, port: " + printHostIpPort();
    }


    public String printHostIpPort() throws Exception {
        String podName = System.getenv("POD_NAME");
        String podIp = System.getenv("POD_IP");
        // Local development fallback
        InetAddress localhost = InetAddress.getLocalHost();
        if (podName == null || podName.isBlank()) {
            podName = localhost.getHostName();
        }
        if (podIp == null || podIp.isBlank()) {
            podIp = localhost.getHostAddress();
        }
        String port = environment.getProperty("server.port");
        return "[Host/Pod Name : %s, IP Address: %s, Port: %s, Timestamp: %s]".formatted(podName, podIp, port, java.time.LocalDateTime.now());
    }

    @Operation(summary = "Fetch full name", description = "Returns full name with pod info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response"),
            @ApiResponse(responseCode = "400", description = "Missing or invalid parameters")
    })
    @GetMapping("/fullName")
    public String fetchFullName(
            @Parameter(description = "First name", required = true) @RequestParam String firstName,
            @Parameter(description = "Last name", required = true)  @RequestParam String lastName) throws Exception {
        logger.info(String.format("Hi your full name is %s %s, port: %s", firstName, lastName, environment.getProperty("server.port")));
        logger.debug(String.format("Hi your full name is %s %s, port: %s", firstName, lastName, environment.getProperty("server.port")));
        logger.info(printHostIpPort());
        return String.format("Hi your full name is %s %s, port: %s", firstName, lastName, printHostIpPort());
    }
    // http://localhost:9001/fullName?firstName=azad&lastName=shaik
}
