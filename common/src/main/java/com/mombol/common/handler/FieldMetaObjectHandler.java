package com.mombol.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.mombol.common.util.TimeUtil;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

public class FieldMetaObjectHandler implements MetaObjectHandler {

    private static final String CREATED_AT = "createdAt";
    private static final String UPDATED_AT = "updatedAt";

    @Override
    public void insertFill(MetaObject metaObject) {
        long secondTimestamp = getSecondTimestamp();
        this.setFieldValByName(CREATED_AT, secondTimestamp, metaObject);
        this.setFieldValByName(UPDATED_AT, secondTimestamp, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName(UPDATED_AT, getSecondTimestamp(), metaObject);
        strictUpdateFill(metaObject, UPDATED_AT, long.class, getSecondTimestamp());
    }

    private long getSecondTimestamp() {
        Date date = new Date();

        return TimeUtil.getSecondTimestamp(date);
    }

}
