package com.example.api.api;


import com.example.api.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/${endpoint.name}")
public class VersionController {

    private static final String API_VERSION_NAME = "Hello from Version - %s";

    @GetMapping(version = "v1")
    public ResponseEntity<ApiResponse> getVersionV1Response() {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .message(String.format(API_VERSION_NAME, "V1"))
                        .success(true)
                        .build()
        );
    }

    @GetMapping(version = "v2")
    public ResponseEntity<ApiResponse> getVersionV2Response() {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .message(String.format(API_VERSION_NAME, "V2"))
                        .success(true)
                        .build()
        );
    }

    @GetMapping(version = "v3")
    public ResponseEntity<ApiResponse> getVersionV3Response() {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .message(String.format(API_VERSION_NAME, "V3"))
                        .success(true)
                        .build()
        );
    }
}
