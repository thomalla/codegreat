package pk.project.service;

import org.springframework.stereotype.Service;

@Service
public class TestService
{
    public boolean[] checkCorectness(char[] correctAnswers, char[] userAnswers)
    {
        boolean correctness[]=new boolean[correctAnswers.length];
        for(int i=0;i<correctAnswers.length;i++)
        {
            if(correctAnswers[i]==userAnswers[i])
            {
                correctness[i]=true;
            }
            else correctness[i]=false;
        }
        return correctness;
    }

    public Integer countScore(char[] correctAnswers, char[] userAnswers)
    {
        Integer score=0;
        for(int i=0;i<correctAnswers.length;i++)
        {
            if(correctAnswers[i]==userAnswers[i])
            {
                score++;
            }
        }
        return score;
    }
}
