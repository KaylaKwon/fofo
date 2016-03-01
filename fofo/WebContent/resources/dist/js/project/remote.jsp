<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>함트의 집</title>
<script src=new_win.js></script>
</head>

<body style='overflow: hidden; margin: 0px;' onResize='resize_win();'>
	<iframe src="http://www.naver.com" style="z-index: 1;" frameborder="0"
		width="100%" height="100%" scrolling="auto"></iframe>

	<div id="dialogbackgroundlayer"
		style="display: none; position: absolute; z-index: 999;"
		onClick="win.dialog_close()" onMouseUp="change_mode(false);"
		onMouseMove='set_remoconposition(arguments[0]);'></div>
	<div id="dialoglayer" style="display: hidden;"></div>


	<div id="remote"
		style="position: absolute; z-index: 1000; right: 27px; top: 10px;"
		onMouseMove='set_remoconposition(arguments[0]);'>
		<!-- 리모콘 시작 -->
		<table width=100 border=0 cellpadding=0 cellspacing=1 bgcolor=#555555>
			<tr bgcolor=#aaaaff align=right>
				<td id=topbar style='cursor: move'
					onMouseDown='change_mode(true, arguments[0]);'
					onMouseUp='change_mode(false);'
					onMouseMove='set_remoconposition(arguments[0]);'><img
					src=/images/new_win/x.gif style='cursor: hand;' border=0
					onclick="location.href=document.getElementById('innerpage').src"></td>
			</tr>

			<tr>
				<td height=200 bgcolor=#ffffff><a href=/index.php
					style='font-size: 11px'>함트 홈피로 되돌아가기</a></td>
			</tr>
			<tr>
				<td bgcolor=#aaaaff></td>
			</tr>
		</table>
		<!-- 리모콘 끝 -->
	</div>
	<div id=message
		style="display: none; position: absolute; left: 0px; top: 0px; padding: 3px; background: #cc0000; color: #ffffff; font-size: 13px; font-weight: bold; z-index: 100;"></div>
	<script>
		var win = new new_popup();
		var dragmode = false;

		function resize_win() {
			var w = document.body.clientWidth;
			var obj = document.getElementById('remote');
			if (parseInt(obj.style.left.split('px')[0]) + 105 > w) {
				obj.style.left = (w - 105) + 'px';
			}
		}
		function set_remoconposition(e) {
			if (dragmode) {
				var obj = document.getElementById('remote');
				if (win.is_ie) {
					var x = event.x;
					var y = event.y;
				} else {
					var x = e.pageX;
					var y = e.pageY;
				}
				obj.style.right = '';
				obj.style.left = (x - 50) + 'px';
				obj.style.top = (y - 10) + 'px';
			}
		}
		function change_mode(val, e) {
			dragmode = val;
			if (val) {
				win.dialog_open('', 0);
			} else
				win.dialog_close();
		}
	</script>
</body>
</html>