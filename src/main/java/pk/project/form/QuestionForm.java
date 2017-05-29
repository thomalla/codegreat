package pk.project.form;

import org.hibernate.validator.constraints.NotEmpty;

public class QuestionForm
{
    @NotEmpty
    private String topic = "";

    @NotEmpty
    private String contents = "";

    public void setTopic(String topic)
    {
        this.topic = topic;
    }

    public String getTopic()
    {
        return topic;
    }

    public void setContents(String contents)
    {
        this.contents = contents;
    }

    public String getContents()
    {
        return contents;
    }
}
