package pk.project.util;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.SecureRandom;

@Component
public final class TokenGenerator
{
    private SecureRandom random = new SecureRandom();

    public String nextToken()
    {
        return new BigInteger(130, random).toString(32);
    }
}
