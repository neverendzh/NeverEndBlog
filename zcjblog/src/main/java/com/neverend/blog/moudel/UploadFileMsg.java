package com.neverend.blog.moudel;

/*
       使用ckeditor
       成功上载文件后，需要具有以下条目的JSON响应：
        uploaded- 设置为1。
        fileName - 上传文件的名称。
        url - 上传文件的URL（URL编码）。
          "error": {
        "message": "A file with the same name already exists. The uploaded file was renamed to \"foo(2).jpg\"."
    }
*/
public class UploadFileMsg {

    private String uploaded;

    private String fileName;

    private String url;

    private ErrorMsg error;

    public ErrorMsg getError() {
        return error;
    }

    public void setError(ErrorMsg error) {
        this.error = error;
    }

    public String getUploaded() {
        return uploaded;
    }

    public void setUploaded(String uploaded) {
        this.uploaded = uploaded;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UploadFileMsg{" +
                "uploaded='" + uploaded + '\'' +
                ", fileName='" + fileName + '\'' +
                ", url='" + url + '\'' +
                ", error=" + error +
                '}';
    }
}
