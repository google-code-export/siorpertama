<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Menambah Informasi Rumah</title>
</head>

<body>
<form id="form1" name="form1" method="post" action="">
  <p>SiOR</p>
  <table width="401" border="0">
    <tr>
      <td width="123">Kode Rumah </td>
      <td width="10">:</td>
      <td width="711"><input name="txt_koderumah" type="text" size="30" /></td>
    </tr>
  </table>
  <p>Lengkapi data berikut : </p>
  <table width="507" border="0">
    <tr>
      <td width="120">Alamat rumah </td>
      <td width="7">:</td>
      <td width="358"><textarea name="txt_alamatrumah" cols="50" rows="4"></textarea></td>
    </tr>
    <tr>
      <td>Kelurahan Rumah</td>
      <td>:</td>
      <td><input name="txt_kelurahanrumah" type="text" size="8" /></td>
    </tr>
    <tr>
      <td>Kecamatan Rumah</td>
      <td>:</td>
      <td><input name="txt_kecamatanrumah" type="text" size="8" /></td>
    </tr>
    <tr>
      <td>Kota Rumah </td>
      <td>:</td>
      <td><input name="txt_kotarumah" type="text" size="30" /></td>
    </tr>
  </table>
  <p>&nbsp;</p>
  <div align="center">
    <input type="submit" name="Submit2" value="Simpan" />
    <input type="button" name="Button" value="  Batal  " />
  </div>
  <p>&nbsp;</p>
  <p>&nbsp;  </p>
</form>
</body>
</html>
