package top.whattowatch.wtw.po;

import java.io.Serializable;

public class Types implements Serializable {
    private Integer typesId;

    private String typesName;

    public Types(String realType) {
        typesName=realType;
    }

    public Types(Integer typesId, String typesName) {
        this.typesId = typesId;
        this.typesName = typesName;
    }

    public Types() {
    }

    public Integer getTypesId() {
        return typesId;
    }

    public void setTypesId(Integer typesId) {
        this.typesId = typesId;
    }

    public String getTypesName() {
        return typesName;
    }

    public void setTypesName(String typesName) {
        this.typesName = typesName == null ? null : typesName.trim();
    }
}