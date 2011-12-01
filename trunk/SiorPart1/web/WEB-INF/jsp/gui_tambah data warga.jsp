<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Menambah Informasi Warga</title>

<style type="text/css">
#apDiv1 {
	position:absolute;
	left:530px;
	top:28px;
	width:237px;
	height:182px;
	z-index:1;
}
</style>
</head>

<body>
<div id="apDiv1">
  <table width="236" height="184" border="1">
    <tr>
      <td width="114" height="56">01-Dec-2011 5:02 PM</td>
      <td width="106" rowspan="3"><form id="form1" name="form1" method="post" action="">
        Foto User
      </form></td>
    </tr>
    <tr>
      <td height="68"><form id="form2" name="form2" method="post" action="">
        <p>Selamat Datang <a href="#">User</a> !</p>
</form></td>
    </tr>
    <tr>
      <td height="50"><form id="form3" name="form3" method="post" action="">
        <input type="submit" name="So" id="So" value="Keluar" />
      </form></td>
    </tr>
  </table>
</div>
<p><img src="file:///C|/Users/ntonk/Documents/Unnamed Site 2/Untitled-1.png" width="515" height="210" />O</p>
<form enctype="multipart/form-data">
  <p>SIOR</p>
   <p>Isilah form tambah warga dibawah ini: </p>
   
   <table width="751" border="0">
     <tr>
       <td width="165">No KTP </td>
       <td width="15">:</td>
       <td width="144"><input type="text" name="txt_noktp" /></td>
       <td width="175">Bukti KTP </td>
       <td width="6">:</td>
       <td width="220"><input type="file" name="file" /></td>
     </tr>
   </table>
   <table width="473" border="0">
     <tr>
       <td width="165">Kode Keluarga</td>
       <td width="14">:</td>
       <td width="280"><input type="text" name="txt_kodekeluarga" /></td>
     </tr>
     <tr>
       <td>Nama Lengkap</td>
       <td>:</td>
       <td><input type="text" name="txt_namalengkap" /></td>
     </tr>
  </table>
  <table width="758" height="137" border="0">
     <tr>
       <td width="165">Tempat Lahir </td>
       <td width="14">:</td>
       <td width="149"><input type="text" name="txt_tempatlahir" /></td>
       <td width="175">Tanggal Lahir </td>
       <td width="9">:</td>
       <td width="220"><input type="text" name="txt_tanggallahir" /></td>
     </tr>
     <tr>
       <td>Alamat (Sesuai KTP) </td>
       <td>:</td>
       <td><input type="text" name="txt_alamatktp" /></td>
       <td>Kode Pos (Sesuai KTP) </td>
       <td>:</td>
       <td><input type="text" name="txt_kodeposktp" /></td>
     </tr>
     <tr>
       <td>RT (Sesuai KTP) </td>
       <td>:</td>
       <td><input type="text" name="txt_rtktp" /></td>
       <td>RW (Sesuai KTP) </td>
       <td>:</td>
       <td><input type="text" name="txt_rwktp" /></td>
     </tr>
     <tr>
       <td>Kelurahan (Sesuai KTP) </td>
       <td>:</td>
       <td><input type="text" name="txt_kelurahanktp" /></td>
       <td>Kecamatan (Sesuai KTP) </td>
       <td>:</td>
       <td><input type="text" name="txt_kecamatanktp" /></td>
     </tr>
     <tr>
       <td>Kota (Sesuai KTP) </td>
       <td>:</td>
       <td><input type="text" name="txt_kotaktp" /></td>
       <td>Provinsi (Sesuai KTP) </td>
       <td>:</td>
       <td><input type="text" name="txt_povinsiktp" /></td>
     </tr>
  </table>
  <table width="480" height="84" border="0">
     <tr>
       <td width="165">Warga Negara </td>
       <td width="13">:</td>
       <td width="288"><input type="text" name="txt_kewarganegaraa" /></td>
     </tr>
     <tr>
       <td>Agama</td>
       <td>:</td>
       <td><input type="text" name="txt_agama" /></td>
     </tr>
     <tr>
       <td>Golongan Darah </td>
       <td>:</td>
       <td><select name="txt_golongandarah">
         <option selected="selected">A</option>
         <option>B</option>
         <option>AB</option>
         <option>O</option>
       </select>
       </td>
     </tr>
  </table>
   <table width="766" border="0">
     <tr>
       <td width="762"><div align="right">
         <input name="Submit" type="submit" id="Submit" value="Simpan" />
         <input name="Batal" type="button" id="Batal" value="Batal" />
		 
       </div></td>
     </tr>
  </table>
</form>
<p>&nbsp;</p>
</body>
</html>