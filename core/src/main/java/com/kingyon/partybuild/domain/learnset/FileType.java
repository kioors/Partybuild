package com.kingyon.partybuild.domain.learnset;

/**
 * @author toby
 * @create 2017-09-13 上午9:50
 **/
public enum FileType {
    TXT(1, "txt"),
    WORD(2, "word"),
    PDF(3, "pdf");

    private String name;
    private Integer type;

    FileType(Integer type, String name) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public static FileType getFileType(int type) {
        for (FileType fileType : FileType.values()) {
            if (type == fileType.getType()) {
                return fileType;
            }
        }
        return null;
    }
}
