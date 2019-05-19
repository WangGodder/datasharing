package top.godder.datamoduleapi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
/**
 * 数据文件评价
 */
public class FileComment {
    private Long fileCommentId;

    /**
     * 评论文件
     */
    private Long fileId;

    /**
     * 评论人
     */
    private Long userId;

    /**
     * 评论时间
     */
    private Date commentDate;

    /**
     * 评论内容
     */
    private String comment;

    /**
     * 评论分数（5-1分）
     */
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