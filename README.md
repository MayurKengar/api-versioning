# ApiVersioning

Small Spring Boot demo showing a simple API versioning example.

Overview
- Java: 21
- Spring Boot: 4.0.0 (maven parent)
- Purpose: demonstrate a tiny API exposing multiple versioned responses from a single controller.

Project layout (important files)
- src/main/java/com/example/api/ApiVersioningApplication.java  — Spring Boot application entry point
- src/main/java/com/example/api/api/VersionController.java    — Controller that returns versioned responses
- src/main/java/com/example/api/response/ApiResponse.java     — Simple response DTO
- src/main/resources/application.yaml                         — Configuration (server port, endpoint name, versioning config)

Build
This project uses Maven. A wrapper (`mvnw` / `mvnw.cmd`) is included so you don't need Maven installed globally.


By default the server starts on port 8080 (see `application.yaml`).

Endpoint
The base path is configured in `application.yaml` under `endpoint.name`.
By default it is `api-version`, so the base URL is:

    http://localhost:8080/api-version

The controller returns a JSON object with the following shape (ApiResponse):

    {
      "message": "Hello from Version - V1",
      "success": true
    }

Versioning configuration
The project includes a simple configuration section in `application.yaml` suggesting header-based API versioning:

    mvc:
      apiversion:
        default: 1.0
        use:
          header: api-version

This means the example client can request a specific version by setting the `api-version` HTTP header. The controller in this demo exposes handlers intended for multiple versions.

Examples
Using curl (Windows PowerShell compatible):

- Request version v1 using the `api-version` header:

    curl -i -H "api-version: v1" http://localhost:8080/api-version

- Request version v2:

    curl -i -H "api-version: v2" http://localhost:8080/api-version

If you prefer query-parameter based versioning, you can adapt the controller and configuration to read a `version` query parameter (the provided `application.yaml` indicates this is an alternative option).

Notes & Troubleshooting
- The demo controller uses simple version-specific handler methods. Depending on how you implement version resolution you may need to change request mappings from the placeholder `version` attribute to a standard approach (for example, using a filter/interceptor that dispatches to different controllers, or using different paths such as `/v1/` prefixes).
- If the app fails to start, check the logs at DEBUG level for `org.springframework.web` (configured in `application.yaml`).
- To run tests:

    .\mvnw.cmd test

Next steps / Improvements
- Implement a concrete API versioning strategy: header-based resolver, URL path versioning, or content negotiation.
- Add unit/integration tests that assert behavior for each supported API version.
- Add OpenAPI/Swagger documentation.
