package com.dbs.command;

import java.util.HashMap;

/**
 * @author Jason He
 * @date 2023/12/5 20:11
 */
public class CommandFactory {
    public static Command getInstance(String arg) throws Exception {
        String className = CmdAliasingClassName().get(arg);
        Class<?> cls = Class.forName(className);
        Command cmd = (Command) cls.newInstance();
        return cmd;
    }

    public static HashMap<String,String> CmdAliasingClassName(){
        HashMap map=new HashMap<String,String>();
        map.put("login","com.dbs.command.CmdUserLogin");
        map.put("register","com.dbs.command.CmdUserRegister");
        map.put("add","com.dbs.command.CmdBookAdd");
        map.put("list","com.dbs.command.CmdBookList");
        map.put("search","com.dbs.command.CmdBookSearch");
        map.put("borrow","com.dbs.command.CmdBookBorrow");
        map.put("delete","com.dbs.command.CmdBookDelete");
        map.put("return","com.dbs.command.CmdBookReturn");

        return map;
    }
}
