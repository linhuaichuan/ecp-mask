<%@page import="com.myzmds.sociology.mask.common.FlagConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html class="no-js">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>仙游县供销社-口罩预约</title>
  <meta name="format-detection" content="telephone=no">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black"> 
  <link rel="icon" type="image/png" href="skin/favicon.png">
  
  <link href="skin/hotels.css" rel="stylesheet" type="text/css">
  <script src="static/jquery-1.10.2.min.js"></script>
  <style>
.content {
    background-color: rgba(255, 255, 255, 0.9);
    border: 1px solid #C6C6C6;
    border-radius: 5px;
    box-shadow: 0 1px 1px #F6F6F6;
    display: block;
    font-size: 14px;
    line-height: 24px;
    text-align: left;
    padding:10px 10px;
	margin-bottom: 10px;
}
.content h2{font-weight: bold;text-align: center;height: 30px;line-height: 30px;font-size:16px;}
.content .text img{max-width: 100%;}
#content{ overflow:hidden; height:274px;}
#content .xxvxv b{ border-top: 10px solid #fff; line-height:30px;}
#show_hide{ font-size:15px; color:#FF0000;}
.submit1{ margin:0 auto 20px auto;width:100%;font-size: 18px; }
.btn_box{ width:100%; text-align:center;}
.btn_box .btn_1{ float:left; width:50%; background-color:#ececec; font-weight:bold;}
.btn_box .btn_2{ float:right;  width:50%; background-color:#ffffff}
.btn_box li a{ display:block; height:50px; line-height:50px; color:#666666}
.btn_box .btn_1 a{ color:#000;}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
<body>
<div class="banner">
<div id="wrapper">

<div id="scroller" style="float:none">
<ul id="thelist">
<li style="float:none">
<p style="text-align: center;">监督电话：<a href="tel:13860916536">13860916536</a></p>
<a href="<%=request.getContextPath()%>/"><img src="skin/barnar.jpg" alt="供销社~口罩预约" style="width:100%"></a></li>
</ul>
</div>
</div>
<div class="clr"></div>
</div>

<div class="btn_box">
<li class="btn_1"><a href="<%=request.getContextPath()%>/">个人预约</a></li>
<li class="btn_2"><a href="http://gxs.hygyc.com:68/index2.asp">企业预约</a></li>
<div class="clr"></div>
</div>

<div class="cardexplain">

<!--详细介绍start-->
<div class="content">
<div id="content">
<h2>线上预约口罩须知</h2>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;抗击疫情保健康，仙游供销勇担当。病毒无情，供销有爱！面对当前防疫口罩紧缺现状，仙游供销主动请战，承担口罩等防疫物资采购任务，保障仙游人民对防疫物资的需求，现推出线上预约口罩服务，具体事项公告如下：<br>
<div style=" padding-bottom:10px;">
<p style="padding-top:10px;"><b>一、预约须知</b></p>
<p style="padding-top:0px;">（1）关注“<b>仙游供销</b>”公众号，点击“<b>微供销</b>”—“<b>口罩预约</b>”，线上预约口罩，每日限量供应。</p>
<p style="padding-top:0px;">（2）凡是在<b>仙游工作生活</b>的人员，均可通过“<b>仙游供销</b>”微信公众号进行线上预约。</p>
<p style="padding-top:0px;">（3）预约人凭<b>身份证号码</b>、<b>手机号码</b>、<b>家庭住址</b>等信息预约，一次可预约购买口罩<b><%=FlagConfig.limitNum %></b>片。</p>
<p style="padding-top:0px;">（4）预约人在线上预约成功后，须在三日内携带<b>居民身份证</b>到<b>预约供应点</b>购买。购买时，请自觉排队，前后人员保持1米以上。</p>
<p style="padding-top:0px;">（5）预约人须遵守各供应点口罩售卖时间，<b>上午8:30-12:00</b>，<b>下午2:30-5:30</b>。</p>
<p style="padding-top:0px;">（6）预约人当日线上预约成功后，<b>5</b>日后才能再次预约购买。</p>
<p style="padding-top:0px;">（7）微信平台试运行期间，每日口罩线上投放量为1万个。随着我市口罩产量和我县口罩釆购储备量不断增加，线上口罩预约投放量也将随之增加。</p>

<p style="padding-top:10px;"><b>二、预约流程</b></p>
<p style="padding-top:0px;">（1）关注“仙游供销”微信公众号</p>
<p style="padding-top:0px;">（2）点击“微供销”—“口罩预约”</p>
<p style="padding-top:0px;">（3）如实填写预约信息，就近选择预约供应点</p>
<p style="padding-top:0px;">（4）提交信息后，页面显示“预约成功”，即可</p>

<p style="padding-top:10px;" class="xxvxv">三、预约口罩线下供应点：<br>
<b>1. 福建省仙游县供销投资集团有限公司</b><br>
地址：仙游县鲤南镇水乡丽都15号楼<br>
联系人：张雪萍<br>
联系电话：<a href="tel:13799007528">13799007528</a><br>
<b>2. 福建省仙游县供销新村大商场</b><br>
地址：仙游县鲤城街道胜利南路169号（供销新村）<br>
联系人：郑赛斌<br>
联系电话：<a href="tel:18959519838">18959519838</a><br>
<b>3. 仙游县城关供销合作社</b><br>
地址：仙游县鲤城镇木兰路木兰街道691号（龙升建材店）<br>
联系人：陈元喜<br>
联系电话：<a href="tel:13860908946">13860908946</a><br>
<b>4. 仙游县榜头供销合作社</b><br>
地址：仙游县榜头镇九鲤中街509号<br>
联系人：罗建国<br>
联系电话：<a href="tel:13799006243">13799006243</a><br>
<b>5. 仙游县盖尾供销合作社</b><br>
地址：仙游县盖尾镇盖尾村顶街239号（盖尾万客来超市）<br>
联系人：林瑞平、严丽娜<br>
联系电话：<a href="tel:13706076393">13706076393</a>、<a href="tel:13062134566">13062134566</a><br>
<b>6. 仙游县郊尾供销合作社</b><br>
地址：仙游县郊尾镇长安村后连再生资源基地（仙港大道郊尾段仿古石门边）<br>
联系人：李淑真<br>
联系电话：<a href="tel:18059560798">18059560798</a><br>
<b>7. 仙游县枫亭供销合作社</b><br>
地址：仙游县枫亭镇蔡襄南街90号<br>
联系人：林燕燕<br>
联系电话：<a href="tel:15860091837">15860091837</a><br>
<b>8. 仙游县园庄供销合作社</b><br>
地址：仙游县园庄镇枫园中路55号（信用社旁边）<br>
联系人：赵霞<br>
联系电话：<a href="tel:15880330306">15880330306</a><br>
<b>9. 仙游县大济供销合作社</b><br>
地址：仙游县大济镇大济街111号（万家鑫超市旁）<br>
联系人：陈榆楠<br>
联系电话：<a href="tel:17750346562">17750346562</a><br>
<b>10. 仙游县度尾供销合作社</b><br>
地址：仙游县度尾镇度峰北街132号<br>
联系人：吴玉灿<br>
联系电话：<a href="tel:13626919592">13626919592</a><br>
<b>11. 仙游县钟山供销合作社</b><br>
地址：仙游县钟山镇钟山街南街一号<br>
联系人：章仙平<br>
联系电话：<a href="tel:13110555779">13110555779</a><br>
<b>12. 仙游县游洋供销合作社</b><br>
地址：仙游县游洋镇游洋街古邑路168号<br>
联系人：陈振华<br>
联系电话：<a href="tel:13799697240">13799697240</a>
</p>
</div>
</div>

<a href="javascript:vod(0);"><b id="show_hide">∨ 展开</b></a>

<script>
document.getElementById('show_hide').onclick = function (){
var con = document.getElementById('content').style;
if(this.innerHTML == '∧ 收缩'){
con.height = 274+'px';
this.innerHTML = '∨ 展开';
return false;
} else {
con.height = 'auto';
this.innerHTML = '∧ 收缩';
return false;
}
}
</script>
<hr style="height:1px;border:none;border-top:1px dashed #C6C6C6;">


<font color="red" style="font-size:14px;"><strong> *</strong></font> 今日限购 <strong>${total }</strong> 个，当前剩余 <font color="#ff0000"><strong> ${surplus }</strong></font>个

</div>
<!--详细介绍end-->

<script>
$(document).ready(function(){
<c:choose>
    <c:when test="${0 == surplus}">
	window.document.getElementById("button1").value="预约名额已满";
	window.document.getElementById("button1").disabled=true;
    </c:when>
    <c:when test="${surplus > 0}">
    window.document.getElementById("button1").value="提交信息";
    </c:when>
    <c:otherwise>
	window.document.getElementById("button1").value="系统维护中";
	window.document.getElementById("button1").disabled=true;
    </c:otherwise>
</c:choose>
});
function tgSubmit(form) {
    if (form.name.value == '') {
        alert('请输入姓名，姓名不能为空!');
        form.name.focus;
        return false;
    }
    if (form.tel.value == '') {
        alert('请输入手机号，手机号不能为空!');
        form.tel.focus;
        return false;
    }
    if (form.tel.value != '') {
        var Mobile = form.tel.value
        if (! (/^1\d{10}$/.test(Mobile))) {
            alert("手机号码格式不对，请重新输入！");
            form.tel.focus();
            return false;
        }
    }
    if (form.address.value == '') {
        alert('请输入家庭住址，家庭住址不能为空!');
        form.address.focus;
        return false;
    }
    if (form.idCard.value == '') {
        alert('请输入身份证号，身份证号不能为空!');
        form.idCard.focus;
        return false;
    }
    if (form.idCard.value != '') {
        var val = form.idCard.value
        //if(!(/^350322\d{8}[0-9]{3}[0-9Xx]$/.test(val)))
        if (! (/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(val))) {
            alert("身份证号格式不对，请重新输入！");
            form.idCard.focus();
            return false;
        }
    }
    if (form.dotId.value == '') {
        alert('请选择就近网点，就近网点不能为空!');
        form.dotId.focus;
        return false;
    }
    $.ajax({
        type: 'POST',
        dataType: 'text',
        data: $("#form").serialize(),
        url: '<%=request.getContextPath()%>/reg',
        success: function(data) {
        	if(confirm(data)){
        		location.reload();
        	}
        },
        error: function(error) {
        	
        }
    })
    return false;
}
</script>
<form method="post" action="" id="form" onSubmit="return tgSubmit(this);">
<ul class="round">
<li class="title mb"><span class="none">请认真填写预约信息</span></li>
<li class="nob">
<table width="100%" border="0" cellspacing="5" cellpadding="0" class="kuang">
<tbody>
<tr><td>姓名<font color="red"><strong> *</strong></font></td></tr>
<tr><td><input type="text" class="px" id="name" name="name" value="" maxlength="20"></td></tr>
<tr><td>手机号<font color="red"><strong> *</strong></font></td></tr>
<tr><td><input type="text" class="px" id="tel" name="tel" value="" maxlength="11"></td></tr>
<tr><td>家庭住址<font color="red"><strong> *</strong></font></td></tr>
<tr><td><input type="text" class="px" id="address" name="address" value="" maxlength="50"></td></tr>
<tr><td>身份证号<font color="red"><strong> *</strong></font></td></tr>
<tr><td><input type="text" class="px" id="idCard" name="idCard" value="" maxlength="18"></td></tr>
<tr><td>预约供应点<font color="red"><strong> *</strong></font></td></tr>
<tr><td><select name="dotId" id="dotId" dataType="Require" class="px">
	<option selected value="">请选择就近网点</option>
	<c:forEach items="${dots }" var="item">
	<option value="${item.id }">${item.name }</option>
	</c:forEach>
   </select></td></tr>

</tbody>
</table>
</li>
</ul>
<div class="footReturn" style="text-align:center"><input id="button1" type="submit" class="submit submit1" value=""></div>
</form>
</div>

</body>
</html>