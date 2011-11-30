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
   <table width="900" border="0">
     <tr>
       <td width="158">Tempat Lahir </td>
       <td width="11">:</td>
       <td width="250"><input type="text" name="textfield4" /></td>
       <td width="164">Tanggal Lahir </td>
       <td width="10">:</td>
       <td width="281"><select name="select2">
         <option selected="selected">1</option>
         <option>2</option>
         <option>3</option>
         <option>4</option>
         <option>5</option>
         <option>6</option>
         <option>7</option>
         <option>8</option>
         <option>9</option>
         <option>10</option>
         <option>11</option>
         <option>12</option>
         <option>13</option>
         <option>14</option>
         <option>15</option>
         <option>16</option>
         <option>17</option>
         <option>18</option>
         <option>19</option>
         <option>20</option>
         <option>21</option>
         <option>22</option>
         <option>23</option>
         <option>24</option>
         <option>25</option>
         <option>26</option>
         <option>27</option>
         <option>28</option>
         <option>29</option>
         <option>30</option>
         <option>31</option>
       </select> <select name="select3">
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
       </select>
       <select name="select4">
         <option>2008</option>
         <option>2009</option>
         <option>2010</option>
         <option>2011</option>
         <option>2012</option>
         <option>2013</option>
         <option>2014</option>
         <option>2015</option>
         <option>2016</option>
         <option>2017</option>
         <option>2018</option>
         <option>2019</option>
         <option>2020</option>
         <option>1945</option>
         <option>1950</option>
         <option>1951</option>
         <option>1952</option>
         <option>1953</option>
         <option>1954</option>
         <option>1955</option>
         <option>1956</option>
         <option>1957</option>
         <option>1958</option>
         <option>1959</option>
         <option>1960</option>
         <option>1961</option>
         <option>1962</option>
         <option>1963</option>
         <option>1964</option>
         <option>1965</option>
         <option>1966</option>
         <option>1967</option>
         <option>1968</option>
         <option>1969</option>
         <option>1970</option>
         <option>1971</option>
         <option>1972</option>
         <option>1973</option>
         <option>1974</option>
         <option>1975</option>
         <option>1976</option>
         <option>1977</option>
         <option>1978</option>
         <option>1979</option>
         <option>1980</option>
         <option>1981</option>
         <option>1982</option>
         <option>1983</option>
         <option>1984</option>
         <option>1985</option>
         <option>1986</option>
         <option>1987</option>
         <option>1988</option>
         <option>1989</option>
         <option>1990</option>
         <option>1991</option>
         <option>1992</option>
         <option>1993</option>
         <option>1994</option>
         <option>1995</option>
         <option>1996</option>
         <option>1997</option>
         <option>1998</option>
         <option>1999</option>
         <option>2000</option>
         <option>2001</option>
         <option>2002</option>
         <option>2003</option>
         <option>2004</option>
         <option>2005</option>
         <option>2006</option>
         <option>2007</option>
         <option>2008</option>
         <option>2009</option>
         <option>2010</option>
         <option>2011</option>
         <option>2012</option>
         <option>2013</option>
         <option>2014</option>
         <option>2015</option>
         <option>2016</option>
         <option>2017</option>
         <option>2018</option>
         <option>2019</option>
         <option>2020</option>
                     </select></td>
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
