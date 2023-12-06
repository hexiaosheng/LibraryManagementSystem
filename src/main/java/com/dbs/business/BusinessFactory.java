package com.dbs.business;

import java.util.HashMap;

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
        map.put("login","com.dbs.business.UserLogin");
        map.put("register","com.dbs.business.UserRegister");
        map.put("add","com.dbs.business.BookAdd");
        map.put("list","com.dbs.business.BookList");
        map.put("search","com.dbs.business.BookSearch");
        map.put("borrow","com.dbs.business.BookBorrow");
        map.put("delete","com.dbs.business.BookDelete");
        map.put("return","com.dbs.business.BookReturn");

        return map;
    }
}
