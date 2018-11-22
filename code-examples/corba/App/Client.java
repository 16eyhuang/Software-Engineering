package com.bes.corba.test;

import org.omg.CORBA.IntHolder;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import com.bes.corba.test.Calc;
import com.bes.corba.test.CalcHelper;

public class Client {
    public static void main(String[] args) throws Exception{
        /*
         * ORB ��ʼ����
         */
        ORB orb=ORB.init(args,null);
        
        /*
         * ��ȡ��������
         */
        org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
        NamingContextExt ncRef=NamingContextExtHelper.narrow(objRef);
        
        /*
         * �����������в�����Ӧ�Ķ������ã�����������ת�͡�
         */
        
        String name="Calc";
        Calc calc=CalcHelper.narrow(ncRef.resolve_str(name));
        
        /*
         * ���ö���ķ�����
         */
        IntHolder result=new IntHolder();
        
        calc.add(1,2,result);
        System.out.printf("1+2=%d\n",result.value);
    }
}