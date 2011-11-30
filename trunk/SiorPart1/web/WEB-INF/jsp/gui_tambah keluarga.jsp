<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Menambah Informasi Keluarga</title>
</head>

<body>
<form action="" method="post" enctype="multipart/form-data" name="form1" id="form1">
  <p>SiOR</p>
  <p>&nbsp;</p>
  <p>Isilah form di bawah ini :</p>
  <table width="693" border="0">
    <tr>
      <td width="172">Kode Keluarga </td>
      <td width="7">:</td>
      <td width="144"><input type="text" name="txt_kodekeluarga" /></td>
      <td width="98">Anggota Keluarga </td>
      <td width="6">:</td>
      <td width="226"><input type="file" name="txt_anggotakeluarga" /></td>
    </tr>
  </table>
  <table width="344" border="0">
    <tr>
      <td width="172">ID KTP Kepala Keluarga </td>
      <td width="8">:</td>
      <td width="142">&nbsp;</td>
    </tr>
    <tr>
      <td>Jumlah Anggota Keluarga </td>
      <td>:</td>
      <td>&nbsp;</td>
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
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp; </p>
</form>
</body>
</html>
