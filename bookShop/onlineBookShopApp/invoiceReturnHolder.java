package onlineBookShopApp;

/**
* onlineBookShopApp/invoiceReturnHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from bookShop.idl
* Friday, 10 December, 2010 10:12:22 AM IST
*/

public final class invoiceReturnHolder implements org.omg.CORBA.portable.Streamable
{
  public onlineBookShopApp.invoiceReturn value = null;

  public invoiceReturnHolder ()
  {
  }

  public invoiceReturnHolder (onlineBookShopApp.invoiceReturn initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = onlineBookShopApp.invoiceReturnHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    onlineBookShopApp.invoiceReturnHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return onlineBookShopApp.invoiceReturnHelper.type ();
  }

}
