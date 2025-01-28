package org.example.config.service.mpl;

import org.example.config.model.EncryptRequest;
import org.example.config.model.EncryptResponse;
import org.springframework.stereotype.Service;

@Service
public class EncryptServiceImpl implements EncryptService {

    @Override
    public EncryptResponse encrypt(EncryptRequest request) {
        
        if (request != null && request.getPlainText() != null && !request.getPlainText().isEmpty() &&
                request.getKey() != null && !request.getKey().isEmpty()) {

            // Lógica de cifrado (ejemplo simple)
            String encryptedText = simpleEncrypt(request.getPlainText(), request.getKey());

            // Devuelve la respuesta de éxito
            return new EncryptResponse(encryptedText, "Cifrado exitoso", 200);
        }


        return new EncryptResponse(null, "Error: Datos inválidos o faltantes", 400);
    }

    // Método auxiliar para cifrar (ejemplo simple de cifrado)
    private String simpleEncrypt(String plainText, String key) {

        return plainText + key;
    }
}

