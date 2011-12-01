<%-- 
    Document   : halamandepan
    Created on : 29 Nov 11, 9:48:01
    Author     : ntonk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet" type="text/css" />
<style type="text/css">
#apDiv1 {
	position:absolute;
	left:12px;
	top:13px;
	width:258px;
	height:104px;
	z-index:1;
}
#apDiv2 {
	position:absolute;
	left:1096px;
	top:32px;
	width:276px;
	height:198px;
	z-index:1;
}
#apDiv3 {
	position:absolute;
	left:1064px;
	top:24px;
	width:178px;
	height:193px;
	z-index:1;
}
</style>
</head>
<p></p>
<p></p>
<body>
<div id="apDiv3">
  <table width="180" height="197" border="1">
    <tr>
      <td>01-Dec-2011 4:07 PM</td>
    </tr>
    <tr>
      <td>Selamat Datang Tamu !</td>
    </tr>
    <tr>
      <td><form id="form1" name="form1" method="post" action="">
        <input type="submit" name="si" id="si" value="Masuk" />
        <input type="submit" name="re" id="re" value="Registrasi" />
      </form></td>
    </tr>
  </table>
</div>
<p><img src="file:///C|/Users/ntonk/Documents/Unnamed Site 2/Untitled-1.png" width="1059" height="214" /></p>
<p></p>
<div id="TabbedPanels1" class="TabbedPanels">
  <ul class="TabbedPanelsTabGroup">
    <li class="TabbedPanelsTab" tabindex="0">Apa itu SiOR?</li>
    <li class="TabbedPanelsTab" tabindex="0">Proses Registrasi</li>
    <li class="TabbedPanelsTab" tabindex="0">Persyaratan Anggota RT /RW</li>
</ul>
  <div class="TabbedPanelsContentGroup">
    <div class="TabbedPanelsContent">Content 1</div>
    <div class="TabbedPanelsContent">Content 2</div>
    <div class="TabbedPanelsContent">Content 3</div>
</div>
</div>
<script type="text/javascript">
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
</script>
<p></p>
<p></p>
</body>
</html>