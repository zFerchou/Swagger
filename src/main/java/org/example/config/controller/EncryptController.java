package org.example.config.controller;

import org.example.config.model.EncryptRequest;
import org.example.config.model.EncryptResponse;
import org.example.config.service.mpl.EncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/API/v1/ENCRYPT/encryptServicio")
public class EncryptController {

    private final EncryptService encryptService;

    @Autowired
    public EncryptController(EncryptService encryptService) {
        this.encryptService = encryptService;
    }

    @PostMapping(value = "/encrypt")
    public ResponseEntity<EncryptResponse> encryptaCadenaOriginal(@Valid @RequestBody EncryptRequest encryptRequest) {
        if (encryptRequest == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        EncryptResponse encryptResponse = encryptService.encrypt(encryptRequest);

        if (encryptResponse != null) {
            return new ResponseEntity<>(encryptResponse, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }
}
