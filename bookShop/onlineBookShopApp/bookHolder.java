package onlineBookShopApp;

/**
* onlineBookShopApp/bookHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from bookShop.idl
* Friday, 10 December, 2010 10:12:22 AM IST
*/

public final class bookHolder implements org.omg.CORBA.portable.Streamable
{
  public onlineBookShopApp.book value = null;

  public bookHolder ()
  {
  }

  public bookHolder (onlineBookShopApp.book initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = onlineBookShopApp.bookHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    onlineBookShopApp.bookHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return onlineBookShopApp.bookHelper.type ();
  }

}
