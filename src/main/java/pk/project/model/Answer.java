package pk.project.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="answer")
public class Answer
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable=false, updatable = false)
    private Long id;

    @Column(name="userId", nullable=false, updatable = false)
    private Long userId;

    @Column(name="questionId", nullable=false, updatable = false)
    private Long questionId;

    @Column(name="username", nullable=false, updatable = false)
    private String username;

    @Column(name="contents", nullable = false, length = 10000)
    private String contents;

    @Column(name="date")
    @Type(type = "date")
    private Date date;

    @Column(name="points")
    private Long points;

    @Column(name="isAnswer")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isAnswer;


    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(Long questionId)
    {
        this.questionId = questionId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getContents()
    {
        return contents;
    }

    public void setContents(String contents)
    {
        this.contents = contents;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Long getPoints()
    {
        return points;
    }

    public void setPoints(Long points)
    {
        this.points = points;
    }

    public boolean isAnswer()
    {
        return isAnswer;
    }

    public void setAnswer(boolean answer)
    {
        isAnswer = answer;
    }
}





