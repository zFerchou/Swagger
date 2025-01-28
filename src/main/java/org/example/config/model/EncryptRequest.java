// EncryptRequest.java
package org.example.config.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EncryptRequest {
    private String plainText;
    private String key;
}
