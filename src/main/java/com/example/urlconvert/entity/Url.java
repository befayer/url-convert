package com.example.urlconvert.entity;

import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "url")
public class Url {
    @Id
    @Column(name = "long_url")
    private String longUrl;

    @Column(name = "convert_url")
    private String convertUrl;

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getConvertUrl() {
        return convertUrl;
    }

    public void setConvertUrl(String convertUrl) {
        this.convertUrl = convertUrl;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName())
                .append("(Long url: ")
                .append(longUrl)
                .append(", convert url: ")
                .append(convertUrl)
                .append(")");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Url url = (Url) o;
        return longUrl != null && Objects.equals(longUrl, url.longUrl);
    }

}
