/**
 * 
 */

$(function () {
	
	$('#btnProjectTabAdd').click(function (e) {
	  	var nextTab = $('#projectTabs li').size()+1;
		
	  	// create the tab
	  	$('<li role="presentation"><a href="#tab'+nextTab+'" aria-controls="tab'+nextTab+'" role="tab" data-toggle="tab">Tab '+nextTab+'</a></li>').appendTo('#projectTabs');
	  	
	  	// create the tab content
	  	$('<div role="tabpanel" class="tab-pane fade" id="tab'+nextTab+'">tab' +nextTab+' content</div>').appendTo('.projectTab-content');
	  	
	  	// make the new tab active
	  	$('#projectTabs a:last').tab('show');
	});
	
});





