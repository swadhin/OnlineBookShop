package onlineBookShopApp;


/**
* onlineBookShopApp/_bookShopStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from bookShop.idl
* Friday, 10 December, 2010 10:12:22 AM IST
*/

public class _bookShopStub extends org.omg.CORBA.portable.ObjectImpl implements onlineBookShopApp.bookShop
{

  public onlineBookShopApp.book search_By_isbnNo (String isbn) throws onlineBookShopApp.Unknown
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("search_By_isbnNo", true);
                $out.write_string (isbn);
                $in = _invoke ($out);
                onlineBookShopApp.book $result = onlineBookShopApp.bookHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:onlineBookShopApp/Unknown:1.0"))
                    throw onlineBookShopApp.UnknownHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return search_By_isbnNo (isbn        );
            } finally {
                _releaseReply ($in);
            }
  } // search_By_isbnNo

  public onlineBookShopApp.book search_By_bookName (String bname) throws onlineBookShopApp.Unknown
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("search_By_bookName", true);
                $out.write_string (bname);
                $in = _invoke ($out);
                onlineBookShopApp.book $result = onlineBookShopApp.bookHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:onlineBookShopApp/Unknown:1.0"))
                    throw onlineBookShopApp.UnknownHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return search_By_bookName (bname        );
            } finally {
                _releaseReply ($in);
            }
  } // search_By_bookName

  public onlineBookShopApp.book search_By_authorName (String aname) throws onlineBookShopApp.Unknown
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("search_By_authorName", true);
                $out.write_string (aname);
                $in = _invoke ($out);
                onlineBookShopApp.book $result = onlineBookShopApp.bookHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:onlineBookShopApp/Unknown:1.0"))
                    throw onlineBookShopApp.UnknownHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return search_By_authorName (aname        );
            } finally {
                _releaseReply ($in);
            }
  } // search_By_authorName

  public int order_Books (onlineBookShopApp.invoiceReturn ivR) throws onlineBookShopApp.Unknown
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("order_Books", true);
                onlineBookShopApp.invoiceReturnHelper.write ($out, ivR);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:onlineBookShopApp/Unknown:1.0"))
                    throw onlineBookShopApp.UnknownHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return order_Books (ivR        );
            } finally {
                _releaseReply ($in);
            }
  } // order_Books

  public onlineBookShopApp.invoiceReturn get_and_show_Invoice () throws onlineBookShopApp.Unknown
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("get_and_show_Invoice", true);
                $in = _invoke ($out);
                onlineBookShopApp.invoiceReturn $result = onlineBookShopApp.invoiceReturnHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:onlineBookShopApp/Unknown:1.0"))
                    throw onlineBookShopApp.UnknownHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return get_and_show_Invoice (        );
            } finally {
                _releaseReply ($in);
            }
  } // get_and_show_Invoice

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:onlineBookShopApp/bookShop:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _bookShopStub
