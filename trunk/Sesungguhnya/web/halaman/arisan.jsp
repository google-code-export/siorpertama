<%-- 
    Document   : arisan
    Created on : 19 Des 11, 15:11:20
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
	left:12px;
	top:1072px;
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
	left:14px;
	top:1073px;
	width:46px;
	height:26px;
	z-index:5;
}
</style>
<script type="text/javascript">
function MM_jumpMenuGo(objId,targ,restore){ //v9.0
  var selObj = null;  with (document) { 
  if (getElementById) selObj = getElementById(objId);
  if (selObj) eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0; }
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
<div id="apDiv4">
  <form id="form2" name="form2" method="post" action="">
    <input type="submit" name="First" id="First" value="&lt;&lt;" />
    <input type="submit" name="page1" id="page1" value="2" />
    <input type="submit" name="page2" id="page2" value="3" />
    <input type="submit" name="page3" id="page3" value="4" />
    <input type="submit" name="page4" id="page4" value="5" />
<input type="submit" name="Last" id="Last" value="&gt;&gt;" />
  </form>
</div>
<div id="apDiv5">
  <form id="form3" name="form3" method="post" action="">
    <input type="submit" name="go" id="go" value="GO" />
  </form>
</div>
<img src="http://i1010.photobucket.com/albums/af230/ntonk59/Untitled-1.png" width="691" height="220" /><p></p>
 <form id="form1" name="form1" method="post" action="">
   <p>SiOR Keuangan Iuran </p>
   <p>&nbsp;</p>
   <p>Iuran Arisan</p>
   <table width="658" height="676" border="1">
     <tr>
        <td align="center">Target</td>
        <td align="center">Nam User</td>
        <td align="center">Jumlah Iuran</td>
        <td align="center">Periode</td>
     </tr>
      <tr>
        <td align="center"><input type="checkbox" name="centang1" id="centang1" />
        <label for="centang1"></label></td>
        <td align="center">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td align="center"><input type="checkbox" name="centang2" id="centang2" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
     </tr>
      <tr>
        <td align="center"><input type="checkbox" name="centang3" id="centang3" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
     </tr>
      <tr>
        <td align="center"><input type="checkbox" name="centang4" id="centang4" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
     </tr>
      <tr>
        <td align="center"><input type="checkbox" name="centang5" id="centang5" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
     </tr>
      <tr>
        <td align="center"><input type="checkbox" name="centang6" id="centang6" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
     </tr>
      <tr>
        <td align="center"><input type="checkbox" name="centang7" id="centang7" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
     </tr>
      <tr>
        <td align="center"><input type="checkbox" name="centang8" id="centang8" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
     </tr>
      <tr>
        <td align="center"><input type="checkbox" name="centang9" id="centang9" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
     </tr>
      <tr>
        <td align="center"><input type="checkbox" name="centang10" id="centang10" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
     </tr>
      <tr>
        <td align="center"><input type="checkbox" name="centang11" id="centang11" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
     </tr>
      <tr>
        <td align="center"><input type="checkbox" name="centang12" id="centang12" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
     </tr>
      <tr>
        <td align="center"><input type="checkbox" name="centang13" id="centang13" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
     </tr>
      <tr>
        <td align="center"><input type="checkbox" name="centang14" id="centang14" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
     </tr>
      <tr>
        <td align="center"><input type="checkbox" name="centang15" id="centang15" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
     </tr>
      <tr>
        <td height="24" align="center"><input type="checkbox" name="centang16" id="centang16" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
     </tr>
      <tr>
        <td align="center"><input type="checkbox" name="centang17" id="centang17" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
     </tr>
      <tr>
        <td align="center"><input type="checkbox" name="centang18" id="centang18" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
     </tr>
      <tr>
        <td align="center"><input type="checkbox" name="centang19" id="centang19" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
     </tr>
   </table>
   <p>&nbsp;</p>
</form>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
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