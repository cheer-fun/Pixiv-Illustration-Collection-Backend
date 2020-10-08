package dev.cheerfun.pixivic.biz.notify.mapper;

import dev.cheerfun.pixivic.biz.notify.po.NotifyBanSetting;
import dev.cheerfun.pixivic.biz.notify.po.NotifyRemind;
import dev.cheerfun.pixivic.biz.notify.po.NotifySettingConfig;
import dev.cheerfun.pixivic.biz.web.comment.po.Comment;
import dev.cheerfun.pixivic.common.util.json.JsonTypeHandler;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NotifyMapper {

    @Insert("insert into notify_remind (remind_type,actors,object_id,object_type,object_title,recipient_id,message,create_date) value (#{type},#{actors,typeHandler=dev.cheerfun.pixivic.common.util.json.JsonTypeHandler},#{objectId},#{objectType},#{objectTitle},#{recipientId},#{message},#{createDate})")
    Integer insertNotifyRemind(NotifyRemind notifyRemind);

    @Select("select * from notify_ban_setting where user_id = #{userId}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "banNotifyActionType", column = "ban_notify_action_type", javaType = List.class, typeHandler = JsonTypeHandler.class),
            @Result(property = "isBanEmail", column = "is_ban_email")
    })
    NotifyBanSetting queryUserBanSetting(Integer userId);

    @Select("select * from notify_setting_config")
    @Results({
            @Result(property = "id", column = "notify_setting_config_id"),
            @Result(property = "objectType", column = "object_type"),
            @Result(property = "action", column = "notify_action"),
            @Result(property = "objectRelationship", column = "object_relationship"),
            @Result(property = "messageTemplate", column = "message_template"),
            @Result(property = "notifyChannel", column = "notify_channel", javaType = List.class, typeHandler = JsonTypeHandler.class),
            @Result(property = "description", column = "setting_description"),
            @Result(property = "settingType", column = "setting_type")
    })
    List<NotifySettingConfig> queryNotifySettingConfig();


}
