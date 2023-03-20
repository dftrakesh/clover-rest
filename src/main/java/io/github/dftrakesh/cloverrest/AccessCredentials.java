package io.github.dftrakesh.cloverrest;

import lombok.Data;

@Data
public class AccessCredentials {

    private String accessToken;
    private String merchantId;
    private String region;
}