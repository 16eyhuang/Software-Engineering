package com.bes.corba.test;


/**
* com/bes/corba/test/CalcOperations.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Hello.idl
* 2018��10��26�� ������ ����03ʱ30��11�� CST
*/

public interface CalcOperations 
{
  void add (int a, int b, org.omg.CORBA.IntHolder c);
  void sub (int a, int b, org.omg.CORBA.IntHolder c);
  void multi (int a, int b, org.omg.CORBA.IntHolder c);
  void div (int a, int b, org.omg.CORBA.IntHolder c);
} // interface CalcOperations
