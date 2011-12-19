<%-- 
    Document   : detailkebersihan
    Created on : 19 Des 11, 15:09:53
    Author     : ntonk
--%>

<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<style type="text/css">
#apDiv1 {
	position:absolute;
	left:717px;
	top:40px;
	width:237px;
	height:182px;
	z-index:1;
}
#apDiv2 {
	position:absolute;
	left:716px;
	top:286px;
	width:238px;
	height:26px;
	z-index:2;
}
</style>
<style type="text/css">
#apDiv3 {
	position:absolute;
	left:714px;
	top:330px;
	width:241px;
	height:216px;
	z-index:3;
}
</style>
<style type="text/css">
#apDiv4 {
	position:absolute;
	left:6px;
	top:1050px;
	width:678px;
	height:40px;
	z-index:4;
	text-align: right;
}
#form1 p #Edit {
	text-align: right;
}
p {
	text-align: left;
}
#apDiv5 {
	position:absolute;
	left:10px;
	top:1048px;
	width:46px;
	height:26px;
	z-index:5;
}
#apDiv6 {	position:absolute;
	left:724px;
	top:70px;
	width:237px;
	height:182px;
	z-index:1;
}
</style>
<script type="text/javascript">
function MM_jumpMenuGo(objId,targ,restore){ //v9.0
  var selObj = null;  with (document) { 
  if (getElementById) selObj = getElementById(objId);
  if (selObj) eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0; }
}
function MM_jumpMenu(targ,selObj,restore){ //v3.0
  eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0;
}
</script>
</head>

<body>
<div id="apDiv2">
  <form id="form5" name="form5" method="post" action="">
    <select name="jumpMenu" id="jumpMenu">
      <option>Menu Utama</option>
      <option>Menu Keuangan</option>
      <option>Menu Hunian</option>
    </select>
    <input type="button" name="go_button" id= "go_button" value="Go" onclick="MM_jumpMenuGo('jumpMenu','parent',0)" />
  </form>
</div>
<div id="apDiv3">
  <form id="form4" name="form4" method="post" action="">
    <p>Notifikasi Pengguna

      <label for="list"></label>
    </p>
    <table width="244" height="140" border="1">
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>
    <p>
      <label for="text"></label>
    </p>
  </form>
</div>
<img src="http://i1010.photobucket.com/albums/af230/ntonk59/Untitled-1.png" width="691" height="220" />
<p></p>
 <form id="form1" name="form1" method="post" action="">
   <p>SiOR Keuangan Iuran Kebersihan</p>
   <p>Detail <a href="#">User</a> ,</p>
   <table width="646" border="1">
     <tr>
       <td width="101" align="center">Periode Iuran</td>
       <td width="101" align="center">Tanggal Pembayaran</td>
       <td width="101" align="center">Jumlah yang harus dibayar</td>
       <td width="101" align="center">Sudah dibayarkan</td>
       <td width="101" align="center">Kekurangan pembayaran</td>
       <td width="101" align="center">Lunas</td>
     </tr>
     <tr>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td align="center"><input type="checkbox" name="checkb1" id="checkb1" />
       <label for="checkb1"></label></td>
     </tr>
     <tr>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td align="center"><input type="checkbox" name="checkb2" id="checkb2" /></td>
     </tr>
     <tr>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td align="center"><input type="checkbox" name="checkb3" id="checkb3" /></td>
     </tr>
     <tr>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td align="center"><input type="checkbox" name="checkb4" id="checkb4" /></td>
     </tr>
     <tr>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td align="center"><input type="checkbox" name="checkb5" id="checkb5" /></td>
     </tr>
     <tr>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td align="center"><input type="checkbox" name="checkb6" id="checkb6" /></td>
     </tr>
     <tr>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td align="center"><input type="checkbox" name="checkb7" id="checkb7" /></td>
     </tr>
     <tr>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td align="center"><input type="checkbox" name="checkb8" id="checkb8" /></td>
     </tr>
     <tr>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td align="center"><input type="checkbox" name="checkb9" id="checkb9" /></td>
     </tr>
     <tr>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td align="center"><input type="checkbox" name="checkb10" id="checkb10" /></td>
     </tr>
     <tr>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td>&nbsp;</td>
       <td align="center"><input type="checkbox" name="checkb11" id="checkb11" /></td>
     </tr>
   </table>
   <p>&nbsp;</p>
</form>
<p>&nbsp;</p>
<div id="apDiv1">
    <table width="236" height="184" border="1">
      <tr>
        <td width="114" height="56">01-Dec-2011 5:02 PM</td>
        <td width="106" rowspan="3" align="center"> Foto User </td>
      </tr>
      <tr>
        <td height="68"><p>Selamat Datang <a href="#">User</a> !</p></td>
      </tr>
      <tr>
        <td height="50"><input type="submit" name="So" id="So" value="Keluar" /></td>
      </tr>
    </table>
</div>
</body>
</html>