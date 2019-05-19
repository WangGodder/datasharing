package top.godder.datamoduleapi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 文件下载记录
 */
public class FileDownload {
    private Long downloadId;

    /**
     * 下载文件
     */
    private Long fileId;

    /**
     * 下载用户
     */
    private Long downloadUser;

    /**
     * 下载时间
     */
    private Date downloadTime;

    /**
     * @return file_id
     */
    public Long getFileId() {
        return fileId;
    }

    /**
     * @param fileId
     */
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    /**
     * 获取下载用户
     *
     * @return download_user - 下载用户
     */
    public Long getDownloadUser() {
        return downloadUser;
    }

    /**
     * 设置下载用户
     *
     * @param downloadUser 下载用户
     */
    public void setDownloadUser(Long downloadUser) {
        this.downloadUser = downloadUser;
    }

    /**
     * 获取下载时间
     *
     * @return download_time - 下载时间
     */
    public Date getDownloadTime() {
        return downloadTime;
    }

    /**
     * 设置下载时间
     *
     * @param downloadTime 下载时间
     */
    public void setDownloadTime(Date downloadTime) {
        this.downloadTime = downloadTime;
    }
}