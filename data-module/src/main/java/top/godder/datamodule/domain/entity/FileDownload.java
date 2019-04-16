package top.godder.datamodule.domain.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "file_download")
public class FileDownload {
    @Id
    @Column(name = "file_id")
    private Long fileId;

    /**
     * 下载用户
     */
    @Column(name = "download_user")
    private Long downloadUser;

    /**
     * 下载时间
     */
    @Column(name = "download_time")
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