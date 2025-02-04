package org.example.config.service;

import org.example.config.model.EncryptRequest;
import org.example.config.model.EncryptResponse;

public interface EncryptService {
    EncryptResponse encrypt(EncryptRequest request);
}
