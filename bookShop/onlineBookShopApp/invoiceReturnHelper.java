package onlineBookShopApp;


/**
* onlineBookShopApp/invoiceReturnHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from bookShop.idl
* Friday, 10 December, 2010 10:12:22 AM IST
*/

abstract public class invoiceReturnHelper
{
  private static String  _id = "IDL:onlineBookShopApp/invoiceReturn:1.0";

  public static void insert (org.omg.CORBA.Any a, onlineBookShopApp.invoiceReturn that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static onlineBookShopApp.invoiceReturn extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [8];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "isbnNo",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "bookName",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "authorName",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "publisherName",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_float);
          _members0[4] = new org.omg.CORBA.StructMember (
            "bookPrice",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[5] = new org.omg.CORBA.StructMember (
            "qtRequired",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_float);
          _members0[6] = new org.omg.CORBA.StructMember (
            "totalPrice",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[7] = new org.omg.CORBA.StructMember (
            "address",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (onlineBookShopApp.invoiceReturnHelper.id (), "invoiceReturn", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static onlineBookShopApp.invoiceReturn read (org.omg.CORBA.portable.InputStream istream)
  {
    onlineBookShopApp.invoiceReturn value = new onlineBookShopApp.invoiceReturn ();
    value.isbnNo = istream.read_string ();
    value.bookName = istream.read_string ();
    value.authorName = istream.read_string ();
    value.publisherName = istream.read_string ();
    value.bookPrice = istream.read_float ();
    value.qtRequired = istream.read_long ();
    value.totalPrice = istream.read_float ();
    value.address = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, onlineBookShopApp.invoiceReturn value)
  {
    ostream.write_string (value.isbnNo);
    ostream.write_string (value.bookName);
    ostream.write_string (value.authorName);
    ostream.write_string (value.publisherName);
    ostream.write_float (value.bookPrice);
    ostream.write_long (value.qtRequired);
    ostream.write_float (value.totalPrice);
    ostream.write_string (value.address);
  }

}
