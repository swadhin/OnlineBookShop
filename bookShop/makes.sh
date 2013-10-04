#!/bin/bash
idlj -fall bookShop.idl
javac bookShopImpl.java onlineBookShopApp/*.java
javac bookShopServer.java onlineBookShopApp/*.java
javac bookShopClient.java onlineBookShopApp/*.java
