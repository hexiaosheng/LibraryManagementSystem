package com.dbs.business;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jason He
 * @date 2023/12/5 20:11
 */
public class BusinessFactory {
    public static Business getInstance(String arg) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String className=CmdAliasingClassName().get(arg);
        Class<?> cls  = Class.forName(className);
        Business business = (Business)cls.newInstance();
        return business;
    }

    public static HashMap<String,String> CmdAliasingClassName(){
        HashMap map=new HashMap<String,String>();
        map.put("login","com.dbs.business.Login");
        map.put("register","com.dbs.business.Register");

        return map;
    }
}
