<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Menambah Informasi Rumah</title>
<style type="text/css">
#apDiv1 {
	position:absolute;
	left:714px;
	top:74px;
	width:237px;
	height:182px;
	z-index:1;
}
</style>
</head>

<body>
<p></p>
<img src="http://i1010.photobucket.com/albums/af230/ntonk59/Untitled-1.png" width="693" height="212" />
<div id="apDiv1">
  <table width="236" height="184" border="1">
    <tr>
      <td width="114" height="56">01-Dec-2011 5:02 PM</td>
      <td width="106" rowspan="3"> Foto User </td>
    </tr>
    <tr>
      <td height="68"><p>Selamat Datang <a href="#">User</a> !</p></td>
    </tr>
    <tr>
      <td height="50"><input type="submit" name="So" id="So" value="Keluar" /></td>
    </tr>
  </table>
</div>
<form id="form1" name="form_tambah_rumah" method="post" action="proses_tambah_rumah">
  <p>SiOR</p>
  <table width="401" border="0">
    <tr>
      <td width="123">Kode Rumah </td>
      <td width="10">:</td>
      <td width="711"><input name="kode_rumah" type="text" size="30" /></td>
    </tr>
  </table>
  <p>Lengkapi data berikut : </p>
  <table width="507" border="0">
    <tr>
      <td width="120">Alamat rumah </td>
      <td width="7">:</td>
      <td width="358"><textarea name="alamat_area" cols="50" rows="4"></textarea></td>
    </tr>
    <tr>
      <td>RT Rumah</td>
      <td>:</td>
      <td><input name="rt_rumah" type="text" size="8" /></td>
    </tr>
    <tr>
      <td>RW Rumah</td>
      <td>:</td>
      <td><input name="rw_rumah" type="text" size="8" /></td>
    </tr>
    <tr>
      <td>Kelurahan Rumah</td>
      <td>:</td>
      <td><input name="kelurahan_rumah" type="text" size="8" /></td>
    </tr>
    <tr>
      <td>Kecamatan Rumah</td>
      <td>:</td>
      <td><input name="kecamatan_rumah" type="text" size="8" /></td>
    </tr>
    <tr>
      <td>Kota Rumah </td>
      <td>:</td>
      <td><input name="kota_rumah" type="text" size="30" /></td>
    </tr>
     <tr>
      <td>Provinsi Rumah </td>
      <td>:</td>
      <td><input name="provinsi_rumah" type="text" size="30" /></td>
    </tr>
  </table>
  <p>&nbsp;</p>
  <div align="center">
    <input type="submit" name="Submit" value="Simpan" />
    <a href="javascript:document.form_tambah_rumah.reset()"><input type="button" name="button" value="Reset"></a>
    <a href="lihat_rumah"><input type="button2" name="button" value="Reset"></a>
  </div>
  <p>&nbsp;</p>
  <p>&nbsp;  </p>
</form>
</body>
</html>
