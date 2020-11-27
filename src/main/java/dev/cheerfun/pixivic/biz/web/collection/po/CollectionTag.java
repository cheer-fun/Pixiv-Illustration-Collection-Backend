package dev.cheerfun.pixivic.biz.web.collection.po;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * @author OysterQAQ
 * @version 1.0
 * @date 2020/4/29 5:24 下午
 * @description CollectionTag
 */
@Data
public class CollectionTag {
    @JsonSetter("tag_id")
    @JsonAlias({"tagId", "tag_id"})
    private Integer id;
    @JsonSetter("tag_name")
    @JsonAlias({"tagName", "tag_name"})
    @Size(min = 2, max = 30)
    private String tagName;
}
