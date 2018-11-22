package com.bes.corba.test;

/**
* com/bes/corba/test/CalcHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Hello.idl
* 2018��10��26�� ������ ����03ʱ30��11�� CST
*/

public final class CalcHolder implements org.omg.CORBA.portable.Streamable
{
  public com.bes.corba.test.Calc value = null;

  public CalcHolder ()
  {
  }

  public CalcHolder (com.bes.corba.test.Calc initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = com.bes.corba.test.CalcHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    com.bes.corba.test.CalcHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return com.bes.corba.test.CalcHelper.type ();
  }

}
