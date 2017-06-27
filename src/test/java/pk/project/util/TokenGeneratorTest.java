package pk.project.util;

import org.junit.Assert;
import org.junit.Test;

public class TokenGeneratorTest
{
    TokenGenerator tokenGenerator = new TokenGenerator();

    @Test
    public void nextTokenTest()
    {
        Assert.assertFalse(tokenGenerator.nextToken().isEmpty());
    }
}