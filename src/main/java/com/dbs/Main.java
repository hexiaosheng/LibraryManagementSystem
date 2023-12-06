package com.dbs;

import com.dbs.business.Business;
import com.dbs.business.BusinessFactory;
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
            //String[] paras=str.split(" ");
            //String[] paras=str.split(" (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            String[] paras=str.trim().split(" (?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)",-1);
            if(paras!=null && paras.length>0){
                try{
                    Business business= BusinessFactory.getInstance(paras[0]);
                    business.BusinessParameters=paras;
                    business.Process();
                }catch (Exception ex)
                {
                    System.out.println("System exception,"+ex.toString());
                }
            }
        }
        //exit
        scan.close();
    }
}