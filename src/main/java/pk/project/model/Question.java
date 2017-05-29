package pk.project.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="question")
public class Question
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable=false, updatable = false)
    private Long id;

    @Column(name="userId", nullable=false, updatable = false)
    private Long userId;

    @Column(name="topic", nullable = false)
    private String topic;

    @Column(name="contents", nullable = false)
    private String contents;
//
//    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//    private ArrayList<Integer> tags;

    @Column(name="points")
    private Long points;

    @Column(name="isResolved")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isResolved;

    public Long getId()
    {
        return id;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public String getTopic()
    {
        return topic;
    }

    public void setTopic(String topic)
    {
        this.topic = topic;
    }

    public String getContents()
    {
        return contents;
    }

    public void setContents(String contents)
    {
        this.contents = contents;
    }

    public Long getPoints()
    {
        return points;
    }

    public void setPoints(Long points)
    {
        this.points = points;
    }

    public boolean isResolved()
    {
        return isResolved;
    }

    public void setResolved(boolean resolved)
    {
        isResolved = resolved;
    }
}





