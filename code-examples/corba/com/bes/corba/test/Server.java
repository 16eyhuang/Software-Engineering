package com.bes.corba.test;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import com.bes.corba.test.Calc;
import com.bes.corba.test.CalcHelper;
import com.bes.corba.impl.CalculatorImpl;

public class Server {
    public static void main(String[] args) throws Exception{
        /*
         * ORB ��ʼ����
         */
        ORB orb=ORB.init(args,null);
        
        /*
         * ��ȡ��POA����ʼ����
         */
        POA rootPoa=POAHelper.narrow(orb.resolve_initial_references("RootPOA") );
        rootPoa.the_POAManager().activate();
        
        /*
         * ����һ��CalculatorImpl��
         */
        CalculatorImpl calculatorImpl=new CalculatorImpl();
        
        /*
         * ��Servantע�ᵽRootPOA�У�����Servant��Object Reference���໥ӳ�䣬
         * ע�����������Ϊ��RootPOA��POA Policy�йء�
         */
        org.omg.CORBA.Object ref=rootPoa.servant_to_reference(calculatorImpl);
        Calc iref=CalcHelper.narrow(ref);
        
        /*
         * ��ȡ��������
         */
        org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
        NamingContextExt ncRef= NamingContextExtHelper.narrow(objRef);
        
        /*
         * ��������������Ӧ�����ַ��������������С�
         */
        String name="Calc";
        NameComponent path[] = ncRef.to_name(name);
        ncRef.rebind(path,iref);
        
        System.out.println("Calculator server ready...");
        
        /*
         * ����ֱ��ORB�رա�
         */
        orb.run();
    }
}