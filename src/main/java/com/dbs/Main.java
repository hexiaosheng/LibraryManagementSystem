package com.dbs;

import com.dbs.command.Command;
import com.dbs.command.CommandFactory;
import com.dbs.entity.Library;
import java.util.Scanner;

/**
 * @author Jason He
 * @date 2023/12/5 16:04
 */
public class Main {
    public static void main(String[] args) {
        //initial the library
        Library library=new Library();

        //get command-line input
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            String[] paras=str.trim().split(" (?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)",-1);
            if(paras!=null && paras.length>0){
                try{
                    Command cmd= CommandFactory.getInstance(paras[0]);
                    cmd.Parameters=paras;
                    cmd.Process();
                }catch (Exception ex)
                {
                    System.out.println("Invalid command,which system can't support");
                }
            }
        }
        //exit
        scan.close();
    }
}