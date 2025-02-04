package org.example.config.model;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EncryptResponse {
    private String encryptedText;
    private String message;
    private int statusCode;
}

