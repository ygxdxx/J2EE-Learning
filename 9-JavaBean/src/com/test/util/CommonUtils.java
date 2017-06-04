package com.test.util;

import org.apache.commons.beanutils.BeanUtils;
import java.util.Map;
import java.util.UUID;

/**
 * Created by wangsongyan on 2017/6/4.
 * email: wangsongyan921@163.com
 */
public class CommonUtils {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    public static <T> T getBean(Map map, Class<T> c) {
        try {
            T bean = c.newInstance();
            BeanUtils.populate(bean, map);
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
