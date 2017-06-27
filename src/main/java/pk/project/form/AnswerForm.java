package pk.project.form;

import org.hibernate.validator.constraints.NotEmpty;

public class AnswerForm
{
    @NotEmpty
    private String contents = "";

    private Long questionId;

    public void setContents(String contents)
    {
        this.contents = contents;
    }

    public String getContents()
    {
        return contents;
    }

    public void setQuestionId(Long questionId)
    {
        this.questionId = questionId;
    }

    public Long getQuestionId()
    {
        return questionId;
    }
}
