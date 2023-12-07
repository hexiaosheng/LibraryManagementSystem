package com.dbs.command;

/**
 * @author Jason He
 * @date 2023/12/5 19:31
 */
public abstract class Command {
    public String[] Parameters;

    public abstract void Process();
}
