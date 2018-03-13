package com.xiao.bean;

/**
 * 〈文件实体〉<br>
 *
 * @author jianjun.xiao
 * @create 2018/3/3 12:14
 * @since 1.0.0
 */
public class LocalFile {
    private String filepath;

    public LocalFile(String filepath) {
        this.filepath = filepath;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
