package onlineBookShopApp;


/**
* onlineBookShopApp/StringSeqHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from bookShop.idl
* Thursday, 9 December, 2010 3:34:12 PM IST
*/


//typedef sequence<book> books;
public final class StringSeqHolder implements org.omg.CORBA.portable.Streamable
{
  public String value[] = null;

  public StringSeqHolder ()
  {
  }

  public StringSeqHolder (String[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = onlineBookShopApp.StringSeqHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    onlineBookShopApp.StringSeqHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return onlineBookShopApp.StringSeqHelper.type ();
  }

}
