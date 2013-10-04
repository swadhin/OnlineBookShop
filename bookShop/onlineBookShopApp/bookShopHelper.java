package onlineBookShopApp;


/**
* onlineBookShopApp/bookShopHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from bookShop.idl
* Friday, 10 December, 2010 10:12:22 AM IST
*/

abstract public class bookShopHelper
{
  private static String  _id = "IDL:onlineBookShopApp/bookShop:1.0";

  public static void insert (org.omg.CORBA.Any a, onlineBookShopApp.bookShop that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static onlineBookShopApp.bookShop extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (onlineBookShopApp.bookShopHelper.id (), "bookShop");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static onlineBookShopApp.bookShop read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_bookShopStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, onlineBookShopApp.bookShop value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static onlineBookShopApp.bookShop narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof onlineBookShopApp.bookShop)
      return (onlineBookShopApp.bookShop)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      onlineBookShopApp._bookShopStub stub = new onlineBookShopApp._bookShopStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static onlineBookShopApp.bookShop unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof onlineBookShopApp.bookShop)
      return (onlineBookShopApp.bookShop)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      onlineBookShopApp._bookShopStub stub = new onlineBookShopApp._bookShopStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
