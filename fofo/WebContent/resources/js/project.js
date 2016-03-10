/**
 * 
 */

/*
$(function () {
	
	
	
});*/


$(document).ready(function() {
	
	$('#addBlock').click(function(e) {
		var blockList = document.getElementById("blockList");
		
		/*$('<li class="panel panel-info">'
				+ '<div class="block">'
				+ '<div class="summernote"></div> '
				+ '<input class="btn btn-warning" type="button" value="수정">'
				+ '<input class="btn btn-danger" type="button" value="삭제">'
				+ '</div></li>').appendTo('#blockList');*/
		
		$('<li class="panel panel-info">'
				+ '<div class="block">'
				+ '<div class="blockContent"></div>'
				+ '<input class="btn btn-warning editBlockBtn" type="button" value="수정">'
				+ '<input class="btn btn-success editEndBlockBtn" type="button" value="완료" style="display: none;">'
				+ '<input class="btn btn-danger delBlockBtn" type="button" value="삭제">'
				+ '</div></li>').appendTo('#blockList');
		
	});	
	
	
	
	
	

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
	
	
	
	
	/*$('#draggablePanelList').sortable({
        tolerance: 'pointer',
        revert: 'invalid',
        forceHelperSize: true
    });*/
	
	
//	$('.draggablePanelList').sortable();

	
	
	
	
	
	/* draggable tab */
	
//	var panelList = $('#draggablePanelList');
	
	
	
	
	
//	jQuery(function($) {
//        
//
//        panelList.sortable({
//            // Only make the .panel-heading child elements support dragging.
//            // Omit this to make then entire <li>...</li> draggable.
//            handle: '.panel-heading', 
//            update: function() {
//                $('.panel', panelList).each(function(index, elem) {
//                     var $listItem = $(elem),
//                         newIndex = $listItem.index();
//
//                     // Persist the new indices.
//                });
//            }
//        });
//    });
	
});

jQuery(document).ready(function() {
	
	$('#blockList').sortable();
	
	$('.editBlockBtn').click(function(e){
		setEditMode($(this));
	});
	
	
	$('.endEditBlockBtn').click(function(e){
		endEditMode($(this));
	});
	
    /*jQuery("#abc_product_categories_sortable ul").sortable({
        cursor: 'move'
    });

    jQuery('#abc_product_categories_sortable ul').disableSelection();
    jQuery('#abc_product_categories_sortable li').disableSelection();*/
	
	
	
	
	function setEditMode($editBtn) {
		var contentObj = $editBtn.siblings(".blockContent");
		var content = $editBtn.siblings(".blockContent").innerHTML;
		
		var endEditBtn = $editBtn.siblings(".endEditBlockBtn");
		
		var block = $editBtn.parent();
		var editor = $('<div id="summernote" class="hi"></div>');
		$('#summernote').summernote('code', content);
		
		console.log("contentObj: " + contentObj);
		console.log("content: " + content);
		
//		$('<div id="summernote">'+ content +'</div>').appentTo($(this).parent());
		editor.insertBefore($editBtn);	//bug: 완료를 눌러도 생성됨. 영향은 없음
		$('#summernote').summernote();
		
		contentObj.remove();

		$editBtn.hide();
		endEditBtn.show();
	}
	
	function endEditMode($endEditBtn){
//		var block = $endEditBtn.parent();
		var content = $("#summernote").summernote('code');
		$('.note-editor').remove();
		
		var editBtn = $endEditBtn.siblings(".editBlockBtn");
		
		var newContent = $('<div class="blockContent">'+ content +'</div>');
//		newContent.insertBefore($endEditBtn);
		newContent.insertBefore(editBtn);
		
		console.log("content2: " + content);
		
		
		$('#summernote').remove();
		$endEditBtn.hide();
		editBtn.show();
	}
});






