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
	left:1224px;
	top:38px;
	width:178px;
	height:193px;
	z-index:1;
}
</style>
<script type="text/javascript">
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
</script>
</head>
<p></p>
<p></p>
<body onload="MM_preloadImages('file:///C|/Users/ntonk/Documents/Unnamed Site 2/money-673.gif')">
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
<a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image2','','file:///C|/Users/ntonk/Documents/Unnamed Site 2/money-673.gif',1)"><img src="file:///C|/Users/ntonk/Documents/Unnamed Site 2/money8374615.jpg" name="Image2" width="1399" height="342" border="0" id="Image2" /></a>
</body>
</html>
