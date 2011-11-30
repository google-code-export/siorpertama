<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
</head>

<body>
<form id="form1" name="form1" method="post" action="">
  <p>SiOR</p>
  <p>&nbsp;</p>
  <table width="487" border="0">
    <tr>
      <td width="164">Iuran Bulan </td>
      <td width="8">:</td>
      <td width="293"><select name="select4">
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
  </table>
  <table width="488" border="0">
    <tr>
      <td width="141">Tanggal Pembayaran </td>
      <td width="7">:</td>
      <td width="66"><select name="select">
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
      </select></td>
      <td width="110"><select name="select2">
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
      <td width="65"><select name="select3">
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
  </table>
  <p>&nbsp;</p>
  <table width="510" border="0">
    <tr>
      <td width="157">ID Rumah </td>
      <td width="8">:</td>
      <td width="406"><input name="textfield" type="text" size="30" /></td>
    </tr>
    <tr>
      <td>ID Keluarga </td>
      <td>:</td>
      <td><input name="textfield2" type="text" size="30" /></td>
    </tr>
  </table>
  <p>Jenis iuran bulanan :</p>
  <table width="510" border="0">
    <tr>
      <td width="157">Iuran kas bulanan </td>
      <td width="8">:</td>
      <td width="406"><input name="textfield3" type="text" value="Rp " size="30" /></td>
    </tr>
    <tr>
      <td>Iuran kebersihan </td>
      <td>:</td>
      <td><input name="textfield32" type="text" value="Rp " size="30" /></td>
    </tr>
  </table>
  <table width="510" border="0">
    <tr>
      <td width="157">Iuran keamanan </td>
      <td width="8">:</td>
      <td width="406"><input name="textfield33" type="text" value="Rp " size="30" /></td>
    </tr>
    <tr>
      <td>Iuran arisan </td>
      <td>:</td>
      <td><input name="textfield34" type="text" value="Rp " size="30" /></td>
    </tr>
  </table>
  <p>&nbsp;</p>
  <table width="600" border="0">
    <tr>
      <td width="561"><div align="right">
          <input type="submit" name="Submit2" value="Simpan" />
          <input type="button" name="Button" value="  Batal  " />
      </div></td>
    </tr>
  </table>
</form>
</body>
</html>
