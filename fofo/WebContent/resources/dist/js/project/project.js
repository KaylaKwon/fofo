/**
 * 
 */

$(function () {
	
	$('#btnProjectTabAdd').click(function (e) {
	  	var nextTab = $('#projectTab li').size()+1;
		console.log(nextTab);
		
		var projectTab = document.getElementById("projectTab");
//		projectTab.insertBefore("<li role='presentation'><a href='#tab"+nextTab+"' aria-controls='tab"+nextTab+"' role='tab' data-toggle='tab'>Tab "+nextTab+"</a></li>", projectTab.childNodes[0]); 
	  	// create the tab
	  	$('<li role="presentation"><a href="#tab'+nextTab+'" aria-controls="tab'+nextTab+'" role="tab" data-toggle="tab">Tab '+nextTab+'</a></li>').insertBefore('#liProjectTabAdd');
	  	
	  	// create the tab content
	  	$('<div role="tabpanel" class="tab-pane fade" id="tab'+nextTab+'">tab' +nextTab+' content</div>').appendTo('.projectTab-content');
	  	
	  	// make the new tab active
	  	$('#projectTab a:last').tab('show');
	});

	
	
	// <![CDATA[
	var name = "#floatMenu";
	var menuYloc = null;
	
		$(document).ready(function(){
			menuYloc = parseInt($(name).css("top").substring(0,$(name).css("top").indexOf("px")))
			$(window).scroll(function () { 
				offset = menuYloc+$(document).scrollTop()+"px";
				$(name).animate({top:offset},{duration:500,queue:false});
			});
		}); 
	// ]]>
	
		
		
/*	function set_remoconposition(e) {
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
	}*/
	
});





