package com.prasad;

import java.util.List;


public interface DirectoryService {

    List<FileModel> getAllFileDetails(String directoryName);

    List<FileModel> getFilesBySize(String directoryName,long fileSizeBytes , int numberOfFilesNeed);

    List<FileModel> getFilesByMime(String directoryName,String mimeType);

}
