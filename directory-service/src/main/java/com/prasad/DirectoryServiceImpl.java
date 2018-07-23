package com.prasad;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * DirectoryService
 * identitye2e
 * Description :
 */

public class DirectoryServiceImpl implements DirectoryService {

    private static final MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
    private static Logger LOGGER = LoggerFactory.getLogger(DirectoryServiceImpl.class);

    /**
     *  This api will scan for files in a directory.
     * @param directoryName
     * @return
     */
    public List<FileModel> getAllFileDetails(String directoryName) {

        LOGGER.info("getAllFileDetails Start : About to scan " + directoryName);
        File path = new File(directoryName);
        List<FileModel> fileModels = new ArrayList<FileModel>();
        File[] files = path.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                FileModel fileModel = new FileModel();
                String mimeType = mimeTypesMap.getContentType(file);
                fileModel.setFileMimetype(mimeType);
                fileModel.setFileName(file.getAbsolutePath());
                String extension = FilenameUtils.getExtension(file.getAbsolutePath());
                fileModel.setFileExtension(extension);
                fileModel.setFileSize(file.length());
                fileModels.add(fileModel);
            }
        }
        LOGGER.info("getAllFileDetails End : scan completed " + directoryName);
        LOGGER.info("getAllFileDetails End : scan completed File List " + fileModels);
        return fileModels;
    }

    public List<FileModel> getFilesBySize(String directoryName, long fileSizeBytes, int numberOfFilesNeed) {
        LOGGER.info("getFilesBySize Start : "+ directoryName + " with size " + fileSizeBytes);
        List<FileModel> files = getAllFileDetails(directoryName);
        List<FileModel> filesFilter = new ArrayList<FileModel>();
        for (FileModel fileModel : files) {
            if (fileModel.getFileSize() == fileSizeBytes) {
                filesFilter.add(fileModel);
            }
            if (numberOfFilesNeed == filesFilter.size()) {
                break;
            }
        }
        LOGGER.info("getFilesBySize End : "+ directoryName);
        return filesFilter;
    }

    public List<FileModel> getFilesByMime(String directoryName, String mimeType) {
        LOGGER.info("getFilesBySize Start : "+ directoryName + " with mimeType " + mimeType);
        List<FileModel> files = getAllFileDetails(directoryName);
        List<FileModel> filesFilter = new ArrayList<FileModel>();
        for (FileModel fileModel : files) {
            if (fileModel.getFileMimetype().equals(mimeType)) {
                filesFilter.add(fileModel);
            }
        }
        LOGGER.info("getFilesBySize End : "+ directoryName + " with mimeType " + mimeType);
        return filesFilter;
    }
}
