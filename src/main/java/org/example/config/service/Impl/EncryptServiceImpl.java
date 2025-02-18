package org.example.config.service.Impl;

import org.example.config.model.EncryptRequest;
import org.example.config.model.EncryptResponse;
import org.example.config.service.EncryptService;
import org.springframework.stereotype.Service;

@Service
public class EncryptServiceImpl implements EncryptService {

    @Override
    public EncryptResponse encrypt(EncryptRequest request) {
        
        if (request != null && request.getPlainText() != null && !request.getPlainText().isEmpty() &&
                request.getKey() != null && !request.getKey().isEmpty()) {


            String encryptedText = simpleEncrypt(request.getPlainText(), request.getKey());


            return new EncryptResponse(encryptedText, "Cifrado exitoso", 200);
        }


        return new EncryptResponse(null, "Error: Datos inválidos o faltantes", 400);
    }

    // Método auxiliar para cifrar (ejemplo simple de cifrado)
    private String simpleEncrypt(String plainText, String key) {

        return plainText + key;
    }
}

