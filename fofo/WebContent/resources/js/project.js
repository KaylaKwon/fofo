/**
 * 
 */


$(function () {
	
	$('#summernote').summernote();

	$('#btnProjectTabAdd').click(function (e) {
	  	var nextTab = $('#projectTab li').size()+1;
//		console.log(nextTab);
		
		var projectTab = document.getElementById("projectTab");
//		projectTab.insertBefore("<li role='presentation'><a href='#tab"+nextTab+"' aria-controls='tab"+nextTab+"' role='tab' data-toggle='tab'>Tab "+nextTab+"</a></li>", projectTab.childNodes[0]); 
	  	$('<li role="presentation"><a href="#tab'+nextTab+'" aria-controls="tab'+nextTab+'" role="tab" data-toggle="tab">Tab '+nextTab+'</a></li>').insertBefore('#liProjectTabAdd');
	  	$('<div role="tabpanel" class="tab-pane fade" id="tab'+nextTab+'">tab' +nextTab+' content</div>').appendTo('.projectTab-content');
	  	$('#projectTab a:last').tab('show');
//	  	$('#projectTab a:nth-last-child(1)').tab('show');	//자잘한 에러
	});

	
	$('#summernote').summernote({
		onblur : function(e) {
			$('#summercontent').html($('#summernote').code());
		},
		height : 250, // set editor height
		minHeight : 100, // set minimum height of editor
		maxHeight : null, // set maximum height of editor
		lang : 'ko-KR' // default: 'en-US'
	});
	
	
	$('#addBlock').click(function (e) {
		var nextBlock = $('projectContent div').size()+1;
		var block = document.getElementById("");
		
		
		
		console.log(nextBlock);
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
	
		jQuery(function($) {
	        var panelList = $('#draggablePanelList');

	        panelList.sortable({
	            // Only make the .panel-heading child elements support dragging.
	            // Omit this to make then entire <li>...</li> draggable.
	            handle: '.panel-heading', 
	            update: function() {
	                $('.panel', panelList).each(function(index, elem) {
	                     var $listItem = $(elem),
	                         newIndex = $listItem.index();

	                     // Persist the new indices.
	                });
	            }
	        });
	    });
	
});







