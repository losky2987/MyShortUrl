package losky2987.myshorturl.db;

import java.util.*;

public class LinkConvertColumn{
    private String remark;
    private String shortName;
    private String originalLink;

    public LinkConvertColumn(String remark, String shortName, String originalLink) {
        this.remark = remark;
        this.shortName = shortName;
        this.originalLink = originalLink;
    }

    public String remark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String shortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String originalLink() {
        return originalLink;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkConvertColumn that = (LinkConvertColumn) o;
        return Objects.equals(remark, that.remark) && Objects.equals(shortName, that.shortName) && Objects.equals(originalLink, that.originalLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(remark, shortName, originalLink);
    }

    @Override
    public String toString() {
        return "LinkConvertColumn{" +
                "remark='" + remark + '\'' +
                ", shortName='" + shortName + '\'' +
                ", originalLink='" + originalLink + '\'' +
                '}';
    }

    public boolean findRemark(String remark) {
        return Objects.equals(this.remark, remark);
    }

    public boolean findShortName(String shortName) {
        return Objects.equals(this.shortName, shortName);
    }

    public boolean findOriginalLink(String originalLink) {
        return Objects.equals(this.originalLink, originalLink);
    }

    public Map<String, String> getOtherFromRemark(String remark) {
        Map<String, String> map = new HashMap<>();
        if(findRemark(remark)) {
            map.put("remark", remark);
            map.put("shortName", shortName);
            map.put("originalLink", originalLink);
        }
        return map;
    }

    public Map<String, String> getOtherFromShortName(String shortName) {
        Map<String, String> map = new HashMap<>();
        if(findShortName(shortName)) {
            map.put("shortName", shortName);
            map.put("originalLink", originalLink);
            map.put("remark", remark);
        }
        return map;
    }

    public Map<String, String> getOtherFromOriginalLink(String originalLink) {
        Map<String, String> map = new HashMap<>();
        if(findOriginalLink(originalLink)) {
            map.put("originalLink", originalLink);
            map.put("remark", remark);
            map.put("shortName", shortName);
        }
        return map;
    }
}
