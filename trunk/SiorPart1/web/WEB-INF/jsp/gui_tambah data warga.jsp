<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
</head>

<body>
<form enctype="multipart/form-data">
   <p>SIOR</p>
   <p>Isilah form tambah warga dibawah ini: </p>
   
   <table width="846" border="0">
     <tr>
       <td width="154">ID Kartu Keluarga </td>
       <td width="11">:</td>
       <td width="244"><input type="text" name="textfield" /></td>
       <td width="159">Bukti KTP </td>
       <td width="10">:</td>
       <td width="218"><input type="file" name="file" /></td>
     </tr>
   </table>
   <table width="435" border="0">
     <tr>
       <td width="154">ID Keluarga </td>
       <td width="11">:</td>
       <td width="247"><input type="text" name="textfield2" /></td>
     </tr>
     <tr>
       <td>Nama Lengkap</td>
       <td>:</td>
       <td><input type="text" name="textfield3" /></td>
     </tr>
   </table>
   <table width="846" border="0">
     <tr>
       <td width="154">Tempat Lahir </td>
       <td width="11">:</td>
       <td width="244"><input type="text" name="textfield4" /></td>
       <td width="159">Tanggal Lahir </td>
       <td width="10">:</td>
       <td width="218"><input type="text" name="textfield9" /></td>
     </tr>
     <tr>
       <td>Alamat (Sesuai KTP) </td>
       <td>:</td>
       <td><input type="text" name="textfield5" /></td>
       <td>Kode Pos (Sesuai KTP) </td>
       <td>:</td>
       <td><input type="text" name="textfield10" /></td>
     </tr>
     <tr>
       <td>RT (Sesuai KTP) </td>
       <td>:</td>
       <td><input type="text" name="textfield6" /></td>
       <td>RW (Sesuai KTP) </td>
       <td>:</td>
       <td><input type="text" name="textfield11" /></td>
     </tr>
     <tr>
       <td>Kelurahan (Sesuai KTP) </td>
       <td>:</td>
       <td><input type="text" name="textfield7" /></td>
       <td>Kecamatan (Sesuai KTP) </td>
       <td>:</td>
       <td><input type="text" name="textfield12" /></td>
     </tr>
     <tr>
       <td>Kota (Sesuai KTP) </td>
       <td>:</td>
       <td><input type="text" name="textfield8" /></td>
       <td>Provinsi (Sesuai KTP) </td>
       <td>:</td>
       <td><input type="text" name="textfield13" /></td>
     </tr>
   </table>
   <table width="434" border="0">
     <tr>
       <td width="154">Warga Negara </td>
       <td width="11">:</td>
       <td width="244"><input type="text" name="textfield14" /></td>
     </tr>
     <tr>
       <td>Agama</td>
       <td>:</td>
       <td><input type="text" name="textfield15" /></td>
     </tr>
     <tr>
       <td>Golongan Darah </td>
       <td>:</td>
       <td><select name="select">
         <option selected="selected">A</option>
         <option>B</option>
         <option>AB</option>
         <option>O</option>
       </select>
       </td>
     </tr>
   </table>
   <table width="846" border="0">
     <tr>
       <td><div align="right">
         <input name="Submit" type="submit" id="Submit" value="Simpan" />
         <input name="Batal" type="button" id="Batal" value="Batal" />
		 
       </div></td>
     </tr>
   </table>
   <p>&nbsp;</p>
   <p>&nbsp;</p>
   <p>&nbsp;</p>
</form>
</body>
</html>
