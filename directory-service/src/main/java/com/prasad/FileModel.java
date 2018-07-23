package com.prasad;

import java.io.Serializable;

/**
 * FileModel
 * identitye2e
 * Description :
 */

public class FileModel implements Serializable {

    private static final long serialVersionUID = 4088845689607261014L;
    private String fileName;
    private String fileMimetype;
    private long fileSize;
    private String fileExtension;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileMimetype() {
        return fileMimetype;
    }

    public void setFileMimetype(String fileMimetype) {
        this.fileMimetype = fileMimetype;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FileModel{");
        sb.append("fileName='").append(fileName).append('\'');
        sb.append(", fileMimetype='").append(fileMimetype).append('\'');
        sb.append(", fileSize='").append(fileSize).append('\'');
        sb.append(", fileExtension='").append(fileExtension).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
