package top.godder.datamodule.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "file_comment")
public class FileComment {
    @Id
    @Column(name = "file_comment_id")
    private Long fileCommentId;

    /**
     * 评论文件
     */
    @Column(name = "file_id")
    private Long fileId;

    /**
     * 评论人
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 评论时间
     */
    @Column(name = "comment_date")
    private Date commentDate;

    /**
     * 评论内容
     */
    @Column(name = "comment")
    private String comment;

    /**
     * 评论分数（5-1分）
     */
    @Column(name = "comment_level")
    private Integer commentLevel;

    public FileComment(Long fileId, Long userId, Date commentDate, String comment, Integer commentLevel) {
        this.fileId = fileId;
        this.userId = userId;
        this.commentDate = commentDate;
        this.comment = comment;
        this.commentLevel = commentLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileComment that = (FileComment) o;
        return Objects.equals(fileCommentId, that.fileCommentId) &&
                Objects.equals(fileId, that.fileId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileCommentId, fileId, userId);
    }
}