<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Menambah Pembayaran Gaji</title>
<style type="text/css">
#apDiv1 {	position:absolute;
	left:714px;
	top:74px;
	width:237px;
	height:182px;
	z-index:1;
}
#apDiv2 {
	position:absolute;
	left:908px;
	top:72px;
	width:237px;
	height:182px;
	z-index:1;
}
</style>
</head>

<body>
<p></p>
<img src="http://i1010.photobucket.com/albums/af230/ntonk59/Untitled-1.png" width="873" height="214" />
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
<form action="proses_tambah_gaji" method="post" name="form_tambah_gaji">
  <p>SiOR</p>
  <p>&nbsp;</p>
  <table width="866" border="0">
    <tr>
      <td width="157">Nomor Pembayaran</td>
      <td><input name="kode_bayar" type="text" style="width: 100px"></td>
    </tr>
    <tr>
      <td>Jenis Gaji</td>
      <td>:</td>
      <td><input name="jenis_gaji" type="text" style="width: 100px" ></td>
      <td>(kebersihan/keamanan) </td>
    </tr>
    <tr>
      <td>Nama Pekerja </td>
      <td>:</td>
      <td><input name="penerima_gaji" type="text" style="width: 200px" ></td>
    </tr>
    <tr>
      <td>Pembayaran Bulan </td>
      <td>:</td>
      <td width="110"><select name="bulangaji">
        <option selected="selected">Januari</option>
        <option>Februari</option>
        <option>Maret</option>
        <option>April</option>
        <option>Mei</option>
        <option>Juni</option>
        <option>Juli</option>
        <option>Agustus</option>
        <option>September</option>
        <option>Oktober</option>
        <option>November</option>
        <option>Desember</option>
      </select></td>
    </tr>
    <tr>
      <td>Tahun </td>
      <td>:</td>
      <td><input name="tahun_gaji" type="text" style="width: 50px" ></td>
    </tr>
      <tr>
      <td>Jumlah Gaji </td>
      <td>:</td>
      <td><input name="jumlah_gaji" type="text" style="width: 100px" ></td>
    </tr>
    <tr>
      <td height="129">Keterangan</td>
      <td>:</td>
      <td><textarea name="textarea" cols="40" rows="7"></textarea></td>
    </tr>
  </table>
  <p>&nbsp;</p>
  <table width="870" border="0">
    <tr>
      <td width="860"><div align="right">
          <input type="submit" name="Submit" value="Simpan" />
          <a href="javascript:document.form_tambah_keluarga.reset()"><input type="button" name="button" value="Reset"></a>
          <a href="lihat_gaji" <input type="button" name="Button" value="  Batal  " />
      </div></td>
    </tr>
  </table>
  <p>&nbsp;</p>
</form>
</body>
</html>
