package onlineBookShopApp;

/**
* onlineBookShopApp/UnknownHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from bookShop.idl
* Friday, 10 December, 2010 10:12:22 AM IST
*/

public final class UnknownHolder implements org.omg.CORBA.portable.Streamable
{
  public onlineBookShopApp.Unknown value = null;

  public UnknownHolder ()
  {
  }

  public UnknownHolder (onlineBookShopApp.Unknown initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = onlineBookShopApp.UnknownHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    onlineBookShopApp.UnknownHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return onlineBookShopApp.UnknownHelper.type ();
  }

}