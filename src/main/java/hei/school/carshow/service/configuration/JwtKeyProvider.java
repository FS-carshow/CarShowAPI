package hei.school.carshow.service.configuration;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.KeyPair;

@Component
public class JwtKeyProvider {
    private KeyPair keyPair;

    @PostConstruct
    public void init() {
        keyPair = Keys.keyPairFor(SignatureAlgorithm.ES256);
    }

    public Key getPrivateKey() {
        return keyPair.getPrivate();
    }

    public Key getPublicKey() {
        return keyPair.getPublic();
    }
}
