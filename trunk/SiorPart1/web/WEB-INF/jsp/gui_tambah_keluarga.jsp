<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Menambah Informasi Keluarga</title>
<style type="text/css">
#apDiv2 {
	position:absolute;
	left:724px;
	top:70px;
	width:237px;
	height:182px;
	z-index:1;
	text-align: center;
}
</style>
</head>

<body>
<p></p>
<img src="http://i1010.photobucket.com/albums/af230/ntonk59/Untitled-1.png" width="707" height="216" />
<div id="apDiv2">
  <table width="236" height="184" border="1">
    <tr>
      <td width="114" height="56">01-Dec-2011 5:02 PM</td>
      <td width="106" rowspan="3"> Foto User </td>
    </tr>
    <tr>
      <td height="68"><p>Selamat Datang <a href="#">User</a> !</p></td>
    </tr>
    <tr>
      <td height="50"><input type="submit" name="So2" id="So2" value="Keluar" /></td>
    </tr>
  </table>
</div>
<form action="tambahkeluarga" method="post" name="tambahkeluarga" id="tambahkeluarga">
  <p>SiOR</p>
  <p>&nbsp;</p>
  <p>Isilah form di bawah ini :</p>
  <table width="693" border="0">
    <tr>
      <td width="172">Kepala Keluarga </td>
      <td width="7">:</td>
      <td width="144"><input type="text" name="kepalakeluarga" /></td>
      <td width="98">Anggota Keluarga </td>
      <td width="6">:</td>
      <td width="226"><input type="text" name="txt_anggotakeluarga" /></td>
    </tr>
  </table>
  <p>&nbsp;</p>
  <table width="694" border="0">
    <tr>
      <td width="688"><div align="right">
          <input name="Submit" type="submit" id="Submit" value="Simpan" />
          <input name="Batal" type="button" id="Batal" value="Batal" />
      </div></td>
    </tr>
  </table>
</form>
</body>
</html>
